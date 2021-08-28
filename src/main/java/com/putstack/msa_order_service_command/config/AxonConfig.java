package com.putstack.msa_order_service_command.config;

import java.util.ArrayList;
import java.util.List;

import com.putstack.msa_order_service_command.aggregate.OrderAggregate;

import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.AggregateSnapshotter;
import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.GenericAggregateFactory;
import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.modelling.command.Repository;
import org.axonframework.spring.stereotype.Aggregate;
import org.axonframework.springboot.autoconfig.AxonAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

@Configuration
@AutoConfigureAfter(AxonAutoConfiguration.class)
@Log4j2
public class AxonConfig {

    private final static int SNAPSHOT_THRESHOLD = 5; 
    
    @Bean
    public SimpleCommandBus commandBus(TransactionManager transactionManager) {
        log.debug("config {}", "AxonServerCommandBus -> SimpleCommandBus");
        return SimpleCommandBus.builder()
            .transactionManager(transactionManager)
            .build();
    }

    @Bean
    public List<AggregateFactory<?>> aggregateFactories(){
        List<AggregateFactory<?>> aggregateFactories = new ArrayList<AggregateFactory<?>>();
        aggregateFactories.add(new GenericAggregateFactory<>(OrderAggregate.class));
        return aggregateFactories;
    }

    @Bean
    public Snapshotter snapshotter(EventStore eventStore, TransactionManager transactionManager){

        List<AggregateFactory<?>> aggregateFactories = aggregateFactories();

        return AggregateSnapshotter
                .builder()
                .eventStore(eventStore)
                .aggregateFactories(aggregateFactories)
                .transactionManager(transactionManager)
                .build();
    }

    @Bean
    public SnapshotTriggerDefinition snapshotTriggerDefinition(Snapshotter snapshotter){
        return new EventCountSnapshotTriggerDefinition(snapshotter, SNAPSHOT_THRESHOLD);
    }

    @Bean
    public Repository<OrderAggregate> OrderAggregateRepository(EventStore eventStore, SnapshotTriggerDefinition snapshotTriggerDefinition){
        return EventSourcingRepository
                .builder(OrderAggregate.class)
                .eventStore(eventStore)
                .snapshotTriggerDefinition(snapshotTriggerDefinition)
                .build();
    }

}

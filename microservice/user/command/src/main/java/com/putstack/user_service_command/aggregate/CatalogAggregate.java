package com.putstack.catalog_service_command.aggregate;

import com.putstack.catalog_service_command.command.CatalogCancelCommand;
import com.putstack.catalog_service_command.command.CatalogCreationCommand;
import com.putstack.catalog_service_events.events.CatalogCancelEvent;
import com.putstack.catalog_service_events.events.CatalogCreationEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Aggregate
@Slf4j
public class CatalogAggregate {
    @AggregateIdentifier
    private String orderId;
    private String userId;
    private String productId;
    private int qty;
    private int unitPrice;
    private int totalPrice;

    @CommandHandler
    public CatalogAggregate(CatalogCreationCommand command) {
        log.debug("CommandHandler {}", command);
        
        AggregateLifecycle.apply(new CatalogCreationEvent(
            command.getCatalogId(), 
            command.getUserId(), 
            command.getProductId(), 
            command.getQty(), 
            command.getUnitPrice(), 
            command.getUnitPrice() * command.getQty()
        ));
    }

    @EventSourcingHandler
    public void createCatalog(CatalogCreationEvent event) {
        log.debug("AggregateLifecycle.apply {}", event);

        this.orderId = event.getCatalogId();
        this.userId = event.getUserId();
        this.productId = event.getProductId();
        this.qty = event.getQty();
        this.unitPrice = event.getUnitPrice();
        this.totalPrice = event.getTotalPrice();
    }

    @CommandHandler
    public void cancelCatalog(CatalogCancelCommand command) {
        log.debug("CommandHandler {}", command);

        AggregateLifecycle.apply(new CatalogCancelEvent(
            command.getCatalogId()
        ));
    }

    @EventSourcingHandler
    public void cancelCatalog(CatalogCancelEvent event) {
        log.debug("AggregateLifecycle.apply {}", event);

        this.orderId = event.getCatalogId();
        this.qty = 0;
        this.totalPrice = 0;
    }
}

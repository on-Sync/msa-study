package com.putstack.catalog_service_command.aggregate;

import com.putstack.catalog_service_command.command.ProductRegisterCommand;
import com.putstack.catalog_service_events.events.ProductRegisterEvent;

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
    private String productId;
    private String productName;
    private String sellerId;
    private int categoryCode;
    private int stock;
    private int unitPrice;

    @CommandHandler
    public CatalogAggregate(ProductRegisterCommand command) {
        log.debug("CommandHandler {}", command);
        
        AggregateLifecycle.apply(new ProductRegisterEvent(
            command.getProductId(), 
            command.getProductName(), 
            command.getSellerId(), 
            command.getCategoryCode(),
            command.getStock(), 
            command.getUnitPrice()
        ));
    }

    @EventSourcingHandler
    public void createCatalog(ProductRegisterEvent event) {
        log.debug("AggregateLifecycle.apply {}", event);

        this.productId = event.getProductId();
        this.productName = event.getProductName();
        this.sellerId = event.getSellerId();
        this.categoryCode = event.getCategoryCode();
        this.stock = event.getStock();
        this.unitPrice = event.getUnitPrice();
    }
}

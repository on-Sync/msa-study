package com.putstack.msa_order_service_command.aggregate;

import java.util.UUID;

import com.putstack.msa_order_service_command.command.OrderCancelCommand;
import com.putstack.msa_order_service_command.command.OrderCreationCommand;
import com.putstack.msa_order_service_command.events.OrderCancelEvent;
import com.putstack.msa_order_service_command.events.OrderCreationEvent;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@AllArgsConstructor
@Aggregate
@Log4j2
public class OrderAggregate {
    @AggregateIdentifier
    private String orderId;
    private String userId;
    private String productId;
    private int qty;
    private int unitPrice;
    private int totalPrice;

    @CommandHandler
    public OrderAggregate(OrderCreationCommand command) {
        log.debug("CommandHandler {}", command);
        
        AggregateLifecycle.apply(new OrderCreationEvent(
            UUID.randomUUID().toString(), 
            command.getUserId(), 
            command.getProductId(), 
            command.getQty(), 
            command.getUnitPrice(), 
            command.getUnitPrice() * command.getQty()
        ));
    }

    @EventSourcingHandler
    public void createOrder(OrderCreationEvent event) {
        log.debug("AggregateLifecycle.apply {}", event);

        this.orderId = event.getOrderId();
        this.userId = event.getUserId();
        this.productId = event.getProductId();
        this.qty = event.getQty();
        this.unitPrice = event.getUnitPrice();
        this.totalPrice = event.getTotalPrice();
    }

    @CommandHandler
    public void cancelOrder(OrderCancelCommand command) {
        log.debug("CommandHandler {}", command);

        AggregateLifecycle.apply(new OrderCancelEvent(
            command.getOrderId()
        ));
    }

    @EventSourcingHandler
    public void cancelOrder(OrderCancelEvent event) {
        log.debug("AggregateLifecycle.apply {}", event);

        this.orderId = event.getOrderId();
        this.qty = 0;
        this.totalPrice = 0;
    }
}

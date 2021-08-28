package com.putstack.msa_order_service_command.aggregate;

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

@AllArgsConstructor
@Aggregate
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
        AggregateLifecycle.apply(new OrderCreationEvent(
            command.getOrderId(), 
            command.getUserId(), 
            command.getProductId(), 
            command.getQty(), 
            command.getUnitPrice(), 
            command.getTotalPrice()
        ));
    }

    @EventSourcingHandler
    public void createOrder(OrderCreationEvent event) {
        this.orderId = event.getOrderId();
        this.userId = event.getUserId();
        this.productId = event.getProductId();
        this.qty = event.getQty();
        this.unitPrice = event.getUnitPrice();
        this.totalPrice = event.getTotalPrice();
    }

    @CommandHandler
    public void cancelOrder(OrderCancelCommand command) {
        AggregateLifecycle.apply(new OrderCancelEvent(
            command.getOrderId()
        ));
    }

    @EventSourcingHandler
    public void cancelOrder(OrderCancelEvent event) {
        this.orderId = event.getOrderId();
        this.qty = 0;
        this.totalPrice = 0;
    }
}

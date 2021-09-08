package com.putstack.order_service_common.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class OrderUpdateCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private String userId;
    private String productId;
    private int qty;
    private int unitPrice;
}

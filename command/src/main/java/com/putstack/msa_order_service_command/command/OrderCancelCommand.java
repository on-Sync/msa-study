package com.putstack.msa_order_service_command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class OrderCancelCommand {
    @TargetAggregateIdentifier
    private String orderId;
}

package com.putstack.catalog_service_common.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ProductSaleStopCommand {
    @TargetAggregateIdentifier
    private String productId;
}

package com.putstack.catalog_service_command.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class CatalogCreationCommand {
    @TargetAggregateIdentifier
    private String catalogId;
    private String userId;
    private String productId;
    private int qty;
    private int unitPrice;
}

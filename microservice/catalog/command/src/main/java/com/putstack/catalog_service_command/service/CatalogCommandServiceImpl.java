package com.putstack.catalog_service_command.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.putstack.catalog_service_command.command.ProductPurchaseCommand;
import com.putstack.catalog_service_command.command.ProductRegisterCommand;
import com.putstack.catalog_service_command.dto.ProductPurchaseDTO;
import com.putstack.catalog_service_command.dto.ProductRegisterDTO;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CatalogCommandServiceImpl implements CatalogCommandService {

    private final CommandGateway commandGateway;

    @AggregateIdentifier
    private String orderId;

    @Override
    public CompletableFuture<String> registerProduct(ProductRegisterDTO productDTO) {
        return commandGateway.send(new ProductRegisterCommand(
            UUID.randomUUID().toString(),
            productDTO.getProductName(), 
            productDTO.getSellerId(),
            productDTO.getCategoryCode(), 
            productDTO.getStock(),
            productDTO.getUnitPrice()
        ));
    }

    @Override
    public CompletableFuture<String> purchaseProduct(ProductPurchaseDTO productDTO) {
        return commandGateway.send(new ProductPurchaseCommand(
            productDTO.getProductId(),
            productDTO.getQty()
        ));
    }
}

package com.putstack.catalog_service_command.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.putstack.catalog_service_command.command.CatalogCancelCommand;
import com.putstack.catalog_service_command.command.CatalogCreationCommand;
import com.putstack.catalog_service_command.dto.CancelDTO;
import com.putstack.catalog_service_command.dto.CatalogDTO;

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
    public CompletableFuture<String> createCatalog(CatalogDTO orderDTO) {
        return commandGateway.send(new CatalogCreationCommand(
            UUID.randomUUID().toString(),
            orderDTO.getUserId(), 
            orderDTO.getProductId(), 
            orderDTO.getQty(), 
            orderDTO.getUnitPrice()
        ));
    }

    @Override
    public CompletableFuture<String> cancelCatalog(CancelDTO cancelDTO) {
        return commandGateway.send(new CatalogCancelCommand(
            cancelDTO.getCatalogId()
        ));
    }
}

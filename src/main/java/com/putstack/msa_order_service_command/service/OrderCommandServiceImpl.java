package com.putstack.msa_order_service_command.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.putstack.msa_order_service_command.command.OrderCancelCommand;
import com.putstack.msa_order_service_command.command.OrderCreationCommand;
import com.putstack.msa_order_service_command.dto.CancelDTO;
import com.putstack.msa_order_service_command.dto.OrderDTO;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderCommandServiceImpl implements OrderCommandService {

    private final CommandGateway commandGateway;

    @AggregateIdentifier
    private String orderId;

    @Override
    public CompletableFuture<String> createOrder(OrderDTO orderDTO) {
        return commandGateway.send(new OrderCreationCommand(
            UUID.randomUUID().toString(),
            orderDTO.getUserId(), 
            orderDTO.getProductId(), 
            orderDTO.getQty(), 
            orderDTO.getUnitPrice()
        ));
    }

    @Override
    public CompletableFuture<String> cancelOrder(CancelDTO cancelDTO) {
        return commandGateway.send(new OrderCancelCommand(
            cancelDTO.getOrderId()
        ));
    }
}

package com.putstack.msa_order_service_command.service;

import java.util.concurrent.CompletableFuture;

import com.putstack.msa_order_service_command.dto.CancelDTO;
import com.putstack.msa_order_service_command.dto.OrderDTO;

public interface OrderCommandService {
    CompletableFuture<String> createOrder(OrderDTO orderDTO);
    CompletableFuture<String> cancelOrder(CancelDTO cancelDTO);
}

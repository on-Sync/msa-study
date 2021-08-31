package com.putstack.msa_order_service.service;

import java.util.concurrent.CompletableFuture;

import com.putstack.msa_order_service.dto.CancelDTO;
import com.putstack.msa_order_service.dto.OrderDTO;

public interface OrderCommandService {
    CompletableFuture<String> createOrder(OrderDTO orderDTO);
    CompletableFuture<String> cancelOrder(CancelDTO cancelDTO);
}

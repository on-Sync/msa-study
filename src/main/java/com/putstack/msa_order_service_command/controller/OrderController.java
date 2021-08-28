package com.putstack.msa_order_service_command.controller;

import java.util.concurrent.CompletableFuture;

import com.putstack.msa_order_service_command.dto.CancelDTO;
import com.putstack.msa_order_service_command.dto.OrderDTO;
import com.putstack.msa_order_service_command.service.OrderService;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping(value="/orders")
    public CompletableFuture<String> createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @DeleteMapping(value="/orders")
    public CompletableFuture<String> cancelOrder(@RequestBody CancelDTO cancelDTO) {
        return orderService.cancelOrder(cancelDTO);
    }
}

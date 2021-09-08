package com.putstack.catalog_service_command.controller;

import java.util.concurrent.CompletableFuture;

import com.putstack.catalog_service_command.dto.CancelDTO;
import com.putstack.catalog_service_command.dto.CatalogDTO;
import com.putstack.catalog_service_command.service.CatalogCommandService;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class CatalogCommandController {
    private final CatalogCommandService orderService;

    @PostMapping(value="/orders")
    public CompletableFuture<String> createCatalog(@RequestBody CatalogDTO orderDTO) {
        return orderService.createCatalog(orderDTO);
    }

    @DeleteMapping(value="/orders/{orderId}")
    public CompletableFuture<String> cancelCatalog(@PathVariable String orderId) {
        return orderService.cancelCatalog(new CancelDTO(orderId));
    }
}

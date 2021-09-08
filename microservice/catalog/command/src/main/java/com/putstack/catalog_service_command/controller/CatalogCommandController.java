package com.putstack.catalog_service_command.controller;

import java.util.concurrent.CompletableFuture;

import com.putstack.catalog_service_command.dto.ProductPurchaseDTO;
import com.putstack.catalog_service_command.dto.ProductRegisterDTO;
import com.putstack.catalog_service_command.service.CatalogCommandService;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
public class CatalogCommandController {
    private final CatalogCommandService orderService;

    @PostMapping(value="/products")
    public CompletableFuture<String> createCatalog(@RequestBody ProductRegisterDTO registerDTO) {
        return orderService.registerProduct(registerDTO);
    }

    @PostMapping(value="/products/{productId}")
    public CompletableFuture<String> cancelCatalog(@PathVariable String productId, @RequestBody ProductPurchaseDTO registerDTO) {
        if (productId != registerDTO.getProductId()) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return orderService.purchaseProduct(registerDTO);
    }
}

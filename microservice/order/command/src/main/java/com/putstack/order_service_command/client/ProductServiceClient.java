package com.putstack.order_service_command.client;

import com.putstack.order_service_command.vo.ProductResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalog-service-query")
public interface ProductServiceClient {

    @GetMapping(path = "/products/{productId}")
    ProductResponse getProductInfo(@PathVariable String productId);
}

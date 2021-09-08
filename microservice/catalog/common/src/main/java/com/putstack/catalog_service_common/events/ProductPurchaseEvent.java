package com.putstack.catalog_service_common.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductPurchaseEvent {
    private String productId;
    private int qty;
}

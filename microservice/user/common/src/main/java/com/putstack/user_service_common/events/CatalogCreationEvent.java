package com.putstack.user_service_common.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CatalogCreationEvent {
    private String catalogId;
    private String userId;
    private String productId;
    private int qty;
    private int unitPrice;
    private int totalPrice;
}

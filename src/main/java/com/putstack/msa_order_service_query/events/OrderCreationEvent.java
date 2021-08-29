package com.putstack.msa_order_service_query.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCreationEvent {
    private String orderId;
    private String userId;
    private String productId;
    private int qty;
    private int unitPrice;
    private int totalPrice;
}

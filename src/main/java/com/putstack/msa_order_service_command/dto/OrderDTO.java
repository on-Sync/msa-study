package com.putstack.msa_order_service_command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderDTO {
    private String orderId;
    private String userId;
    private String productId;
    private int qty;
    private int unitPrice;
    private int totalPrice;
}

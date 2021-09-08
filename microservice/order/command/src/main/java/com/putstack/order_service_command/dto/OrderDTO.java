package com.putstack.order_service_command.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderDTO {
    private String userId;
    private String productId;
    private int qty;
    private int unitPrice;
}

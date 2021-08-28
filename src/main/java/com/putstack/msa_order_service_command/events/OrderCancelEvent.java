package com.putstack.msa_order_service_command.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCancelEvent {
    private String orderId;

}

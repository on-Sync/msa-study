package com.putstack.order_service_common.events;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OrderCancelEvent {
    private String orderId;
    private Date updateAt;

}

package com.putstack.catalog_service_common.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductRegisterEvent {
    private String productId;
    private String productName;
    private String sellerId;
    private int categoryCode;
    private int stock;
    private int unitPrice;
}

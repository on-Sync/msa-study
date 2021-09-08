package com.putstack.user_service_common.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CatalogCancelEvent {
    private String catalogId;

}

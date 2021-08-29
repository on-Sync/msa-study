package com.putstack.msa_order_service_query.projection;

import java.time.Instant;

import com.putstack.msa_order_service_query.entity.OrderEntity;
import com.putstack.msa_order_service_query.events.OrderCancelEvent;
import com.putstack.msa_order_service_query.events.OrderCreationEvent;
import com.putstack.msa_order_service_query.repository.OrderRepository;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.ResetHandler;
import org.axonframework.eventhandling.Timestamp;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
@ProcessingGroup(value = "orders")
public class OrderProjection {
    private final OrderRepository repository;

    private final static int ORDER_RECEIVED = 11;
    private final static int ORDER_CANCELED = 22;
    private final static int ORDER_DEPARTED = 33;
    private final static int ORDER_ARRIVED = 44;

    @EventHandler
    @AllowReplay
    public void on(OrderCreationEvent event, @Timestamp Instant instant) {
        log.debug("projection {}, timestamp : {}", event, instant.toString());

        OrderEntity entity = OrderEntity
                                .builder()
                                .orderId(event.getOrderId())
                                .userId(event.getUserId())
                                .productId(event.getProductId())
                                .qty(event.getQty())
                                .unitPrice(event.getUnitPrice())
                                .totalPrice(event.getTotalPrice())
                                .status(ORDER_RECEIVED)
                                .build();

        repository.save(entity);
    }

    @EventHandler
    @AllowReplay
    public void on(OrderCancelEvent event, @Timestamp Instant instant) {
        log.debug("projection {}, timestamp : {}", event, instant.toString());

        OrderEntity entity = OrderEntity
                                .builder()
                                .orderId(event.getOrderId())
                                .status(ORDER_CANCELED)
                                .build();

        repository.save(entity);
    }

    @ResetHandler
    private void resetOrderInfo() {
        log.debug("reset ReadModel<OrderEntity>");

        repository.deleteAll();
    }

    
}

package com.putstack.msa_order_service.service;

import org.axonframework.config.Configuration;
import org.axonframework.eventhandling.TrackingEventProcessor;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderQueryServiceImpl implements OrderQueryService {

    private final Configuration configuration;

    @Override
    public void reset() {
        configuration.eventProcessingConfiguration()
            .eventProcessorByProcessingGroup("orders", TrackingEventProcessor.class)
            .ifPresent(processor -> {
                processor.shutDown();
                processor.resetTokens();
                processor.start();
            });
    }
}

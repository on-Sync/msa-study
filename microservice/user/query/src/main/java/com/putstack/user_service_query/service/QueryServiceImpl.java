package com.putstack.user_service_query.service;

import com.putstack.user_service_query.entity.UserSummary;
import com.putstack.user_service_query.query.UserQuery;
import com.putstack.user_service_query.repository.UserRepository;

import org.axonframework.config.Configuration;
import org.axonframework.eventhandling.TrackingEventProcessor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QueryServiceImpl implements QueryService {

    private final Configuration configuration;
    private final UserRepository repository;
    private final QueryGateway gateway;

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

    @Override
    public UserSummary getUserInfo(String orderId) {
        return gateway.query(new UserQuery(orderId), UserSummary.class).join();
    }


}

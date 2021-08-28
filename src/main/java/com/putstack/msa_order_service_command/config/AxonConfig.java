package com.putstack.msa_order_service_command.config;

import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.springboot.autoconfig.AxonAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.log4j.Log4j2;

@Configuration
@AutoConfigureAfter(AxonAutoConfiguration.class)
@Log4j2
public class AxonConfig {
    @Bean
    SimpleCommandBus commandBus(TransactionManager transactionManager) {
        log.debug("config {}", "AxonServerCommandBus -> SimpleCommandBus");
        return SimpleCommandBus.builder()
            .transactionManager(transactionManager)
            .build();
    }
}

package com.putstack.user_service_command.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.putstack.user_service_command.dto.UserDTO;
import com.putstack.user_service_common.commands.UserCreationCommand;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final CommandGateway commandGateway;

    @AggregateIdentifier
    private String orderId;

    @Override
    public CompletableFuture<String> createUser(UserDTO userDTO) {
        return commandGateway.send(new UserCreationCommand(
            UUID.randomUUID().toString(),
            userDTO.getEmail(),
            userDTO.getPassword(),
            userDTO.getName(),
            userDTO.getAge(),
            userDTO.getAddress(),
            userDTO.getSsn()
        ));
    }
}

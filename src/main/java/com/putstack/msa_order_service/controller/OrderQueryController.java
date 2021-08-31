package com.putstack.msa_order_service.controller;

import com.putstack.msa_order_service.service.OrderQueryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderQueryController {
    private final OrderQueryService queryService;

    @PostMapping(path = "/reset")
    public ResponseEntity<?> reset() {
        queryService.reset();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

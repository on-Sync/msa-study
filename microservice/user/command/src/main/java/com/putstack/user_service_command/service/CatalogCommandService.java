package com.putstack.catalog_service_command.service;

import java.util.concurrent.CompletableFuture;

import com.putstack.catalog_service_command.dto.CancelDTO;
import com.putstack.catalog_service_command.dto.CatalogDTO;

public interface CatalogCommandService {
    CompletableFuture<String> createCatalog(CatalogDTO catalogDTO);
    CompletableFuture<String> cancelCatalog(CancelDTO cancelDTO);
}

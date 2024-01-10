package com.jijo.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        String id,
        String name,
        String description,
        BigDecimal price
) {
}

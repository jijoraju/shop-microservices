package com.jijo.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
public record ProductRequest(

        String name,
        String description,
        BigDecimal price
) {
}

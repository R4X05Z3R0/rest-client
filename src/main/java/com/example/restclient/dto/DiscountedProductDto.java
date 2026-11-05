package com.example.restclient.dto;

import java.math.BigDecimal;

public record DiscountedProductDto(
        String offerId,
        String name,
        BigDecimal price,
        String currency,
        String image) {
}

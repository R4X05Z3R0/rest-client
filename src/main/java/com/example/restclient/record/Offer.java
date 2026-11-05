package com.example.restclient.record;

import java.math.BigDecimal;

public record Offer(String ean, BigDecimal newPrice, String currency, double stock) {
}

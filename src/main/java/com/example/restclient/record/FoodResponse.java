package com.example.restclient.record;

import java.util.List;

public record FoodResponse(Store store, List<Clearance> clearances) {
}

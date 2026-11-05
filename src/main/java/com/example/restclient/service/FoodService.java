package com.example.restclient.service;

import com.example.restclient.dto.DiscountedProductDto;
import com.example.restclient.record.Clearance;
import com.example.restclient.record.FoodResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService{
    private final FoodClient client;

    public FoodService(FoodClient client){
        this.client = client;
    }

    public List<DiscountedProductDto> getDiscountedProducts(String storeId){
        FoodResponse response = client.fetch(storeId);
        return response.clearances().stream()
                .filter(clearance -> clearance.offer().stock() > 0)
                .map(this::toDto)
                .toList();
    }

    private DiscountedProductDto toDto(Clearance clearance){
        return new DiscountedProductDto(
                clearance.offer().ean(),
                clearance.product().description(),
                clearance.offer().newPrice(),
                clearance.offer().currency(),
                clearance.product().image()
        );
    }

}

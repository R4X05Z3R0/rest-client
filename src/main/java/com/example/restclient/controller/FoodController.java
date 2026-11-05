package com.example.restclient.controller;

import com.example.restclient.dto.DiscountedProductDto;
import com.example.restclient.record.FoodResponse;
import com.example.restclient.service.FoodClient;
import com.example.restclient.service.FoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {
    private final FoodClient client;
    private final FoodService service;

     public FoodController(FoodClient client, FoodService service){
         this.client = client;
         this.service = service;
     }

     @GetMapping("/api/offers/raw")
     public FoodResponse raw(@RequestParam("storeId") String storeId){
         return client.fetch(storeId);
     }

     @GetMapping("/api/offers")
    public List<DiscountedProductDto> offers(@RequestParam("storeId") String storeId){
         return service.getDiscountedProducts(storeId);
     }
}

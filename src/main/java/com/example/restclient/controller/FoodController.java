package com.example.restclient.controller;

import com.example.restclient.record.FoodResponse;
import com.example.restclient.service.FoodClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class FoodController {
    private final FoodClient client;

     public FoodController(FoodClient client){
         this.client = client;
     }

     @GetMapping("/api/offers/raw")
     public FoodResponse raw(@RequestParam("storeId") String storeId){
         return client.fetch(storeId);
     }
}

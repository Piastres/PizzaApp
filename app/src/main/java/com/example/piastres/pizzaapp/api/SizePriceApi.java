package com.example.piastres.pizzaapp.api;

import com.example.piastres.pizzaapp.pojo.Product_;
import com.example.piastres.pizzaapp.pojo.SizePrice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SizePriceApi {
    @GET("/good2.json")
    Call<SizePrice> getSizePrice();
}

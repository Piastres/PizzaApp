package com.example.piastres.pizzaapp.api;

import com.example.piastres.pizzaapp.pojo.Product;
import com.example.piastres.pizzaapp.pojo.SizePrice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TestApi {
    @GET("/goods2.json")
    Call<List<Product>> getData();

    @GET("/goods2.json")
    Call<List<SizePrice>> getSizePrice();
    //Call<SizePrice> getData();

}

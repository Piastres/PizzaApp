package com.example.piastres.pizzaapp.api;

import com.example.piastres.pizzaapp.pojo.Product_;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductApi {
    @GET("/good2.json")
    Call<List<Product_>> getProducts();
}

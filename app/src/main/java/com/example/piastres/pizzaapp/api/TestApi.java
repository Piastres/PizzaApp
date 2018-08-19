package com.example.piastres.pizzaapp.api;

import com.example.piastres.pizzaapp.pojo.Product;
import com.example.piastres.pizzaapp.pojo.Product_;
import com.example.piastres.pizzaapp.pojo.SizePrice;
import com.google.gson.JsonArray;

import java.util.List;
import java.util.Map;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface TestApi {
    @GET("/goods2.json")
    Call<List<Product>> getData();

    @GET("/goods2.json")
    Call<List<Product>> getJson(
            @QueryMap Map<String, String> options
    );

    @GET("/goods2.json")
    //Call<List<Product>> getCategory(
    io.reactivex.Observable<List<Product>> getCategory(
    //Call<Product> getCategory(
            //@QueryMap Map<String, String> options
            //@Query("gr_name") String gr_name
            //@Path("product") String grName
    );

    @GET("/goods2.json")
    Call<Product> getProduct();


    @GET("/goods2.json/product/{product_}")
    Call getProductData(
            @Path("product_") List<Product_> productData
    );
    //Call<List<Product_>> getProductData();

    @GET("/goods2.json")
    Call<List<SizePrice>> getSizePrice();
    //Call<SizePrice> getData();

}

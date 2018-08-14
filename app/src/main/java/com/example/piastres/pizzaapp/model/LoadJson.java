package com.example.piastres.pizzaapp.model;

import android.util.Log;

import com.example.piastres.pizzaapp.api.ProductApi;
import com.example.piastres.pizzaapp.api.ProductApi_;
import com.example.piastres.pizzaapp.api.SizePriceApi;
import com.example.piastres.pizzaapp.pojo.Product;
import com.example.piastres.pizzaapp.pojo.Product_;
import com.example.piastres.pizzaapp.pojo.SizePrice;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadJson {
    Logger log = LoggerFactory.getLogger(LoadJson.class);
    //static final String BASE_URL = "http://amopizza.ru";
    static final String BASE_URL = "https://github.com/benhowdle89/reqres/blob/master";

    //public static ProductApi getApi() {
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();


    //ProductApi productApi = retrofit.create(ProductApi.class);
        //return productApi;
    //}
    public void getRetrofitProduct_() {
        log.info("INFO: create retrofit");
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //ProductApi_ service = retrofit.create(ProductApi_.class);
        SizePriceApi service = retrofit.create(SizePriceApi.class);
    //Call<Product_> call = service.getProduct();
    Call<SizePrice> call = service.getSizePrice();
    //call.enqueue(new Callback<Product_>(){
    call.enqueue(new Callback<SizePrice>(){
        @Override
        public void onResponse(Call<SizePrice> call, Response<SizePrice> response) {
            try {

                log.info("INFO: " + response.isSuccessful());
                if (response.isSuccessful()) {
                    if (response.body() == null) {
                        log.error("ERROR: body is null");
                    } else log.info("INFO: not null");
                    log.info("INFO  id:" + response.body().getSize());
                    log.info("INFO name: " + response.body().getPrice());
                }
                else {
                    log.info("INGO: HOOI");
                }

            } catch (Exception e) {
                log.info("ERROR: onResponse. There is an error");
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(Call<SizePrice> call, Throwable t) {
            log.error("================================ERROR========================================================");
            log.error("ERROR: ", t);
        }
/*
        @Override
        public void onResponse(Call<Product_> call, Response<Product_> response) {
            try {
                if (response.body() == null){
                    log.error("ERROR: body is null");
                }
                else log.info("INFO: not null");

                log.info("INFO  id:" + response.body().getId());
                log.info("INFO name: " + response.body().getName());

            } catch (Exception e) {
                log.info("ERROR: onResponse. There is an error");
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(Call<Product_> call, Throwable t) {
            log.error("================================ERROR========================================================");
            log.error("ERROR: ", t);
            //  Log.d("onFailure", t.toString());
        }
*/
        //public void onResponse(Response<Product_> response, Retrofit retrofit) {        }
    });
    }
}

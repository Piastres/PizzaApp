package com.example.piastres.pizzaapp.model;

import com.example.piastres.pizzaapp.api.TestApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {
    static final String BASE_URL = "http://amopizza.ru/";

    public static TestApi getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        TestApi testApi = retrofit.create(TestApi.class);
        return testApi;
    }
}

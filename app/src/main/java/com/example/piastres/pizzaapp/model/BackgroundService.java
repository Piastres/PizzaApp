package com.example.piastres.pizzaapp.model;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.piastres.pizzaapp.pojo.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class BackgroundService extends IntentService {
    Logger log = LoggerFactory.getLogger(LoadJson.class);
    List<Product> AllProducts;
    List<String> allCategory = new ArrayList<>();
    public BackgroundService(){
        super("BackgroundService");
        log.info("+++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Call<List<Product>> call = Controller.getApi().getData();
        log.info("##########################################################");
        try {
            Response<List<Product>> result = call.execute();
            log.error("WOW " + result.code());
            if (result.isSuccessful()){
                log.info("INFO: isSuccessful!");
            }
            else log.error("ERROR: not Successful");
            AllProducts = result.body();
            for (Product products: AllProducts) {
                log.info("INFO: " + products.getGrName());
                allCategory.add(products.getGrName());
            }
        } catch (IOException t) {
            log.error("ERROR: ", t);
            t.printStackTrace();
        }
    }
}

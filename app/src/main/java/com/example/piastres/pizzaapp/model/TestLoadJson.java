package com.example.piastres.pizzaapp.model;


import com.example.piastres.pizzaapp.api.TestApi;
import com.example.piastres.pizzaapp.pojo.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestLoadJson {
    Logger log = LoggerFactory.getLogger(LoadJson.class);
        private static TestApi testApi;
        //List<SizePrice> posts;
        List<Product> AllProducts;
        public void TestLoad(){
            //Call<List<SizePrice>> call = Controller.getApi().getData();
            Call<List<Product>> call = Controller.getApi().getData();
            //call.enqueue(new Callback<List<SizePrice>>() {
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    if (response.isSuccessful()) {
                        if (response.body() == null) {
                            log.error("ERROR: body is null");
                        } else log.info("INFO: not null");
                        AllProducts = response.body();
                        //posts.addAll(response.body());
                        log.info("INFO: size = " + AllProducts.size());
                        //log.info("INFO: array = " + posts.toString());
                        if (AllProducts != null && AllProducts.size()>0) {
                            for (int i = 0; i < AllProducts.size(); i++) {
                                log.info("INFO: " + AllProducts.get(i).getGrName());
                                log.info("INFO: " + AllProducts.get(i).getProducts().toString());
                            }
                            //get values
                        }

                    }
                    else {
                        log.info("INGO: HOOI");
                    }
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {

                }
                });

//                @Override
//                public void onResponse(Call<List<SizePrice>> call, Response<List<SizePrice>> response) {
//                    if (response.isSuccessful()) {
//                        if (response.body() == null) {
//                            log.error("ERROR: body is null");
//                        } else log.info("INFO: not null");
//                        posts = response.body();
//                        //posts.addAll(response.body());
//                        log.info("INFO: size = " + posts.size());
//                        //log.info("INFO: array = " + posts.toString());
//                        if (posts != null && posts.size()>0) {
//                            for (int i = 0; i < posts.size(); i++) {
//                                log.info("INFO: " + posts.get(i).getSize());
//                            }
//                            //get values
//                        }
//
//                    }
//                    else {
//                        log.info("INGO: HOOI");
//                    }
//
//                }
//
//                @Override
//                public void onFailure(Call<List<SizePrice>> call, Throwable t) {
//                    log.info("ERROR: onResponse. There is an error");
//                    t.printStackTrace();
//                }
//
//            });
        }

}

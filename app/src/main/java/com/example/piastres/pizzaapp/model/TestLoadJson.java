package com.example.piastres.pizzaapp.model;


import com.example.piastres.pizzaapp.api.TestApi;
import com.example.piastres.pizzaapp.pojo.Product;
import com.example.piastres.pizzaapp.pojo.Product_;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestLoadJson {

//    Gson gson = new Gson();
//    JsonArray jsonArray = TestApi.getJson();
//    Product m= gson.fromJson(jsonArray.toString(),Product.class);

    Logger log = LoggerFactory.getLogger(LoadJson.class);
        private static TestApi testApi;
        //List<SizePrice> posts;
        List<Product> AllProducts;
        List<String> allCategory;
        //show all category
        public List<String> getAllCategory(){

            allCategory = new ArrayList<>();
            Call<List<Product>> call = Controller.getApi().getData();
            log.info("##########################################################");
            //asynchronously
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    log.info("*******************************************************************************");
                    if (response.isSuccessful()) {
                        if (response.body() == null) {
                            log.error("ERROR: body is null");
                        } else log.info("INFO: not null");
                        //allCategory = new ArrayList<>();
                        AllProducts = response.body();
                        log.info("INFO: size = " + AllProducts.size());
                        if (AllProducts != null && AllProducts.size()>0) {
                            for (Product products: AllProducts) {
                                log.info("INFO: " + products.getGrName());
                                allCategory.add(products.getGrName());
                            }
                        }

                    }
                    else {
                        log.info("INGO: HOOI");
                    }
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                    log.error("ERROR: onResponse. There is an error", t);
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

            return allCategory;
        }





        //show one category
    public void ShowOneCategory(){


            //String str = "Паста";
            Map<String, String> data = new HashMap<>();
            data.put("gr_name", "Паста");
            //Call<Product> call = Controller.getApi().getCategory(str);
            //Call<List<Product>> call = Controller.getApi().getCategory(str);
            Call<List<Product>> call = Controller.getApi().getJson(data);
            //Call<Product> call = Controller.getApi().getProduct();
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    log.info("*******************************************************************************");
                    if (response.isSuccessful()) {
                        if (response.body() == null) {
                            log.error("ERROR: body is null");
                        } else log.info("INFO: not null");
                        AllProducts = response.body();
                        List<Product_> hooi = AllProducts.get(1).getProducts();
                        log.info("INFO: id = " + hooi.get(1).getId());
                        log.info("INFO: size = " + AllProducts.size());
                    }
                    else {
                        log.info("INGO: HOOI");
                    }
                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                    log.error("ERROR: onResponse. There is an error", t);
                    t.printStackTrace();
                }

//                call.enqueue(new Callback<Product>() {
//                @Override
//                public void onResponse(Call<Product> call, Response<Product> response) {
//                    log.info("*******************************************************************************");
//                    if (response.isSuccessful()) {
//                        if (response.body() == null) {
//                            log.error("ERROR: body is null");
//                        } else log.info("INFO: not null");
//                        //Product pr = new Product();
//                        //String srtGrName = response.body();
//                        //log.info("INFO: name = " + pr.getGrName());
//                        log.info("INFO: name = " + response.body().getGrName());
//                    }
//                    else {
//                        log.info("INGO: HOOI");
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<Product> call, Throwable t) {
//                    log.error("ERROR: onResponse. There is an error", t);
//                    t.printStackTrace();
//                }


            });
    }


}

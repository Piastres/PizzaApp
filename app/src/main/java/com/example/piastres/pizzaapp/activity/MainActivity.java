package com.example.piastres.pizzaapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.piastres.pizzaapp.R;
import com.example.piastres.pizzaapp.api.ProductApi;
import com.example.piastres.pizzaapp.model.LoadJson;
import com.example.piastres.pizzaapp.model.TestLoadJson;
import com.example.piastres.pizzaapp.pojo.Product;
import com.example.piastres.pizzaapp.pojo.Product_;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //private static ProductApi productApi;
    //RecyclerView recyclerView;
    //List<List<Product_>> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger log = LoggerFactory.getLogger(MainActivity.class);
        setContentView(R.layout.activity_main);
        log.info("INFO: call LoadJson");
        TestLoadJson testLoadJson = new TestLoadJson();
        testLoadJson.TestLoad();
        //LoadJson loadJson = new LoadJson();
        //loadJson.getRetrofitProduct();
        //loadJson.getRetrofitProduct_();
        //productApi = LoadJson.getApi();
        //products = new ArrayList<>();


    }
}

package com.example.piastres.pizzaapp.activity;

import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.ColorSpace;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

//import com.example.piastres.pizzaapp.R;
//import com.example.piastres.pizzaapp.R;
import com.example.piastres.pizzaapp.R;
import com.example.piastres.pizzaapp.adapter.SwipeLayoutAdapter;
import com.example.piastres.pizzaapp.model.Controller;
import com.example.piastres.pizzaapp.model.TestLoadJson;
import com.example.piastres.pizzaapp.pojo.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {
//public class MenuActivity extends FragmentActivity {
    ViewPager viewPager;
    Logger log = LoggerFactory.getLogger(MenuActivity.class);
    public static ArrayList<Object> allCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        List<String> categoryList;
////        categoryList = getAllCategory();
//        log.info("INFO: call LoadJson");
//        log.info("INFO: ******************************************************");
//        TestLoadJson testLoadJson = new TestLoadJson();
////        testLoadJson.getAllCategory();
//        categoryList = testLoadJson.getAllCategory();
//        log.info("INFO: " + categoryList.size());
//        log.info("INFO: ******************************************************");


        //testLoadJson.getAllCategory();
        //testLoadJson.ShowOneCategory();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //
        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        allCategory = (ArrayList<Object>) args.getSerializable("ARRAYLIST");
        log.info("INFO: transfer list =" + allCategory.toString());
        //SwipeLayoutAdapter adapter = new SwipeLayoutAdapter(getSupportFragmentManager());
        SwipeLayoutAdapter adapter = new SwipeLayoutAdapter(this);
        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);


    }
    @Override
    public void onBackPressed() {
        // do nothing
    }



}

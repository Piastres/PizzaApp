package com.example.piastres.pizzaapp.activity;

import android.app.ActionBar;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorSpace;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;

import com.example.piastres.pizzaapp.R;
import com.example.piastres.pizzaapp.adapter.SwipeLayoutAdapter;
import com.example.piastres.pizzaapp.api.TestApi;
import com.example.piastres.pizzaapp.model.BackgroundService;
import com.example.piastres.pizzaapp.model.Controller;
import com.example.piastres.pizzaapp.model.TestLoadJson;
import com.example.piastres.pizzaapp.pojo.Product;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.subjects.BehaviorSubject;
import me.zhanghai.android.materialprogressbar.IndeterminateCircularProgressDrawable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Logger log = LoggerFactory.getLogger(MainActivity.class);
    private ProgressBar progressBar;
    private ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
       // progressBar.setIndeterminateDrawable(new IndeterminateCircularProgressDrawable(this));
        // Get the Drawable custom_progressbar
        //progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.circle));
       /*
        Drawable draw = getResources().getDrawable(R.drawable.circle);
        progressBar.setProgressDrawable(draw);
        */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        };

        new Thread(runnable).start();
        //new LengthyTask().execute();

        log.info("INFO ******************************** START MAIN");
        getAllCategory();
        //HttpRequestTask httpRequestTask = new HttpRequestTask();
        //TestLoadJson testLoadJson = new TestLoadJson();
        //testLoadJson.getAllCategory();
//        log.info("INFO ******************************** INTENT START");
//        Intent intent = new Intent(MainActivity.this, BackgroundService.class);
//        startService(intent);
//        log.info("INFO ******************************** INTENT END");
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(MainActivity.this,MenuActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },3000);
    }

//    public class getJsonData{
//        public void getJsonData(){
//            allCategory = new ArrayList<>();
//            Observable<List<Product>> call = Controller.getApi().getCategory();
//
//
//
//
//            //Call<List<Product>> call = Controller.getApi().getData();
//            log.info("##########################################################");
//            //asynchronously
//            call.enqueue(new Callback<List<Product>>() {
//                @Override
//                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
//                    log.info("*******************************************************************************");
//                    if (response.isSuccessful()) {
//                        if (response.body() == null) {
//                            log.error("ERROR: body is null");
//                        } else log.info("INFO: not null");
//                        //allCategory = new ArrayList<>();
//                        AllProducts = response.body();
//                        log.info("INFO: size = " + AllProducts.size());
//                        if (AllProducts != null && AllProducts.size()>0) {
//                            for (Product products: AllProducts) {
//                                log.info("INFO: " + products.getGrName());
//                                allCategory.add(products.getGrName());
//                            }
//                        }
//
//                    }
//                    else {
//                        log.info("INGO: HOOI");
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<List<Product>> call, Throwable t) {
//                    log.error("ERROR: onResponse. There is an error", t);
//                }
//            });
//        }
//    }



    class DoWork extends AsyncTask<Void, Void, Void>{
        Context context;

        public DoWork(Context con){
            this.context = con;
        }

        @Override
        protected Void doInBackground(Void... params) {
            progressBar.setVisibility(ProgressBar.VISIBLE);

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            progressBar.setVisibility(View.INVISIBLE);
            super.onPostExecute(result);
        }
    }


    private class LengthyTask extends AsyncTask<Object, Integer, Object> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            log.error("HAHHAHAHAHHHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected Object doInBackground(Object... params) {
            // do the hard work here
            // call publishProgress() to make any update in the UI
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            // called from publishProgress(), you can update the UI here
            // for example, you can update the dialog progress
            // m_dialog.setProgress(values[0]); --> no apply here, because we made it indeterminate
        }

        @Override
        protected void onPostExecute(Object result) {
            super.onPostExecute(result);

            //progressBar.setVisibility(ProgressBar.VISIBLE);
            //do any other UI related task
        }
    }

    List<Product> AllProducts;
    List<String> allCategory;
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
                    //Intent passSize = new Intent(MainActivity.this, MenuActivity.class);

                    log.info("INFO: size = " + AllProducts.size());
                    if (AllProducts != null && AllProducts.size()>0) {
                        for (Product products: AllProducts) {
                            log.info("INFO: " + products.getGrName());
                            allCategory.add(products.getGrName());
                        }
                        Intent intent=new Intent(MainActivity.this,MenuActivity.class);
                        Bundle args = new Bundle();
                        //args.putSerializable("ARRAYLIST",(Serializable)allCategory);
                        args.putSerializable("ARRAYLIST",(Serializable)allCategory);
                        //args.putParcelableArrayList("Birds", allCategory);
                        intent.putExtra("BUNDLE",args);
                        //intent.putExtra(allCategory.toArray());
                        startActivity(intent);
                    }

                }
                else {
                    log.error("ERROR: response is not successful");
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


//    private class HttpRequestTask extends AsyncTask<Void, Void, Void> {
//        List<Product> AllProducts;
//        List<String> allCategory;
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            log.info("INFO: AsyncTask START");
//        }
//        @Override
//        protected Void doInBackground(Void... params) {
//            Call<List<Product>> call = Controller.getApi().getData();
//            log.info("##########################################################");
//            try {
//                Response<List<Product>> result = call.execute();
//                log.error("WOW " + result.code());
//                if (result.isSuccessful()){
//                    log.info("INFO: isSuccessful!");
//                }
//                else log.error("ERROR: not Successful");
//                AllProducts = result.body();
//                for (Product products: AllProducts) {
//                    log.info("INFO: " + products.getGrName());
//                    allCategory.add(products.getGrName());
//                }
//            } catch (IOException t) {
//                log.error("ERROR: ", t);
//                t.printStackTrace();
//            }
//
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            super.onPostExecute(result);
//            log.info("INFO: AsyncTask END");
//            //System.out.println(listOfPlaces.size()); // здесь размер выводится
//        }
//    }
}

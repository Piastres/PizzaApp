package com.example.piastres.pizzaapp.model;

import com.example.piastres.pizzaapp.api.TestApi;
import com.example.piastres.pizzaapp.pojo.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {
    static final String BASE_URL = "http://amopizza.ru/";

    public static Logger log = LoggerFactory.getLogger(Controller.class);


    public static TestApi getApi() {

                OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                .build();


        TestApi testApi = retrofit.create(TestApi.class);
        return testApi;
    }


//
//    public static Observable<List<Product>> observableRetrofit;
//    private static BehaviorSubject<List<Product>> catalogList;
//    public static rx.Subscription subscription;
//
//    public static void resertCatalog() {
//        catalogList = BehaviorSubject.create();
//
//        observableRetrofit = Controller.getApi().getCategory();
//        if (subscription != null && !subscription.isUnsubscribed()) {
//            subscription.unsubscribe();
//        }
//        subscription = observableRetrofit.subscribe(new Subscriber<List<Product>>() {
//            @Override
//            public void onCompleted() {
//                //do nothing
//                log.info("INFO: COMPLETED");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                catalogList.onError(e);
//            }
//
//            @Override
//            public void onComplete() {
//                //do nothing
//            }
//
//            @Override
//            public void onSubscribe(Subscription s) {
//
//            }
//
//            @Override
//            public void onNext(List<Product> products) {
//                catalogList.onNext(products);
//            }
//        });
//    }
//
//
//    public static Observable<List<Product>> getCatalog(){
//        if (catalogList == null){
//            resertCatalog();
//        }
//        return catalogList;
//    }


    //show all category
//    public List<String> getAllCategory(){
//
//        allCategory = new ArrayList<>();
//        Call<List<Product>> call = Controller.getApi().getData();
//        log.info("##########################################################");
//        try {
//            AllProducts = call.execute().body();
//            for (Product products: AllProducts) {
//                log.info("INFO: " + products.getGrName());
//                allCategory.add(products.getGrName());
//            }
//        } catch (IOException t) {
//            log.error("ERROR: ", t);
//            t.printStackTrace();
//        }
//        return allCategory;
//    }
}

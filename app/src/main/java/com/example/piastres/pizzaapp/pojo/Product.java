
package com.example.piastres.pizzaapp.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("gr_name")
    @Expose
    private String grName;
    @SerializedName("products")
    @Expose
    private List<Product_> products = null;

    public String getGrName() {
        return grName;
    }

    public void setGrName(String grName) {
        this.grName = grName;
    }


    public List<Product_> getProducts() {
        return products;
    }

    public void setProducts(List<Product_> products) {
        this.products = products;
    }

}

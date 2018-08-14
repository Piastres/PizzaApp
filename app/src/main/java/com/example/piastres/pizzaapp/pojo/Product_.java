
package com.example.piastres.pizzaapp.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product_ {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("img_url")
    @Expose
    private String imgUrl;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("label_text")
    @Expose
    private String labelText;
    @SerializedName("label_color")
    @Expose
    private String labelColor;
    @SerializedName("size_price")
    @Expose
    private List<SizePrice> sizePrice = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public String getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(String labelColor) {
        this.labelColor = labelColor;
    }

    public List<SizePrice> getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(List<SizePrice> sizePrice) {
        this.sizePrice = sizePrice;
    }

}

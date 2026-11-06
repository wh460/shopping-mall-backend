package com.cafuc.shopping.bean;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

@TableName("goods")
public class Goods implements Serializable {
    private Integer id;
    private String name;
    private String image;
    private Integer price;

    public Goods() {
    }

    public Goods(String name,String image,Integer price) {
        this.name = name;
        this.image = image;
        this.price = price;


    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
package com.group2.shop.domain;

/**
 * good类
 * @author Honmono
 * @date 2021/10/22 - 19:12
 */
public class Good {
    private int g_id;//商品id
    private String g_name;//商品名
    private double g_price;//商品价格
    private int g_stock;//商品库存
    private String g_type;//商品类型
    private String g_img;//商品图片(图片文件名)
    private String g_introduce;//商品介绍

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public double getG_price() {
        return g_price;
    }

    public void setG_price(double g_price) {
        this.g_price = g_price;
    }

    public int getG_stock() {
        return g_stock;
    }

    public void setG_stock(int g_stock) {
        this.g_stock = g_stock;
    }

    public String getG_type() {
        return g_type;
    }

    public void setG_type(String g_type) {
        this.g_type = g_type;
    }

    public String getG_img() {
        return g_img;
    }

    public void setG_img(String g_img) {
        this.g_img = g_img;
    }

    public String getG_introduce() {
        return g_introduce;
    }

    public void setG_introduce(String g_introduce) {
        this.g_introduce = g_introduce;
    }

    @Override
    public String toString() {
        return "Good{" +
                "g_id=" + g_id +
                ", g_name='" + g_name + '\'' +
                ", g_price=" + g_price +
                ", g_stock=" + g_stock +
                ", g_type='" + g_type + '\'' +
                ", g_img='" + g_img + '\'' +
                ", g_introduce='" + g_introduce + '\'' +
                '}';
    }
}

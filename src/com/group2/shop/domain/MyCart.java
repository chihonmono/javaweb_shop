package com.group2.shop.domain;

/**
 * good类
 * @author Honmono
 * @date 2021/10/22 - 19:12
 */
public class MyCart {
    private int c_id;//购物车id
    private int u_id;//用户id
    private int g_id;//商品id
    private int c_num;//商品数量
    private double c_totalPrice;//总价
    private String g_name;//商品名
    private double g_price;//商品价格
    private String g_img;//商品图片(图片文件名)

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public int getC_num() {
        return c_num;
    }

    public void setC_num(int c_num) {
        this.c_num = c_num;
    }

    public double getC_totalPrice() {
        return c_totalPrice;
    }

    public void setC_totalPrice(double c_totalPrice) {
        this.c_totalPrice = c_totalPrice;
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

    public String getG_img() {
        return g_img;
    }

    public void setG_img(String g_img) {
        this.g_img = g_img;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "c_id=" + c_id +
                ", u_id=" + u_id +
                ", g_id=" + g_id +
                ", c_num=" + c_num +
                ", c_totalPrice=" + c_totalPrice +
                ", g_name='" + g_name + '\'' +
                ", g_price=" + g_price +
                ", g_img='" + g_img + '\'' +
                '}';
    }
}

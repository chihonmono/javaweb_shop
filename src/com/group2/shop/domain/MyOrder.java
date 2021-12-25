package com.group2.shop.domain;

import java.util.Date;

/**
 * @author Honmono
 * @date 2021/10/23 - 16:22
 */
public class MyOrder {
    private int o_id;//订单id
    private int u_id;//用户id
    private int g_id;//商品id
    private int o_num;//购买数量
    private double o_totalPrice;//订单总价
    private Date o_time;//订单时间
    private int o_status;//订单状态
    private String g_name;//商品名称
    private double g_price;//商品单价
    private String g_img;//商品图片路径

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
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

    public int getO_num() {
        return o_num;
    }

    public void setO_num(int o_num) {
        this.o_num = o_num;
    }

    public double getO_totalPrice() {
        return o_totalPrice;
    }

    public void setO_totalPrice(double o_totalPrice) {
        this.o_totalPrice = o_totalPrice;
    }

    public Date getO_time() {
        return o_time;
    }

    public void setO_time(Date o_time) {
        this.o_time = o_time;
    }

    public int getO_status() {
        return o_status;
    }

    public void setO_status(int o_status) {
        this.o_status = o_status;
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
        return "MyOrder{" +
                "o_id=" + o_id +
                ", u_id=" + u_id +
                ", g_id=" + g_id +
                ", o_num=" + o_num +
                ", o_totalPrice=" + o_totalPrice +
                ", o_time=" + o_time +
                ", o_status=" + o_status +
                ", g_name='" + g_name + '\'' +
                ", g_price=" + g_price +
                ", g_img='" + g_img + '\'' +
                '}';
    }
}

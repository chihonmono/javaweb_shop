package com.group2.shop.dao;

import com.group2.shop.domain.MyCart;

import java.util.List;

/**
 * 购物车dao接口
 * @author Honmono
 * @date 2021/10/29 - 15:09
 */
public interface CartDao {
    /**
     * 查询商品是否已存在于购物车
     * @param u_id
     * @param g_id
     * @return
     */
    int confirmIfInCart(int u_id, int g_id);

    /**
     * 插入新的购物车数据
     * @param u_id
     * @param g_id
     * @param c_num
     * @param c_totalPrice
     */
    void insertCart(int u_id, int g_id, int c_num, Double c_totalPrice);

    /**
     * 更新现有的购物车数据
     * @param c_id
     * @param c_num
     * @param g_price
     */
    void updateCart(int c_id, int c_num, Double g_price);

    /**
     * 根据用户id查询所有购物车数据
     * @param u_id
     * @return
     */
    List<MyCart> findMyCartByu_id(int u_id);

    /**
     * 根据购物车id删除购物车
     * @param c_id
     */
    void deleteCart(int c_id);
}

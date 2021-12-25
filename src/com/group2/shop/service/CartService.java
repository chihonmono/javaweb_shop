package com.group2.shop.service;

import com.group2.shop.domain.MyCart;

import java.util.List;

/**
 * 购物车service接口
 * @author Honmono
 * @date 2021/10/29 - 15:08
 */
public interface CartService {
    /**
     * 加入购物车service
     * @param u_id
     * @param g_id
     * @param c_num
     * @param g_price
     */
    void addIntoCart(int u_id, int g_id, int c_num, Double g_price);

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

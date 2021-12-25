package com.group2.shop.service.Impl;

import com.group2.shop.dao.CartDao;
import com.group2.shop.dao.Impl.CartDaoImpl;
import com.group2.shop.domain.MyCart;
import com.group2.shop.service.CartService;

import java.util.List;

/**
 * 购物车service实现类
 * @author Honmono
 * @date 2021/10/29 - 15:08
 */
public class CartServiceImpl implements CartService {
    CartDao dao = new CartDaoImpl();

    /**
     * 加入购物车service
     * @param u_id
     * @param g_id
     * @param c_num
     * @param g_price
     */
    @Override
    public void addIntoCart(int u_id, int g_id, int c_num, Double g_price) {
        //查询商品是否已存在于购物车
        int c_id = dao.confirmIfInCart(u_id, g_id);
        if (c_id == 0){//不存在
            //插入新的购物车数据
            dao.insertCart(u_id,g_id,c_num,g_price);
        } else {//存在
            //更新现有购物车数据
            dao.updateCart(c_id,c_num,g_price);
        }

    }

    /**
     * 根据用户id查询所有购物车数据
     * @param u_id
     * @return
     */
    @Override
    public List<MyCart> findMyCartByu_id(int u_id) {
        return dao.findMyCartByu_id(u_id);
    }

    /**
     * 根据购物车id删除购物车
     * @param c_id
     */
    @Override
    public void deleteCart(int c_id) {
        dao.deleteCart(c_id);
    }

}

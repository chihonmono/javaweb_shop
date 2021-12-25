package com.group2.shop.dao;

import com.group2.shop.domain.MyOrder;
import com.group2.shop.domain.Order;

import java.util.List;

/**
 * Order对象dao接口
 * @author Honmono
 * @date 2021/10/23 - 18:39
 */
public interface OrderDao {
    /**
     * 插入order
     * @param order
     */
    void insertOrder(Order order);

    /**
     * 查找最后一条订单记录
     * @return
     */
    Order findLastOrder();

    /**
     * 根据o_id更新订单状态
     * @param o_id
     */
    void updateStatusById(int o_id,int newStatus);

    /**
     * 根据o_id查找订单
     * @return
     */
    Order findOrderById(int o_id);

    /**
     * 根据用户id查询所有订单
     * @param u_id
     * @return
     */
    List<MyOrder> findOrdersByu_id(int u_id);
}

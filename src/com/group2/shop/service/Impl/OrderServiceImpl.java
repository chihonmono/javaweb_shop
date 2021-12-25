package com.group2.shop.service.Impl;

import com.group2.shop.dao.Impl.OrderDaoImpl;
import com.group2.shop.dao.OrderDao;
import com.group2.shop.domain.MyOrder;
import com.group2.shop.domain.Order;
import com.group2.shop.service.OrderService;

import java.util.List;

/**
 * order对象service实现类
 * @author Honmono
 * @date 2021/10/23 - 18:39
 */
public class OrderServiceImpl implements OrderService {
    OrderDao dao = new OrderDaoImpl();

    /**
     * 插入新订单
     * @param order
     */
    @Override
    public void insertOrder(Order order) {
        dao.insertOrder(order);
    }

    /**
     * 查询最后一个订单
     * @return
     */
    @Override
    public Order findLastOrder() {
        return dao.findLastOrder();
    }

    /**
     * 根据订单id更新订单状态o_status
     */
    @Override
    public void updateStatusById(int o_id,int newStatus) {
        dao.updateStatusById(o_id,newStatus);
    }

    /**
     * 根据订单id查询订单
     * @param o_id
     * @return
     */
    @Override
    public Order findOrderById(int o_id) {
        return dao.findOrderById(o_id);
    }

    /**
     * 根据用户id查询所有订单
     * @param u_id
     * @return
     */
    @Override
    public List<MyOrder> findOrdersByu_id(int u_id) {
        return dao.findOrdersByu_id(u_id);
    }
}

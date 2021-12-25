package com.group2.shop.service;

import com.group2.shop.dao.Impl.OrderDaoImpl;
import com.group2.shop.dao.OrderDao;
import com.group2.shop.domain.MyOrder;
import com.group2.shop.domain.Order;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * order对象service接口
 * @author Honmono
 * @date 2021/10/23 - 18:38
 */
public interface OrderService {
    /**
     * 插入order
     * @param order
     */
    void insertOrder(Order order);

    /**
     * 查找最新的订单记录
     */
    Order findLastOrder();

    /**
     * 根据o_id更新订单状态o_status
     */
    void updateStatusById(int o_id,int newStatus);

    /**
     * 根据o_id查找订单
     * @return
     */
    Order findOrderById(int o_id);

    /**
     * 根据u_id查询订单数据
     * @param u_id
     * @return
     */
    List<MyOrder> findOrdersByu_id(int u_id);
}

package com.group2.shop.dao.Impl;

import com.group2.shop.dao.OrderDao;
import com.group2.shop.domain.MyOrder;
import com.group2.shop.domain.Order;
import com.group2.shop.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Honmono
 * @date 2021/10/23 - 18:40
 */
public class OrderDaoImpl implements OrderDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 插入新订单
     * @param order
     */
    @Override
    public void insertOrder(Order order) {
        //定义SQL
        String sql = "insert into orders values(null,?,?,?,?,?,?)";
        //执行SQL
        template.update(sql,order.getU_id(),order.getG_id(),order.getO_num(),order.getO_totalPrice(),order.getO_time(),order.getO_status());
    }

    /**
     * 查询最后一个订单
     * @return
     */
    @Override
    public Order findLastOrder() {
        //定义SQL
        String sql = "select * from orders order by o_id DESC limit 1";
        //执行SQL
        Order order = template.queryForObject(sql, new BeanPropertyRowMapper<>(Order.class));
        return order;
    }

    /**
     * 根据o_id更新订单状态o_status
     * @param o_id
     */
    @Override
    public void updateStatusById(int o_id,int newStatus) {
        //定义SQL
        String sql = "UPDATE orders SET o_status = ? WHERE o_id = ?";
        //执行SQL
        template.update(sql,newStatus,o_id);

    }

    @Override
    public Order findOrderById(int o_id) {
        //定义SQL
        String sql = "select * from orders where o_id = ?";
        //执行SQL
        Order order = template.queryForObject(sql, new BeanPropertyRowMapper<>(Order.class), o_id);
        return order;
    }

    @Override
    public List<MyOrder> findOrdersByu_id(int u_id) {
        //定义SQL
        String sql = "SELECT orders.*,good.`g_name`,good.`g_price`,good.`g_img` FROM orders,good WHERE orders.g_id = good.g_id AND u_id = ?";
        //执行SQL
        return template.query(sql, new BeanPropertyRowMapper<MyOrder>(MyOrder.class), u_id);
    }
}
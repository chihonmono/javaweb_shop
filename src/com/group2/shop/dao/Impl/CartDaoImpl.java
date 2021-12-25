package com.group2.shop.dao.Impl;

import com.group2.shop.dao.CartDao;
import com.group2.shop.domain.MyCart;
import com.group2.shop.utils.JDBCUtils;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 购物车dao实现类
 * @author Honmono
 * @date 2021/10/29 - 15:09
 */
public class CartDaoImpl implements CartDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询商品是否已存在于购物车
     * @param u_id
     * @param g_id
     * @return
     */
    @Override
    public int confirmIfInCart(int u_id, int g_id) {
        //定义SQL
        String sql = "select count(*) from cart where u_id = ? and g_id = ?";
        //执行SQL
        Integer count = template.queryForObject(sql, Integer.class, u_id, g_id);//返回记录数
        if (count > 0){//存在
            //定义SQL
            String getC_id = "select c_id from cart where u_id = ? and g_id = ?";
            //执行SQL
            Integer c_id = template.queryForObject(getC_id, Integer.class, u_id, g_id);
            return c_id;
        } else {
            return 0;
        }
    }

    /**
     * 插入新的购物车数据
     * @param u_id
     * @param g_id
     * @param c_num
     * @param c_totalPrice
     */
    @Override
    public void insertCart(int u_id, int g_id, int c_num, Double c_totalPrice) {
        //定义SQL
        String sql = "INSERT INTO cart VALUES(NULL,?,?,?,? * ?)";
        //执行SQL
        template.update(sql,u_id,g_id,c_num,c_num,c_totalPrice);
    }

    /**
     * 更新现有的购物车数据
     * @param c_id
     * @param c_num
     * @param g_price
     */
    @Override
    public void updateCart(int c_id, int c_num, Double g_price) {
        //定义SQL
        String sql = "UPDATE cart SET c_num = c_num + ? , c_totalprice = c_num * ? WHERE c_id = ?";
        //执行SQL
        template.update(sql,c_num,g_price,c_id);
    }

    /**
     * 根据用户id查询所有购物车数据
     * @param u_id
     * @return
     */
    @Override
    public List<MyCart> findMyCartByu_id(int u_id) {
        //定义SQL
        String sql = "SELECT cart.*,good.`g_name`,good.`g_price`,good.`g_img` FROM cart,good WHERE cart.g_id = good.g_id AND u_id = ?";
        //执行SQL
        return template.query(sql, new BeanPropertyRowMapper<MyCart>(MyCart.class), u_id);
    }

    /**
     * 根据购物车id删除购物车
     * @param c_id
     */
    @Override
    public void deleteCart(int c_id) {
        //定义SQL
        String sql = "DELETE FROM cart WHERE c_id = ?";
        //执行SQL
        template.update(sql,c_id);
    }
}

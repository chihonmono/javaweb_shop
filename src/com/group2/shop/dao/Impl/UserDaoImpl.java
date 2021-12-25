package com.group2.shop.dao.Impl;

import com.group2.shop.dao.UserDao;
import com.group2.shop.domain.User;
import com.group2.shop.utils.JDBCUtils;
import com.sun.org.apache.bcel.internal.generic.Select;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 用户dao实现类
 * @author Honmono
 * @date 2021/10/23 - 12:15
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findUserByu_nameAndu_password(String u_name, String u_password) {
        try {
            //定义SQL
            String sql = "select * from user where u_name = ? and u_password = ?";
            //执行SQL
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),u_name,u_password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    @Override
    public boolean checkUser(String username) {
        //定义SQL
        String sql = "select count(*) from user where u_name = ?";
        //执行SQL
        Integer count = template.queryForObject(sql, Integer.class, username);
        if (count == 0){
            return false;
        }else {
            return true;
        }
    }
}

package com.group2.shop.dao;

import com.group2.shop.domain.User;

/**
 * 用户dao接口
 * @author Honmono
 * @date 2021/10/23 - 12:15
 */
public interface UserDao {
    User findUserByu_nameAndu_password(String u_name, String u_password);

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    boolean checkUser(String username);
}

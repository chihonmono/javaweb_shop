package com.group2.shop.service;

import com.group2.shop.domain.User;

/**
 * 用户service接口
 * @author Honmono
 * @date 2021/10/23 - 12:14
 */
public interface UserService {
    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    boolean checkUser(String username);
}

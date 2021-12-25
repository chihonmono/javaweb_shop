package com.group2.shop.service.Impl;

import com.group2.shop.dao.Impl.UserDaoImpl;
import com.group2.shop.dao.UserDao;
import com.group2.shop.domain.User;
import com.group2.shop.service.UserService;

/**
 * 用户service实现类
 * @author Honmono
 * @date 2021/10/23 - 12:14
 */
public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return dao.findUserByu_nameAndu_password(user.getU_name(),user.getU_password());
    }

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    @Override
    public boolean checkUser(String username) {
        //调用dao查询是否存在用户名
        return dao.checkUser(username);
    }
}

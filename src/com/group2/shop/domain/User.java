package com.group2.shop.domain;

import java.util.Date;

/**
 * @author Honmono
 * @date 2021/10/22 - 19:04
 */
public class User {

    private int u_id;//用户id
    private String u_name;//用户名
    private String u_password;//用户密码
    private Date u_createTime;//账户创建时间

    public int getU_id() { return u_id; }

    public void setU_id(int u_id) { this.u_id = u_id; }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public Date getU_createTime() {
        return u_createTime;
    }

    public void setU_createTime(Date u_createTime) {
        this.u_createTime = u_createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_createTime=" + u_createTime +
                '}';
    }
}

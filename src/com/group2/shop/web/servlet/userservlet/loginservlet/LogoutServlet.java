package com.group2.shop.web.servlet.userservlet.loginservlet;
/**
 * 退出登录servlet
 * @author Honmono
 * @date 2021/10/23 - 14:24
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session
        HttpSession session = request.getSession();
        //删除session中的用户信息
        session.removeAttribute("user");
        //删除cookie中的用户信息
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName()=="JSESSIONID"){
                c.setMaxAge(0);
            }
        }
        //重定向index.jsp
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

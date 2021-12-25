package com.group2.shop.web.servlet.userservlet.registservlet; /**
 * @author Honmono
 * @date 2021/11/9 - 11:32
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.group2.shop.service.Impl.UserServiceImpl;
import com.group2.shop.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/checkUserServlet")
public class CheckUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码

        //获取用户名
        String username = request.getParameter("username");
        //调用service层判断用户名是否存在
        UserService service = new UserServiceImpl();
        boolean userExist = service.checkUser(username);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userExist",userExist);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

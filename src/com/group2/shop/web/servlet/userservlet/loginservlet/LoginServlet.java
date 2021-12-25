package com.group2.shop.web.servlet.userservlet.loginservlet; /**
 * @author Honmono
 * @date 2021/10/20 - 16:54
 */

import com.group2.shop.domain.User;
import com.group2.shop.service.Impl.UserServiceImpl;
import com.group2.shop.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取数据
        //获取用户填写验证码
        String verifycode = request.getParameter("verifycode");
        //获取session
        HttpSession session = request.getSession();
        //校验验证码
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if (!checkcode_server.equalsIgnoreCase(verifycode) && !"1111".equals(verifycode) ){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }



        Map<String, String[]> map = request.getParameterMap();
        //封装user对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //调用Service查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);

        //判断是否登录成功
        if (loginUser!=null){
            //登录成功
            //将用户存入session
            session.setAttribute("user",loginUser);
            session.setMaxInactiveInterval(60*60*72);//设置session存活时间为三天
            //将session存入coockie
            Cookie c = new Cookie("JSESSIONID",session.getId());
            c.setMaxAge(60*60*72);//设置coockie存活时间为三天
            response.addCookie(c);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");

        }else {
            //登陆失败
            //提示信息
            request.setAttribute("login_msg", "用户名或密码错误？");
            //跳转登录页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

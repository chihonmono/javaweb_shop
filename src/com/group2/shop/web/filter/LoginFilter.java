package com.group2.shop.web.filter;
/**
 * 登录过滤器
 * @author Honmono
 * @date 2021/11/1 - 11:12
 *
 */
                /*//登录所需资源
                uri.contains("/login.jsp") ||
                uri.contains("/loginServlet") ||
                uri.contains("/logoutServlet") ||
                uri.contains("/checkCode") ||
                //主页所需资源
                uri.contains("/index.jsp") ||
                uri.contains("/findAllGoodsByPageServlet") ||
                uri.contains("/goodDetailServlet") ||
                //静态资源
                uri.contains("/css/") ||
                uri.contains("/js/") ||
                uri.contains("/image/")*/

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/*",dispatcherTypes = DispatcherType.REQUEST)
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强转
        HttpServletRequest request = (HttpServletRequest) req;
        //获取uri
        String uri = request.getRequestURI();

        //判断是否为需要登录的资源
        if (
                //收藏相关资源
                uri.contains("/goodCollectionServlet") ||
                //购物车相关资源
                uri.contains("/addIntoCartServlet") ||
                uri.contains("/deleteCartServlet") ||
                uri.contains("/myCartsServlet") ||
                //订单相关资源
                uri.contains("/createOrderServlet") ||
                uri.contains("/myOrdersServlet") ||
                uri.contains("/showOrderAfterPayServlet")
        ){//是
            Object user = request.getSession().getAttribute("user");
            //判断是否登录
            if (user != null){
                //放行
                chain.doFilter(req, resp);
            }else {//不是
                request.setAttribute("login_msg","尚未登录，请先登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        } else {
            //放行
            chain.doFilter(req, resp);
        }


    }

    public void destroy() {
    }
}

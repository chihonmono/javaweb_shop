package com.group2.shop.web.servlet.cartservlet;
/**
 * 加入购物车servlet
 * @author Honmono
 * @date 2021/10/29 - 14:35
 */

import com.group2.shop.service.CartService;
import com.group2.shop.service.Impl.CartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addIntoCartServlet")
public class AddIntoCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        int u_id = Integer.parseInt(request.getParameter("u_id"));//用户id
        int g_id = Integer.parseInt(request.getParameter("g_id"));//商品id
        Double g_price = Double.valueOf(request.getParameter("g_price"));//商品价格
        int c_num = Integer.parseInt(request.getParameter("num"));//商品数量

        //调用service将商品加入购物车
        CartService service = new CartServiceImpl();
        service.addIntoCart(u_id,g_id,c_num,g_price);

        //将数据存入request域
        request.setAttribute("u_id",u_id);
        request.setAttribute("g_id",g_id);
        request.setAttribute("num",c_num);
        request.setAttribute("gd_msg","已加入购物车");
        //转发到goodDetail.jsp
        request.getRequestDispatcher("goodDetailServlet").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

package com.group2.shop.web.servlet.orderservlet; /**
 * @author Honmono
 * @date 2021/10/30 - 12:29
 */

import com.group2.shop.domain.MyOrder;
import com.group2.shop.service.Impl.OrderServiceImpl;
import com.group2.shop.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/myOrdersServlet")
public class MyOrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        int u_id = Integer.parseInt(request.getParameter("u_id"));

        //调取service查询订单
        OrderService service = new OrderServiceImpl();
        List<MyOrder> myOrders = service.findOrdersByu_id(u_id);
        //存入request域
        request.setAttribute("myOrders",myOrders);
        //转发到myOrders.jsp
        request.getRequestDispatcher("myOrders.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

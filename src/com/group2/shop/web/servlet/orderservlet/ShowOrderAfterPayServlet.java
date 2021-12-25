package com.group2.shop.web.servlet.orderservlet; /**
 * @author Honmono
 * @date 2021/10/24 - 15:06
 */

import com.group2.shop.domain.Order;
import com.group2.shop.service.Impl.OrderServiceImpl;
import com.group2.shop.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/showOrderAfterPayServlet")
public class ShowOrderAfterPayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取参数
        int o_id = Integer.parseInt(request.getParameter("o_id"));
        int newStatus = Integer.parseInt(request.getParameter("newStatus"));

        //获取service
        OrderService service = new OrderServiceImpl();
        if (newStatus == 2){//如果新订单状态不为空
            //调用service更新订单
            service.updateStatusById(o_id,newStatus);
        }

        //调用service查询订单信息
        Order order = service.findOrderById(o_id);

        //将order存入request域
        request.setAttribute("order",order);

        //转发到order.jsp
        request.getRequestDispatcher("/order.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

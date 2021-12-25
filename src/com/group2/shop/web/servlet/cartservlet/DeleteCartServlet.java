package com.group2.shop.web.servlet.cartservlet; /**
 * @author Honmono
 * @date 2021/10/31 - 14:06
 */

import com.group2.shop.service.CartService;
import com.group2.shop.service.Impl.CartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取参数
        int c_id = Integer.parseInt(request.getParameter("c_id"));
        int u_id = Integer.parseInt(request.getParameter("u_id"));

        //调用service删除购物车
        CartService service = new CartServiceImpl();
        service.deleteCart(c_id);

        //将数据存入request域
        request.setAttribute("u_id",u_id);

        //转发回myCart.jsp
        request.getRequestDispatcher("/myCartsServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

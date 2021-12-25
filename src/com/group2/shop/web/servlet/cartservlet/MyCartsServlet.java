package com.group2.shop.web.servlet.cartservlet; /**
 * @author Honmono
 * @date 2021/10/31 - 13:12
 */

import com.group2.shop.domain.MyCart;
import com.group2.shop.service.CartService;
import com.group2.shop.service.Impl.CartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/myCartsServlet")
public class MyCartsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取参数
        int u_id = Integer.parseInt(request.getParameter("u_id"));

        //调用service查询所有购物车
        CartService service = new CartServiceImpl();
        List<MyCart> myCarts = service.findMyCartByu_id(u_id);

        //将数据存入request域
        request.setAttribute("myCarts",myCarts);

        //转发到myCart.jsp
        request.getRequestDispatcher("/myCart.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

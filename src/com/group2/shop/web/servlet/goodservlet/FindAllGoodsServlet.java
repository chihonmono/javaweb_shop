package com.group2.shop.web.servlet.goodservlet;
/**
 * 查找所有货物展示到主页index.jsp
 * @author Honmono
 * @date 2021/10/22 - 19:18
 */

import com.group2.shop.domain.Good;
import com.group2.shop.service.GoodService;
import com.group2.shop.service.Impl.GoodServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllGoodsServlet")
public class FindAllGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //调用service完成查询
        GoodService service = new GoodServiceImpl();
        List<Good> goods = service.findAllGoods();

        //将list存入request域
        request.setAttribute("goods",goods);
        //转发到index.jsp
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

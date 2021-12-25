package com.group2.shop.web.servlet.goodservlet;
/**
 * 收藏商品servlet
 * @author Honmono
 * @date 2021/10/27 - 12:28
 */

import com.group2.shop.domain.Good;
import com.group2.shop.service.GoodService;
import com.group2.shop.service.Impl.GoodServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/goodCollectionServlet")
public class GoodCollectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数并转换类型
        int u_id = Integer.parseInt(request.getParameter("u_id"));
        int g_id = Integer.parseInt(request.getParameter("g_id"));

        //调用service 查询收藏表 确认是否收藏
        GoodService service = new GoodServiceImpl();
        int gColl_id = service.GoodCollection(u_id,g_id);

        //调用service查询商品信息
        Good good = service.findGoodById(g_id);
        //将数据存入request
        request.setAttribute("good", good);
        request.setAttribute("gColl_id",gColl_id);
        //转发到GoodDetail.jsp
        request.getRequestDispatcher("/goodDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

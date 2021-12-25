package com.group2.shop.web.servlet.goodservlet;
/**
 * 根据g_id查找货物并展示到详情页goodDetail.jsp
 * @author Honmono
 * @date 2021/10/22 - 21:53
 */

import com.group2.shop.domain.Good;
import com.group2.shop.service.GoodService;
import com.group2.shop.service.Impl.GoodServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/goodDetailServlet")
public class GoodDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");

        //获取参数并转换类型
        int g_id = Integer.parseInt(request.getParameter("g_id"));
        int u_id = Integer.parseInt(request.getParameter("u_id"));
        Object gd_msg = request.getAttribute("gd_msg");

        //获取service
        GoodService service = new GoodServiceImpl();

        //调用service完成查询
        Good good = service.findGoodById(g_id);

        //调用service查询是否收藏
        int gColl_id = service.confirmIfCollected(u_id, g_id);

        //将数据存入request
        request.setAttribute("good", good);
        request.setAttribute("gColl_id",gColl_id);
        request.setAttribute("gd_msg",gd_msg);
        //转发到GoodDetail.jsp
        request.getRequestDispatcher("/goodDetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

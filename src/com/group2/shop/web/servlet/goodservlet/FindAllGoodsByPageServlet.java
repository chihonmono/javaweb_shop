package com.group2.shop.web.servlet.goodservlet; /**
 * @author Honmono
 * @date 2021/10/23 - 10:25
 */

import com.group2.shop.domain.Good;
import com.group2.shop.domain.PageBean;
import com.group2.shop.service.GoodService;
import com.group2.shop.service.Impl.GoodServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findAllGoodsByPageServlet")
public class FindAllGoodsByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取参数
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        //判断不为空
        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";//设为默认值
        }
        if (rows == null || "".equals(rows)){
            rows = "20";//设为默认值
        }

        //获取搜索条件
        Map<String, String[]> condition = request.getParameterMap();

        //调用service
        GoodService service = new GoodServiceImpl();
        PageBean<Good> pb =  service.findAllGoodsByPage(currentPage,rows,condition);

        //将数据存入request域
        request.setAttribute("pb",pb);

        //转发到index.jsp
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

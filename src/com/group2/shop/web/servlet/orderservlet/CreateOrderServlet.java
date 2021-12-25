package com.group2.shop.web.servlet.orderservlet;
/**
 * 生成订单
 * @author Honmono
 * @date 2021/10/23 - 16:18
 */

import com.group2.shop.domain.Order;
import com.group2.shop.service.GoodService;
import com.group2.shop.service.Impl.GoodServiceImpl;
import com.group2.shop.service.Impl.OrderServiceImpl;
import com.group2.shop.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/createOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取时间
        Date o_time = new Date();

        //获取参数并转换类型
        int u_id = Integer.parseInt(request.getParameter("u_id"));//用户id
        int g_id = Integer.parseInt(request.getParameter("g_id"));//商品id
        String g_name = request.getParameter("g_name");//商品名字
        Double g_price = Double.valueOf(request.getParameter("g_price"));//商品价格
        int o_num = Integer.parseInt(request.getParameter("num"));//购买数量

        //计算总价
        Double o_totalPrice = (g_price * o_num);

        //创建Order对象
        Order order = new Order();
        //插入数据
        order.setU_id(u_id);//用户id
        order.setG_id(g_id);//商品id
        order.setO_num(o_num);//购买数量
        order.setO_totalPrice(o_totalPrice);//订单总价
        order.setO_time(o_time);//订单生成时间
        order.setO_status(1);//订单状态

        //调用service减少库存
        GoodService gService = new GoodServiceImpl();
        gService.updateStockAfterBuy(g_id,o_num);

        //调用service储存order
        OrderService oService = new OrderServiceImpl();
        oService.insertOrder(order);

        //调用service获取最新的订单记录
        order = oService.findLastOrder();

        //将数据存入request域
        request.setAttribute("order",order);
        request.setAttribute("g_name",g_name);

        //跳转支付页面
        request.getRequestDispatcher("/pay.jsp").forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

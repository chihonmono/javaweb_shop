<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${good.g_name}</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>

    <style>
        table{
            margin-top: 50px;
        }
    </style>
    <script>
        function firstLoad(){
            location.href="${pageContext.request.contextPath}/findAllGoodsByPageServlet?currentPage=1&rows=20";
        }

    </script>
</head>
<body>
<%--导航条--%>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid myNav">
        <%--商标--%>
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="javascript:firstLoad()">沃超-市</a>
        </div>


        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <%--左导航--%>

            <ul class="nav navbar-nav">
                <c:if test="${user == null}">
                    <li>
                        <a href="${pageContext.request.contextPath}/login.jsp">登录</a>
                    </li>

                </c:if>
                <c:if test="${user != null}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${user.u_name}<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/userCenterServlet">用户中心</a></li>
                            <li><a href="${pageContext.request.contextPath}/logoutServlet">退出</a></li>

                        </ul>
                    </li>
                </c:if>



            </ul>
            <%--右导航--%>
            <ul class="nav navbar-nav navbar-right">
                <%--搜索框 暂留--%>
                <li>
                    <form class="navbar-form navbar-right">
                        <div class="form-group">
                            <input type="text"  name="g_name" class="form-control" placeholder="请输入要搜索的商品">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>
                </li>

                <li><a href="${pageContext.request.contextPath}/myCartsServlet?u_id=${user.u_id}">购物车</a></li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">收藏夹<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/myOrdersServlet?u_id=${user.u_id}">收藏的商品</a></li>
                        <li><a href="#">收藏的店铺</a></li>

                    </ul>
                </li>

            </ul>
        </div>
    </div>
</nav>

<table class="table">
    <tr>
        <th>订单编号</th>
        <th>商品名称</th>
        <th>购买数量</th>
        <th>订单总价</th>
        <th>订单时间</th>
        <th>订单状态</th>
    </tr>
    <tr>
        <td>${order.o_id}</td>
        <td>${g_name}</td>
        <td>${order.o_num}</td>
        <td>${order.o_totalPrice}</td>
        <td>${order.o_time}</td>
        <td>
            <c:choose>
                <c:when test="${order.o_status == 1}">待支付</c:when>
                <c:when test="${order.o_status == 2}">待发货</c:when>
                <c:when test="${order.o_status == 3}">已发货</c:when>
                <c:when test="${order.o_status == 4}">已收货</c:when>
            </c:choose>
        </td>
    </tr>
</table>
</body>
</html>

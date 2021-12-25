<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8"/>
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>shop</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>

    <script>
        function firstLoad(){
            location.href="${pageContext.request.contextPath}/findAllGoodsByPageServlet?currentPage=1&rows=20";
        }
    </script>

    <style>
        table{
            margin-top: 100px;
        }
    </style>

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
        <th>商品图</th>
        <th>商品名</th>
        <th>商品单价</th>
        <th>购买数量</th>
        <th>订单总价</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${myCarts}" var="myCarts" varStatus="s">
        <form action="" name="${s.index}">
            <tr>
                <td>${myCarts.g_img}</td>
                <td>${myCarts.g_name}</td>
                <td>${myCarts.g_price}</td>
                <td><input type="text" name="num" value="${myCarts.c_num}"></td>
                <td>${myCarts.c_totalPrice}</td>
                <td>
                    <input type="hidden" name="u_id" value="${myCarts.u_id}">
                    <input type="hidden" name="g_id" value="${myCarts.g_id}">
                    <input type="hidden" name="g_name" value="${myCarts.g_name}">
                    <input type="hidden" name="g_price" value="${myCarts.g_price}">
                    <input class="btn btn-danger" type="submit" value="购买">
                    <input class="btn btn-info" type="button" value="删除" onclick="deleteCart('${myCarts.c_id}','${user.u_id}')">
                </td>
            </tr>
        </form>

    </c:forEach>

</table>


<%--分页条--%>
<div>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <%--上一页--%>
            <c:if test="${pb.currentPage == 1}">
                <li class="disabled">
                    <a href="JavaScript:return false;" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
            </c:if>
            <c:if test="${pb.currentPage != 1}">
                <li>
                    <a href="${pageContext.request.contextPath}/findAllGoodsByPageServlet?currentPage=${pb.currentPage - 1}&rows=20" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
            </c:if>
            </li>

            <%--页码--%>
            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <c:if test="${pb.currentPage == i}">
                    <li class="active"><a href="${pageContext.request.contextPath}/findAllGoodsByPageServlet?currentPage=${i}&rows=20">${i}</a></li>
                </c:if>
                <c:if test="${pb.currentPage != i}">
                    <li><a href="${pageContext.request.contextPath}/findAllGoodsByPageServlet?currentPage=${i}&rows=20">${i}</a></li>
                </c:if>
            </c:forEach>
            <%--下一页--%>
            <c:if test="${pb.currentPage == pb.totalPage}">
                <li class="disabled">
                    <a href="javascript:return false" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${pb.currentPage != pb.totalPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/findAllGoodsByPageServlet?currentPage=${pb.currentPage + 1}&rows=20" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
    <span>
        <h4>共${pb.totalCount}条记录，共${pb.totalPage}页</h4>
    </span>
</div>

<script>
    function goDetail(g_id,u_id) {
        if (u_id == ""){
            u_id = "0";
        }
        location.href="${pageContext.request.contextPath}/goodDetailServlet?g_id="+g_id+"&u_id="+u_id;
    }

    function deleteCart(c_id,u_id){
        if (confirm("确认删除？")){
            location.href="${pageContext.request.contextPath}/deleteCartServlet?c_id="+c_id+"&u_id="+u_id;
        }
    }
</script>
</body>
</html>
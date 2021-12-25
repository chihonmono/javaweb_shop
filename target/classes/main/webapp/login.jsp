<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>

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
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">用户登录</h3>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="form-group">
            <label for="name">用户名：</label>
            <input type="text" name="u_name" class="form-control" id="name" placeholder="请输入用户名" value="honmono"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="u_password" class="form-control" id="password" placeholder="请输入密码" value="honmono"/>
        </div>

        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
            <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/checkCode" title="看不清点击刷新" id="vcode"/></a>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span></button>
        <strong>${login_msg}</strong>
    </div>
</div>

<script>
    function refreshCode(){
        var vcode = document.getElementById("vcode");
        vcode.src="${pageContext.request.contextPath}/checkCode?time="+new Date().getTime();
    }
</script>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pay</title>
</head>
<body>
<h2 align="center">微信支付</h2>
<table class="table">
    <tr>
        <td>${g_name}</td>
    </tr>
    <tr>
        <td colspan="2">
            <img src="image/QRCode.jpg"/>
        </td>
    </tr>
    <tr>
        <td>
            <form action="${pageContext.request.contextPath}/showOrderAfterPayServlet">
                <input type="hidden" name="o_id" value="${order.o_id}">
                <input type="hidden" name="g_name" value="${g_name}">
                <input type="hidden" name="newStatus" value="2">
                <input type="submit" class="btn btn-info" value="已支付">
            </form>
        </td>
        <td>
            <form action="${pageContext.request.contextPath}/showOrderAfterPayServlet">
                <input type="hidden" name="o_id" value="${order.o_id}">
                <input type="hidden" name="g_name" value="${g_name}">
                <input type="hidden" name="newStatus" value="1">
                <input type="submit" class="btn btn-info" value="暂不支付">
            </form>
        </td>
    </tr>
</table>

</body>
</html>

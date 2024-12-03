<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <title>订单信息</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>订单信息</h1>
    <!-- 订单数据展示表 -->
    <table class="order-table">
        <thead>
        <tr>
            <th>序号</th>
            <th>用户名称</th>
            <th>浴室ID</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" varStatus="status" var="order">
            <tr>
                <td>${status.count}</td>
                <td>${order.user_name}</td>
                <td>${order.bathroom_id}</td>
                <td>
                    <a href="javascript:void(0)" onclick="del('${order.user_name}')">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- 返回按钮 -->
    <div class="action-buttons">
        <a href="list.jsp" class="btn btn-back">返回</a>
    </div>
</div>
<script type='text/javascript'>
    function del(name){
        if(window.confirm('删除不可恢复！如删除，要手动更新浴室状态!!!')){
            document.location.href='<%=request.getContextPath()%>/order/delete?name='+name
        }
    }
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <!-- 引用外部 CSS -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>管理员界面</h1>
    <p>欢迎管理员! 在这你可以管理用户、浴室还有订单</p>

    <!-- 管理操作部分 -->
    <div class="admin-actions">
        <!-- 用户管理 -->
        <div class="section">
            <h2>管理用户</h2>
            <a href="addUser.jsp">添加用户</a>
            <a href="admin/detail">查看所有用户</a>
        </div>

        <!-- 浴室管理 -->
        <div class="section">
            <h2>管理浴室</h2>
            <a href="bathroom/add">添加浴室</a>
            <a href="bathroom/detail">查看所有浴室</a>
        </div>

        <!-- 订单管理 -->
        <div class="section">
            <h2>管理订单</h2>
            <a href="order/detail">查看所有订单</a>
        </div>
    </div>
</div>
</body>
</html>


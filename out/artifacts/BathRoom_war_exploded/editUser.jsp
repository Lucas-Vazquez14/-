<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <title>Edit User</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>编辑用户信息</h1>
    <!-- 用户信息编辑表单 -->
    <form action="admin/modify" method="post">
        <label for="name">名称:</label>
        <input type="text" id="name" name="name"  value="${user.name}" required>

        <label for="password">密码:</label>
        <input type="password" id="password" name="password" value="${user.password}" required>

        <label for="num">余额次数:</label>
        <input type="number" id="num" name="num" value="${user.num}" required>

        <div class="button-container">
            <button type="submit" class="submit-button">提交</button>
            <a href="detail.jsp" class="back-button">返回</a>
        </div>
    </form>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <title>添加用户</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>Add New User</h1>
    <form action="admin/add" method="POST" class="form-container">
        <div>
            <label for="name">名称:</label>
            <input type="text" id="name" name="name" placeholder="请输入名称" required>
        </div>
        <div>
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" placeholder="请输入密码" required>
        </div>
        <div>
            <label for="num">余额次数:</label>
            <input type="number" id="num" name="num" placeholder="请输入余额次数" required>
        </div>

        <!-- 提交按钮 -->
        <button type="submit">添加用户</button>
    </form>
</div>
</body>
</html>

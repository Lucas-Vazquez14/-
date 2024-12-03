<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Small Bathroom系统</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <!-- 引用外部 CSS 文件 -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>欢迎来到小浴室系统</h1>
    <p>欢迎登录并预约浴室进行洗澡</p>
    <form action="user/login" method="POST">
        <input type="text" name="username" placeholder="请输入你的账户" required>
        <input type="password" name="password" placeholder="请输入你的密码" required>
        <input type="checkbox" name="f" value="1">七天内免登录<br>
        <button type="submit">登录</button>
    </form>
</div>
</body>
</html>

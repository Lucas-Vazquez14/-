<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <title>预约浴室</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>预约浴室</h1>
    <!-- 预约表单 -->
    <form action="function/deal" method="post" class="reserve-form">
        <div class="form-group">
            <label for="userName">用户名称：</label>
            <input type="text" id="userName" name="user_name" value="${user.name}" readonly>
            <span class="user-num">剩余次数：${user.num}</span>
        </div>
        <div class="form-group">
            <label for="bathroomId">选择浴室：</label>
            <select id="bathroomId" name="bath_id">
                <c:forEach items="${bathrooms}" var="bathroom" varStatus="status">
                    <option value="${status.count}">
                        浴室ID: ${status.count} - 状态: ${bathroom.status == true ? '可用' : '不可用'}
                    </option>
                </c:forEach>
            </select>
        </div>
        <!-- 按钮 -->
        <div class="action-buttons">
            <button type="submit" class="btn btn-submit">提交预约</button>
            <a href="function/order" class="btn btn-history">查看正在进行的订单</a>
            <a href="user/exit" class="btn btn-back">退出登录</a>
        </div>
    </form>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        // 读取后台传递的 flag 值
        const flag = ${flag};

        // 检查 flag 的状态
        if (!flag) {
            alert("余额不足，请充值后再预约！");

            // 禁用提交按钮
            const submitButton = document.querySelector('.btn-submit');
            if (submitButton) {
                submitButton.disabled = true;
            }
        }
    });
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <title>浴室信息</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <h1>浴室信息</h1>
    <!-- 浴室数据展示表 -->
    <table class="bathroom-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" varStatus="status" var="bathroom">
            <tr>
                <td>${status.count}</td>
                <td>
                    <span class="${bathroom.status == true ? 'status-available' : 'status-unavailable'}">
                            ${bathroom.status == true ? '可用' : '不可用'}
                    </span>
                </td>
                <td>
                    <a href="javascript:void(0)" onclick="del('${bathroom.id}')">删除</a>
                    <a href="${pageContext.request.contextPath}/bathroom/update?id=${bathroom.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="action-buttons">
        <a href="list.jsp" class="btn btn-back">返回</a>
    </div>
</div>
<script type='text/javascript'>
    function del(id){
        if(window.confirm('删除不可恢复！')){
            document.location.href='<%=request.getContextPath()%>/bathroom/delete?id='+id
        }
    }
</script>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
  <title>用户列表</title>
  <link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="container">
  <h1>用户列表</h1>
  <!-- 用户数据展示表 -->
  <table class="user-table">
    <thead>
    <tr>
      <th>序号</th>
      <th>名称</th>
      <th>余额次数</th>
      <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" varStatus="listStatus" var="li">
      <tr>
        <td>${listStatus.count}</td>
        <td><span class="highlight">${li.name}</span></td>
        <td>${li.num}</td>
        <td>
          <a href="javascript:void(0)" onclick="del('${li.name}')">删除</a>
          <a href="${pageContext.request.contextPath}/admin/update?name=${li.name}">修改</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <!-- 返回按钮 -->
  <div class="button-container">
    <a href="list.jsp" class="back-button">返回</a>
  </div>
</div>
<script type='text/javascript'>
  function del(name){
    if(window.confirm('删除不可恢复！')){
      document.location.href='<%=request.getContextPath()%>/admin/delete?name='+name
    }
  }
</script>
</body>
</html>

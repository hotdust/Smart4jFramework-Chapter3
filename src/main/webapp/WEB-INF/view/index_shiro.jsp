<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>--%>

<c:set var="BASE" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>首页</title>
</head>
<body>

<h1>首页</h1>

<shiro:guest>
    <p>身份：游客</p>
    <a href="${BASE}/login">登录</a>
</shiro:guest>

<shiro:user>
    <p>身份：<shiro:principal/></p>
    <ul>
        <li><a href="${BASE}/customer">客户管理</a></li>
    </ul>
    <a href="<c:url value="/logout"/>">注销</a>
</shiro:user>

</body>
</html>
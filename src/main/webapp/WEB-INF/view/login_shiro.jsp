<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>--%>

<c:set var="BASE" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>登录</title>
</head>
<body>

<h1>登录</h1>

<shiro:guest>
    <form action="${BASE}/login" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">登录</button>
                </td>
            </tr>
        </table>
    </form>
</shiro:guest>

<shiro:user>
    shir:user
    <c:redirect url="${BASE}/customer_edit?id=2"/>

</shiro:user>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: cxc
  Date: 2019/8/4
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<from action="/login">
    <span>用户名</span><input type="text" id="username" name="username"/>
    <span>密码</span><input type="password" id="password" name="password"/>
    <input type="submit">
</from>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h2>登录页</h2>
<form:form action="/login" method="post">
    用户名<input type="text" id="username" name="username">
    密码<input type="password" id="password" name="password">
    <input type="submit">
</form:form>
${error}
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Login Success</title></head>
<body>
    <h2>Login Successful!</h2>
    <p>Welcome, <strong><%= request.getAttribute("username") %></strong>!</p>
</body>
</html>

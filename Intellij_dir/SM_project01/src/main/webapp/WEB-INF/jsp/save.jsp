<%--
  Created by IntelliJ IDEA.
  User: kimhyunjo
  Date: 2023/05/02
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/user/save" method="post">
        <input type="text" name="Id" placeholder="이메일">
        <input type="text" name="Password" placeholder="비밀번호">
        <input type="submit" value="회원가입">
    </form>


</body>
</html>

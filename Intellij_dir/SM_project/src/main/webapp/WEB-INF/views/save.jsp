<%--
  Created by IntelliJ IDEA.
  User: kimhyunjo
  Date: 2023/05/01
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/member/save" method="post">
        <input type="text" name="memberEmail" placeholder="이메일">
        <input type="text" name="memberPassword" placeholder="비밀번호">
        <input type="text" name="memberName" placeholder="이름">
        <input type="text" name="memberAge" placeholder="나이">
        <input type="text" name="memberMobile" placeholder="전화번호">
        <input type="submit" value="회원가입">
    </form>


</body>
</html>

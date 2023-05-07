<%--
  Created by IntelliJ IDEA.
  User: kimhyunjo
  Date: 2023/05/03
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> 로그인 </h2>

<form action="/user/login" method="post">
    <table border="1">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="Id" placeholder="이메일"></td>
        </tr>

        <tr>
            <td>비밀번호</td>
            <td><input type="text" name="Password" placeholder="비밀번호"></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="로그인">
            </td>
        </tr>

    </table>

</form>

<form action="/user/login" method="post">
    <input type="text" name="Id" placeholder="이메일">
    <input type="text" name="Password" placeholder="비밀번호">
    <input type="submit" value="로그인">
</form>
</body>
</html>

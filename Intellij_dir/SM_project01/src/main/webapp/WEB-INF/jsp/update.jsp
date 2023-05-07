<%--
  Created by IntelliJ IDEA.
  User: kimhyunjo
  Date: 2023/05/03
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/main/update" method="post">
    <h5>수정할 내용을 입력하세요</h5><br><br>
    <textarea name="Todo" rows="3" cols="10"></textarea>
    <input type="submit" value="수정하기">
</form>

</body>
</html>

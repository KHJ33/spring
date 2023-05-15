<%--
  Created by IntelliJ IDEA.
  User: GHJ
  Date: 2023-05-15
  Time: 오전 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>내가 해야 할 일 목록</h3>

<%-- <%= request.getAttribute("todolist") %> --%>

<table>
  <tr>
    <th>Num</th>
    <th>Id</th>
    <th>Todo</th>
    <th>Done</th>
    <th>수정</th>
    <th>삭제</th>
  </tr>

  <!-- 왜 그런지 모르겠지만 첫 시작은 소문자여야 돌아감 -->
  <c:forEach items="${todolist}" var="todo">
    <tr>
      <td>${todo.num}</td>
      <td>${todo.id}</td>
      <td>
        <c:choose>
          <c:when test="${todo.done eq 0}">
            ${todo.todo}
          </c:when>
          <c:otherwise>
            <del>${todo.todo}</del>
          </c:otherwise>
        </c:choose>

      </td>
      <td>
        <c:choose>
          <c:when test="${todo.done eq 0}">
            <input type="checkbox" onclick="is_checked('${todo.num}')" id="check" value="info" >
          </c:when>
          <c:otherwise>
            <input type="checkbox" onclick="is_checked('${todo.num}')" id="check" value="info" checked>
          </c:otherwise>
        </c:choose>
      </td>
      <td><button onclick="updateTodo('${todo.num}')">수정</button></td>
      <td><button onclick="deleteTodo('${todo.num}')">삭제</button></td>
    </tr>
  </c:forEach>
</table>

<br><br>
<h3>내가 할 일 추가</h3>

<form action="/main/insert" method="post">
  <input type="hidden" name="Id" value="${sessionScope.loginId}">
  <textarea name="Todo" rows="2" cols="20"></textarea>
  <input type="hidden" name="Done" value="0">
  <input type="submit" value="추가하기">
</form>


</body>
</html>

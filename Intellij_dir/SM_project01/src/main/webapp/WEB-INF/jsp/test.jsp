<%--
  Created by IntelliJ IDEA.
  User: GHJ
  Date: 2023-05-08
  Time: 오전 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/resources/css/test_page.css" />" rel="stylesheet">
<html>
<head>
    <title> testing page </title>
</head>
<body>
  <div class="wrapper">

      <div class="task-input">
          <!-- <img src="/resources/img/menu_bar.png" alt="icon"> -->
          <input type="text" placeholder="Add a new todo list">
      </div>

      <div class="controls">
          <div class="filters">
              <span class="active" id="all">All</span>
              <span id="pending">Pending</span>
              <span id="completed">Completed</span>
          </div>

          <button class="clear-btn">Clear All</button>
      </div>

      <ul class="task-box"></ul>

<!--
      <ul class="task-box">

          <li class="task">
              <label for="${id}">
                  <input onclick="updateStatus(this)" type="checkbox" id="${id}" ${completed}>
                  <p class="${completed}">${todo.name}</p>
              </label>
              <div class="settings">
                  <i onclick="showMenu(this)" class="uil uil-ellipsis-h"></i>
                  <ul class="task-menu">
                      <li onclick='editTask(${id}, "${todo.name}")'><i class="uil uil-pen"></i>Edit</li>
                      <li onclick='deleteTask(${id}, "${filter}")'><i class="uil uil-trash"></i>Delete</li>
                  </ul>
              </div>
          </li>
      </ul>


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


-->

  </div>
</body>
<script src="<c:url value="/resources/js/test_page.js" />"></script>
</html>

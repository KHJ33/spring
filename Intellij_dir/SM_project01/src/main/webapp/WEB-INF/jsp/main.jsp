<%--
  Created by IntelliJ IDEA.
  User: kimhyunjo
  Date: 2023/05/03
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/resources/css/test_page.css" />" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>${sessionScope.loginIdName} 님 환영합니다.</h2>

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

        <ul class="task-box">
            <c:forEach items="${todolist}" var="user_todo">
                <li class="task">
                    <label>
                        <input onclick="updateStatus(this)" type="checkbox">
                        <p>${user_todo.todo}</p>
                    </label>
            </c:forEach>






        </ul>




    </div>


</body>
<script>
    const deleteTodo = (num) => {
        console.log(num);
        location.href = "/main/delete?num="+num;
    }
    const updateTodo = (num) => {
        console.log(num);
        location.href = "/main/update?num="+num;
    }
    const is_checked = (num) => {
        console.log(num);
        location.href = "/main/check?num="+num;
    }
</script>
<!-- <script src="<c:url value="/resources/js/main_page.js" />"></script> -->

</html>

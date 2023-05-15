<%--
  Created by IntelliJ IDEA.
  User: kimhyunjo
  Date: 2023/05/03
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link href="<c:url value="/resources/css/main_page.css?ver=4" />" rel="stylesheet">
<html>
<head>
    <title>Task</title>
</head>
<body>

    <h2>${sessionScope.loginIdName} 님 환영합니다.</h2>
<%--    <h2>${check_filter} 입니다.</h2>--%>

    <!-- Todolist 입력 부분 -->
    <div class="wrapper">

        <div class="task-input">
            <!-- <img src="/resources/img/menu_bar.png" alt="icon"> -->
            <input type="text" placeholder="Add a new todo list">

        </div>

        <div class="sub-box">
            <c:choose>
                <c:when test="${check_filter == 'completed'}">
                        <input id="start_date" type="date" value="${start_date}">
                        <span>~</span>
                        <input id="end_date" type="date" value="${end_date}">
                        <input id="date_submit" class="date_submit" type="submit" onclick="date()" value="적용">
                </c:when>
                <c:otherwise>
                        <input type="file" id="fileUpload" name="file" />
                </c:otherwise>
            </c:choose>
        </div>

        <!-- 네이게이션 바 선택 부분 -->
        <div class="controls">
            <div class="filters">
<%--                <span class="active" id="all">All</span>--%>
<%--                <span id="pending">Pending</span>--%>
<%--                <span id="completed">Completed</span>--%>
                <c:choose>
                    <c:when test="${check_filter == 'all' or empty check_filter}">
                        <span class="active" id="all">All</span>
                        <span id="pending">Pending</span>
                        <span id="completed">Completed</span>
                    </c:when>
                    <c:when test="${check_filter == 'pending'}">
                        <span id="all">All</span>
                        <span class="active" id="pending">Pending</span>
                        <span id="completed">Completed</span>
                    </c:when>
                    <c:when test="${check_filter == 'completed'}">
                        <span id="all">All</span>
                        <span id="pending">Pending</span>
                        <span class="active" id="completed">Completed</span>
                    </c:when>
                </c:choose>
            </div>

            <button class="clear-btn">Clear All</button>
        </div>

        <!-- Todolist 출력 부분 -->
        <ul class="task-box" style="height: 250px; overflow: auto">
            <c:choose>
                <c:when test="${empty todolist}">
                    <span>You don't have any todo list</span>
                </c:when>
                <c:otherwise>
                        <c:forEach items="${todolist}" var="user_todo">
                            <li class="task">
                                <label>
<%--                                    <input onclick="updateStatus(this)" type="checkbox">--%>
                                        <c:choose>
                                            <c:when test="${user_todo.done eq 0}">
<%--                                                <input type="checkbox" onclick="is_checked('${user_todo.num}')" id="check" value="info" >--%>
                                                <input type="checkbox" onclick="updateStatus('${user_todo.num}', '${user_todo.done}')" id="check" value="info" >
                                            </c:when>
                                            <c:otherwise>
<%--                                                <input type="checkbox" onclick="is_checked('${user_todo.num}')" id="check" value="info" checked>--%>
                                                <input type="checkbox" onclick="updateStatus('${user_todo.num}', '${user_todo.done}')" id="check" value="info" checked>
                                            </c:otherwise>
                                        </c:choose>

<%--                                    출력되는 p 태그--%>
                                    <c:choose>
                                        <c:when test="${user_todo.done eq 0}">
                                            <p>${user_todo.todo}</p>
                                        </c:when>
                                        <c:otherwise>
                                            <del><p>${user_todo.todo}</p></del>
                                            <p>${user_todo.completed_date}</p>
                                        </c:otherwise>
                                    </c:choose>

                                </label>

                                <c:choose>
                                    <c:when test="${user_todo.existsImg eq 1}">
                                    <div class="img">
                                        <i onclick="showImg(this, '${user_todo.img_fileName}', '${user_todo.num}')" class="uil uil-ellipsis-h"><b id = "I${user_todo.num}">Image</b></i>

                                        <ul class="show-img">
                                            <li><i class="uil uil-pen"></i>img</li>
                                        </ul>

                                    </div>
                                    </c:when>
                                </c:choose>


<%--                                ... 메뉴 클릭 부분--%>
                                <div class="settings">
                                    <i onclick="showMenu(this, '${user_todo.num}')" class="uil uil-ellipsis-h"><b id = "b${user_todo.num}">...</b></i>

                                    <ul class="task-menu">
                                        <li onclick='editTask(${user_todo.num}, "${user_todo.todo}")'><i class="uil uil-pen"></i>Edit</li>
                                        <li onclick='deleteTask(${user_todo.num})'><i class="uil uil-trash"></i>Delete</li>
                                    </ul>

                                </div>
                        </c:forEach>
                </c:otherwise>
            </c:choose>
        </ul>


    </div>

    <img src="" id="upload-img">


</body>
<script>

    const filters = document.querySelectorAll(".filters span"),
        // taskBox = document.querySelector(".task-box"),
        clearAll = document.querySelector(".clear-btn");

    // 편집기능을 담당하는 변수
    let editNum,
        isEditTask = false;

    // 이미지가 보여지고 있는지 확인하기 위한 변수 선언
    let check_imgUpload = false;

    // 입력 부분을 담당하는 변수
    const taskInput = document.querySelector(".task-input input");
    const loginId = '${sessionScope.loginId}';


    clearAll.classList.add("active");
    clearAll.addEventListener("click", () => {

        var num_Arr = [];

        <c:forEach items="${todolist}" var="user_todo">
            console.log(${user_todo.num})
            num_Arr.push(${user_todo.num})
        </c:forEach>

        for (var i = 0 ; i < num_Arr.length ; i++) {
            console.log(num_Arr[i]);
            console.log(typeof num_Arr[i]);
        }

        let f = document.createElement('form');
        f.setAttribute('method', 'post');
        f.setAttribute('action', '/main/select_clear')

        let obj;
        obj = document.createElement('input');
        obj.setAttribute('type', 'hidden');
        obj.setAttribute('name', 'num_Arr');
        obj.setAttribute('value', num_Arr);

        f.appendChild(obj);

        document.body.appendChild(f);
        f.submit();

    });

</script>
<script src="<c:url value="/resources/js/main_page_button.js" />"></script>
<script src="<c:url value="/resources/js/main_page_show.js?ver=1" />"></script>
<script src="<c:url value="/resources/js/main_page_input.js"/>"></script>


</html>

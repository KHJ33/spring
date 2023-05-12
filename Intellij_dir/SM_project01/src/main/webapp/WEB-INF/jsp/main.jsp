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
<link href="<c:url value="/resources/css/main_page.css" />" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>${sessionScope.loginIdName} 님 환영합니다.</h2>
    <h2>${check_filter} 입니다.</h2>

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


    <!-- Todolist 입력 부분 -->
    <div class="wrapper">

        <div class="task-input">
            <!-- <img src="/resources/img/menu_bar.png" alt="icon"> -->
            <input type="text" placeholder="Add a new todo list">

        </div>

        <div>
            <c:choose>
                <c:when test="${check_filter == 'completed'}">
                        <input id="start_date" type="date" value="${start_date}">
                        <input id="end_date" type="date" value="${end_date}">
                        <input id="date_submit" type="submit" onclick="date()" value="적용">
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
        <ul class="task-box">
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

    const filters = document.querySelectorAll(".filters span"),
        taskBox = document.querySelector(".task-box"),
        clearAll = document.querySelector(".clear-btn");

    const fileInput = document.getElementById("fileUpload");

    clearAll.classList.add("active");
    clearAll.addEventListener("click", () => {
        // isEditTask = false;
        // todos.splice(0, todos.length);
        // localStorage.setItem("todolist", JSON.stringify(todos));
        // showTodo()

        // location.href = "/main/test";
        console.log('${fn:length(todolist)}');

        var num_Arr = [];

        <%--console.log('${todolist}');--%>

        <c:forEach items="${todolist}" var="user_todo">
            console.log(${user_todo.num})
            num_Arr.push(${user_todo.num})
        </c:forEach>

        console.log("num_Arr = " + num_Arr);
        console.log(typeof num_Arr);

        console.log(num_Arr.length);

        for (var i = 0 ; i < num_Arr.length ; i++) {
            console.log(num_Arr[i]);
            console.log(typeof num_Arr[i]);
        }


        <%--console.log(typeof ${todolist});--%>

        <%--for (var i = 0 ; i < ${todolist})--%>


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



    // 필터 버튼 클릭 부분
    filters.forEach(btn => {
        btn.addEventListener("click", () => {
            document.querySelector("span.active").classList.remove("active");
            btn.classList.add("active");

            // location.href = "/main/filters?id="+btn.id;
            let f = document.createElement('form');
            f.setAttribute('method', 'post');
            f.setAttribute('action', '/main/')

            let obj;
            obj = document.createElement('input');
            obj.setAttribute('type', 'hidden');
            obj.setAttribute('name', 'check_filter');
            obj.setAttribute('value', btn.id);

            f.appendChild(obj);

            document.body.appendChild(f);
            f.submit();

        });
    });


    let editNum,
        isEditTask = false;
        // start_date  = document.querySelector("#start_date");

    <!-- 입력 부분 js -->
    const taskInput = document.querySelector(".task-input input");
    taskInput.addEventListener("keyup", e => {
        let userTask = taskInput.value.trim();
        // console.log(userTask);



        if(e.key == "Enter" && userTask) {
            console.log("ㅇ")

            const selectedFile = fileInput.files[0];
            console.log(selectedFile);

            <!-- 편집으로 들어온 경우가 아닐떄 -->
            if(!isEditTask) {
                var form = document.createElement('form');
                form.setAttribute('method','post');
                form.setAttribute('action', '/main/insert')
                form.setAttribute('enctype', 'multipart/form-data');

                var hidden_id = document.createElement('input');
                hidden_id.setAttribute('type', 'hidden');
                hidden_id.setAttribute('name', 'Id');
                hidden_id.setAttribute('value', '${sessionScope.loginId}');

                var upload_img = document.getElementById("fileUpload");

                var hidden_todo = document.createElement('input');
                hidden_todo.setAttribute('type', 'hidden');
                hidden_todo.setAttribute('name', 'Todo');
                hidden_todo.setAttribute('value', userTask);

                var hidden_done = document.createElement('input');
                hidden_done.setAttribute('type', 'hidden');
                hidden_done.setAttribute('name', 'Done');
                hidden_done.setAttribute('value', 0);

                form.appendChild(upload_img);
                form.appendChild(hidden_id);
                form.appendChild(hidden_todo);
                form.appendChild(hidden_done);

                document.body.appendChild(form);
                form.submit();
            } else {
                // 편집으로 들어온 경우에
                isEditTask = false;
                location.href = "/main/edit?num=" + editNum + "&task=" + userTask;

            }


            <%--console.log('${sessionScope.loginId}');--%>
            <%--console.log(userTask);--%>

            // if(!isEditTask) {
            //     todos = !todos ? [] : todos;
            //     let taskInfo = {name: userTask, status: "pending"};
            //     todos.push(taskInfo);
            // } else {
            //     isEditTask = false;
            //     todos[editId].name = userTask;
            // }
            taskInput.value = "";
            // localStorage.setItem("todolist", JSON.stringify(todos));
            // showTodo(document.querySelector("span.active").id);
            // location.href = "/main/userTask="+userTask;
            <%--location.href = "c/cc?loginId="+'${sessionScope.loginId}'+"todo="+userTask;--%>



        }
    });

    // ... 클릭 function => 클릭시 edit 와 delete 보임
    function showMenu(selectedTask, num) {

        let menuDiv = selectedTask.parentElement.lastElementChild
        menuDiv.classList.add("show");

        document.addEventListener("click", e => {
            // console.log("e.target = " + e.target);
            if(e.target.id != "b"+num ) {
                menuDiv.classList.remove("show");
                // console.log("여기 실행 e = " + menuDiv.className);
                // console.log("menuDiv = " + menuDiv.id);
                // console.log(e.target.id);
                // console.log(selectedTask.);
                // console.log(e.)
            }

        });


        // let class_name = document.getElementById("showMenu"+num);
        // // console.log("class_name = " + class_name);
        //
        // // class_name.className += " show";
        // // class_name.classList.add("show");
        //
        // document.addEventListener("click", e => {
        //     console.log("e.target = " + e.target);
        //
        //     if (e.target == s) {
        //         console.log("같은거 클릭중입니다.");
        //     } else {
        //         console.log("다른거 클릭중입니다.");
        //     }
        //
        //     // if(e.target.tagName != "I" || e.target != selectedTask) {
        //     //     menuDiv.classList.remove("show");
        //     // }
        // });


        // // console.log(class_name.target);
        // document.addEventListener("click", e => {
        //
        //     console.log(e.target);
        //     console.log(s);
        //     console.log(s.);
        //
        //     // if(e.target.tagName != "I" || e.target != s) {
        //     //     console.log(e.target.tagName);
        //     //     console.log(e.target);
        //     //     console.log("여기 실행")
        //     //     class_name.classList.remove("show");
        //     // }
        // });


        // console.log("클릭 드리어옴 selectedTask = " + selectedTask);
        // let menuDiv = selectedTask.parentElement.lastElementChild;
        // menuDiv.classList.add("show");
        //
        // selectedTask.parentElement.lastElementChild.classList.add("show");
        //
        // console.log(menuDiv);
        // console.log(menuDiv.classList);
        // document.addEventListener("click", e => {
        //     if(e.target.tagName != "I" || e.target != selectedTask) {
        //         menuDiv.classList.remove("show");
        //     }
        // });
    }

    // 삭제 function
    function deleteTask(deleteNum) {
        location.href = "/main/delete?num="+deleteNum;
    }

    // 수정 function
    function editTask(num, text) {
        editNum = num;
        isEditTask = true;
        taskInput.value = text;
        taskInput.focus();
        taskInput.classList.add("active");
    }

    function updateStatus(num, done) {
        const date = new Date();

        const year = date.getFullYear();
        const month = ('0' + (date.getMonth() + 1)).slice(-2);
        const day = ('0' + date.getDate()).slice(-2);
        const dateStr = year + '-' + month + '-' + day;

        console.log(dateStr);
        console.log(num);

        var form = document.createElement('form');
        form.setAttribute('method','post');
        form.setAttribute('action', '/main/updateStatus')

        var hidden_num = document.createElement('input');
        hidden_num.setAttribute('type', 'hidden');
        hidden_num.setAttribute('name', 'Num');
        hidden_num.setAttribute('value', parseInt(num));

        var hidden_completed_date = document.createElement('input');
        hidden_completed_date.setAttribute('type', 'hidden');
        hidden_completed_date.setAttribute('name', 'Completed_date');
        hidden_completed_date.setAttribute('value', dateStr);

        var hidden_done = document.createElement('input');
        hidden_done.setAttribute('type', 'hidden');
        hidden_done.setAttribute('name', 'Done');
        hidden_done.setAttribute('value', done);

        form.appendChild(hidden_num);
        form.appendChild(hidden_completed_date);
        form.appendChild(hidden_done);

        document.body.appendChild(form);
        form.submit();
    }

    function date() {
        var start_date = document.querySelector("#start_date").value
        var end_date = document.querySelector("#end_date").value
        console.log(start_date);
        console.log(end_date);

        console.log(typeof start_date);

        var form = document.createElement('form');
        form.setAttribute('method','post');
        form.setAttribute('action', '/main/period')

        var hidden_start_date = document.createElement('input');
        hidden_start_date.setAttribute('type', 'hidden');
        hidden_start_date.setAttribute('name', 'start_date');
        hidden_start_date.setAttribute('value', start_date);

        var hidden_end_date = document.createElement('input');
        hidden_end_date.setAttribute('type', 'hidden');
        hidden_end_date.setAttribute('name', 'end_date');
        hidden_end_date.setAttribute('value', end_date);

        form.appendChild(hidden_start_date);
        form.appendChild(hidden_end_date);

        document.body.appendChild(form);
        form.submit();

        // location.href="/main/period?start_date="+start_date+"&end_date="+end_date;
    }


</script>
<%--<!-- <script src="<c:url value="/resources/js/main_page.js" />"></script> -->--%>

</html>

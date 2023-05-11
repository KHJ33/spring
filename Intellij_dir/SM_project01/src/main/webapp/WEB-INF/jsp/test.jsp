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

  </div>
</body>
<script src="<c:url value="/resources/js/t_p.js" />"></script>
</html>

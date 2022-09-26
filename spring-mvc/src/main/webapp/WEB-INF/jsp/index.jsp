<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
	<head> <meta charset="EUC-KR"> </head>
	<body>
	<h1> Index Page </h1>
	김현조 <%=new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date()) %>
	</body>
</html>
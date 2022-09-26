<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% out.println(request.getAttribute("login_id")+"님 이용중입니다."); %>
	<BR><BR>

	<Form Action = "/spring-webdb/add_manager" Method = "post"> 
	
		<Input Type = "Submit" Value = "관리자 추가" > 
	
	</Form>
	
	<Form Action = "/spring-webdb/book_update" Method = "post"> 
	
		<Input Type = "Submit" Value = "북 정보 업데이트" > 
	
	</Form>
	
	<Form Action = "/spring-webdb/quit" Method = "post"> 
	
		<Input Type = "Submit" Value = "종료하기" > 
	
	</Form>
	
</body>
</html>
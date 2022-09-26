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
		
		<Form Action = "/spring-webdb/user_info_change" Method = "post"> 
	
			<Input Type = "Submit" Value = "회원정보 수정" > 
	
		</Form>
		
		
		<Form Action = "/spring-webdb/book_rental" Method = "post"> 
	
			<Input Type = "Submit" Value = "도서 대여" > 
	
		</Form>
		
		<Form Action = "/spring-webdb/book_return" Method = "post"> 
	
			<Input Type = "Submit" Value = "도서 반납" > 
	
		</Form>
		
		<Form Action = "/spring-webdb/book_reservation" Method = "post"> 
	
			<Input Type = "Submit" Value = "도서 예약" > 
	
		</Form>
		
		<Form Action = "/spring-webdb/book_search" Method = "post"> 
	
			<Input Type = "Submit" Value = "도서 검색" > 
	
		</Form>
		
		<Form Action = "/spring-webdb/quit" Method = "post"> 
	
		<Input Type = "Submit" Value = "종료하기" > 
	
		</Form>
		
		
</body>
</html>
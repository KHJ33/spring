<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<Form Action = "/spring-webdb/user_login1" Method = "post"> 
		아이디 : <Input Type = "Text" Name = "ID"> <BR/> 
		비밀번호 : <Input Type = "PassWord" Name = "Pwd"> <BR/><BR/>
		<Input Type = "Submit" Value = "로그인" >
		</Form>

		<Form Action = "/spring-webdb/user" Method = "post"> 
	
		<Input Type = "Submit" Value = "나가기" > 
	
		</Form>
</body>
</html>
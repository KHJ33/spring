<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>

	<Form Action = "/spring-webdb/manager_ok" Method = "post"> 
	아이디 : <Input Type = "Text" Name = "ID"> <BR/> 
	비밀번호 : <Input Type = "PassWord" Name = "Pwd"> <BR/><BR/>
	<Input Type = "Submit" Value = "로그인" ></Form>
	
</body>
</html>
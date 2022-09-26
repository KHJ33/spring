<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<Form Action = "/spring-webdb/join1" Method = "post"> 
	아이디 : <Input Type = "Text" Name = "ID"> <BR/> 
	비밀번호 : <Input Type = "PassWord" Name = "Pwd"> <BR/>
	이름 : <Input Type = "Text" Name = "NAME"> <BR/> 
	전화번호 : <Input Type = "Text" Name = "PHONE"> <BR/>
	주소 : <Input Type = "Text" Name = "ADDRESS"> <BR/><BR/>
	
	<Input Type = "Submit" Value = "등록" >
	</Form>
	
	<Form Action = "/spring-webdb/user" Method = "post"> 
	
		<Input Type = "Submit" Value = "나가기" > 
	
		</Form>
</body>
</html>
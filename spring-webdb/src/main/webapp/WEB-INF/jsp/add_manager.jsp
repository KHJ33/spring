<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 추가</title>
</head>
<body>
	관리자 등록 페이지입니다. 아래를 입력하시오
	<BR><BR>
	
	<Form Action = "/spring-webdb/add_manager1" Method = "post"> 
	아이디 : <Input Type = "Text" Name = "ID"> <BR/> 
	비밀번호 : <Input Type = "PassWord" Name = "Pwd"> <BR/><BR/>
	<Input Type = "Submit" Value = "등록" >
	</Form>
	
	<Form Action = "/spring-webdb/manager1" Method = "post"> 
	
		<Input Type = "Submit" Value = "나가기" > 
	
	</Form>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북 추가페이지</title>
</head>
<body>
	북 추가 페이지입니다 아래를 입력하시오.
	<BR><BR>
	
	<Form Action = "/spring-webdb/add_book_ok" Method = "post"> 
	코드번호 : <Input Type = "Text" Name = "Number"> <BR/> 
	책이름 : <Input Type = "Text" Name = "Name"> <BR/><BR/>
	<Input Type = "Submit" Value = "등록" >
	</Form>
	
	<Form Action = "/spring-webdb/manager1" Method = "post"> 
	
		<Input Type = "Submit" Value = "나가기" > 
	
	</Form>
	
</body>
</html>
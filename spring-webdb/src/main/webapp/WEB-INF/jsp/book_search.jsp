<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	도서를 검색합니다.
	
	<Form Action = "/spring-webdb/book_search1" Method = "post"> 
		도서이름 : <Input Type = "Text" Name = "NAME"> <BR/>
		<Input Type = "Submit" Value = "검색" >
		</Form>
	<Form Action = "/spring-webdb/user_login_ok" Method = "post"> 
	
		<Input Type = "Submit" Value = "나가기" > 
	
		</Form>

</body>
</html>
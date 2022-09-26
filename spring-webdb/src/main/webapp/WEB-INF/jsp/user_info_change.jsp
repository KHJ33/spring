<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원정보수정 페이지 입니다. 아래를 입력하시오<BR><BR>
		<Form Action = "/spring-webdb/user_info_change1" Method = "post"> 
			비밀번호 : <Input Type = "PassWord" Name = "Pwd"> <BR/>
			이름 : <Input Type = "Text" Name = "NAME"> <BR/> 
			전화번호 : <Input Type = "Text" Name = "PHONE"> <BR/>
			주소 : <Input Type = "Text" Name = "ADDRESS"> <BR/><BR/>
			
			<Input Type = "Submit" Value = "수정" >
			</Form>
		<Form Action = "/spring-webdb/user_login_ok" Method = "post"> 
	
		<Input Type = "Submit" Value = "나가기" > 
	
		</Form>
</body>
</html>
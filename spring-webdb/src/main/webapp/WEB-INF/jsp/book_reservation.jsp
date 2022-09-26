<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		예약가능한 책 목록
		<BR><BR>
<!--	
		<ul>
		<c:forEach var="book" items="${reservation_books}" varStatus="status">
			<li> ${status.index+1} : 
			${book.number}, ${book.name}, ${book.borrow} ,${book.reservation}
			</li>
		</c:forEach>
		</ul>
-->	
		<table>
		<tr>
			<td>코드번호</td>
			<td>책이름</td>
			<td>대여중인 ID</td>
			<td>예약자 ID</td>
		</tr>
		<c:forEach var="book" items="${reservation_books}" varStatus="status">
		<tr>
			<td>${book.number}</td>
			<td>${book.name}</td>
			<td>${book.borrow}</td>
			<td>${book.reservation}</td>
		</tr>
		</c:forEach>
	</table>
	<BR><BR>

		예약 하실 북 번호를 입력하시오
		<Form Action = "/spring-webdb/book_reservation1" Method = "post"> 
		코드번호 : <Input Type = "Text" Name = "Number"> <BR/>
		<Input Type = "Submit" Value = "확인" >
		</Form>
		<Form Action = "/spring-webdb/user_login_ok" Method = "post"> 
	
		<Input Type = "Submit" Value = "나가기" > 
	
		</Form>
		
		<style>
		  table {
		    width: 100%;
		    border-top: 1px solid #444444;
		    border-collapse: collapse;
		  }
		  th, td {
		    border-bottom: 1px solid #444444;
		    padding: 10px;
		    text-align: center;
		  }
		  thead tr {
		    background-color: #0d47a1;
		    color: #ffffff;
		  }
		  tbody tr:nth-child(2n) {
		    background-color: #bbdefb;
		  }
		  tbody tr:nth-child(2n+1) {
		    background-color: #e3f2fd;
		  }
	</style>
</body>
</html>
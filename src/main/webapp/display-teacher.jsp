
<%@page import="com.ty.dto.Teacher"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<table>
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>Edit<th>
			<th>Delete</th>
		</tr>
		<c:forEach var="teacher" items="${teacherlist}">
			
		
		<tr>
			
			<td>${teacher.getId()}</td>
			<td>${teacher.getName()}</td>
			<td><button><a href="editTeacher?id=${teacher.getId()}">Edit</a></button></td>
			<td><button><a href="deleteteacher?id=${teacher.getId()}">Delete</a></button></td>
		</tr>
		
		</c:forEach>
	</table>

</body>
</html>
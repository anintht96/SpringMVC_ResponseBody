<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>

	<form:form modelAttribute="user" method="POst" action="addUser">
		<table>
			<tr>
				<td>ID: </td>
				<td> <form:input path="id"/> </td>
			</tr>
			<tr>
				<td>Name: </td>
				<td> <form:input path="name"/> </td>
			</tr>
			<tr>
				<td>Email: </td>
				<td> <form:input path="email"/> </td>
			</tr>
			<tr>
				<td colspan="2"> <input type="submit" value="Add User"> </td>
			</tr>
		</table>
		
	</form:form>

</body>
</html>
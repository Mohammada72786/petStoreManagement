<%@page import="com.anmlmanagement.model.Food"%>
<%@page import="java.util.List"%>
<%@page import="com.anmlmanagement.model.Dog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<title>Animal Management</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<br>
	<div class="container">

		<form:form action="${pageContext.request.contextPath}/add-food"  method="post" modelAttribute="food">
			<table class="table bg-info">
				<tr>
					<td><label for="name">Name</label></td>
					<td><form:input id="name" path="name" placeholder="Enter name of dog"/></td>
				</tr>
				<tr>
					<td><label for="type" >Type of Food</label></td>
					<td><form:select path="type" id="gender" required="true">
							<form:option value="SOLID">Solid</form:option>
							<form:option value="LIQUID">Liquid</form:option>
					</form:select></td>
				</tr>
			</table>
			<form:button value="submit">Add</form:button>
		</form:form>
		${error}
	</div>
</body>
</html>
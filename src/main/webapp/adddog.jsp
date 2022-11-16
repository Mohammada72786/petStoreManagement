<%@page import="com.animalmanagement.model.Food"%>
<%@page import="java.util.List"%>
<%@page import="com.animalmanagement.model.Dog"%>
<%@page import="com.animalmanagement.dao.impl.DogDaoImpl"%>
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

		<form:form action="add-dog"  method="post" modelAttribute="dog">
			<table class="table bg-info">
				<tr>
					<td><label for="name">Name</label></td>
					<td><form:input id="name" path="name" placeholder="Enter name of dog"/></td>
				</tr>
				<tr>
					<td><label for="weight">Weight</label></td>
					<td><form:input id="weight" path="weight" placeholder="Enter weight in Kgs" /></td>
				</tr>
				<tr>
					<td><label for="colour" >colour</label></td>
					<td><form:input path="colour" id="colour" 
						placeholder="Enter color of your dog" required="true" /></td>
				</tr>
				<tr>
					<td><label for="gender" >Gender</label></td>
					<td><form:select path="gender" id="gender" required="true">
							<form:option value="MALE">MALE</form:option>
							<form:option value="FEMALE">FEMALE</form:option>
					</form:select></td>
				</tr>
				<tr>
					<td><label for="dateofbirth" >Date Of Birth</label></td>
					<td><form:input path="dateOfBirth" placeholder="dd/mm/yyyy"  id="dateofbirth"/></td>
				</tr>
				<tr>
					<td><label for="speed" >Speed</label></td>
					<td><form:input id="speed" path="speed"
						placeholder="Enter speed in Km/h"/></td>
				</tr>
			</table>
			<form:button value="submit">Add</form:button>
		</form:form>
		${error}
	</div>
</body>
</html>
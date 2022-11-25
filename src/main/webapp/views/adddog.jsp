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

		<form:form action="${pageContext.request.contextPath}/add-dog"  method="post" modelAttribute="dog">
			<table class="table bg-info">
				<tr>
					<td><label for="name">Name</label></td>
					<td><form:input id="name" path="name" placeholder="Enter name of dog"/></td>
				</tr>
				<tr>
					<td><label for="weight">Weight</label>
					<form:errors path="weight" ></form:errors></td>
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
					</form:select>
					<form:errors path="gender" ></form:errors></td>
				</tr>
				<tr>
					<td><label for="dateofbirth" >Date Of Birth</label></td>
					<td><form:input path="dateOfBirth"  placeholder="dd/mm/yyyy" id="dateofbirth"/>
					 <form:errors path="dateOfBirth" ></form:errors></td>
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
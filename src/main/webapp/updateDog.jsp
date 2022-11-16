<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<form:errors path="dog*"/>
		<form:form action="${pageContext.request.contextPath}/add-dog"  method="post" modelAttribute="dog">
			<table class="table bg-info">
			<tr>
					<td><label for="id">Dog ID</label></td>
					<td><form:input id="id" path="id" placeholder="Enter name of dog"
					value="${dog.id}" readonly="true"/></td>
				</tr>
				<tr>
					<td><label for="name">Name</label></td>
					<td><form:input id="name" path="name" placeholder="Enter name of dog"
					value="${dog.name}"/></td>
				</tr>
				<tr>
					<td><label for="weight">Weight</label></td>
					<td><form:input id="weight" path="weight" placeholder="Enter weight in Kgs" 
					value="${dog.weight}"/></td>
				</tr>
				<tr>
					<td><label for="colour" >colour</label></td>
					<td><form:input path="colour" id="colour" 
						placeholder="Enter color of your dog" required="true" 
						value="${dog.colour}"/></td>
				</tr>
				<tr>
					<td><label for="gender" >Gender</label></td>
					<td><form:select path="gender" id="gender" required="true" value="${dog.gender}">
							<form:option value="MALE">MALE</form:option>
							<form:option value="FEMALE">FEMALE</form:option>
					</form:select></td>
				</tr>
				<tr>
					<td><label for="dateofbirth" >Date Of Birth</label></td>
					<td><form:input path="dateOfBirth" placeholder="dd/mm/yyyy"  id="dateofbirth"
					value="${dog.dateOfBirth}"/></td>
				</tr>
				<tr>
					<td><label for="speed" >Speed</label></td>
					<td><form:input id="speed" path="speed"
						placeholder="Enter speed in Km/h"
						value="${dog.speed}"/></td>
				</tr>
				<tr>
					<td><label for="createdAt">Created at</label></td>
					<td><form:input path="createdAt" id="createdAt"
					value="${dog.createdAt}"/></td>
				</tr>
				<tr>
					<td><label for="isDeleted" > </label></td>
					<td><form:input path="isDeleted" 
					value="${dog.isDeleted}" readonly="true"/></td>
				</tr>
			</table>
			<form:button value="submit">Update</form:button>
		</form:form>

</body>
</html>
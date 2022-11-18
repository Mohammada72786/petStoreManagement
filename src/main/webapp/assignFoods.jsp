<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="row">
		<div class="col-lg-6">
			<table class="table table-bordered">
				<tr class="bg-primary">
					<td>Id</td>
					<td>Name</td>
					<td>Speed</td>
					<td>Colour</td>
					<td>Weight</td>
					<td>Date of birth</td>
				</tr>
				<tr>
					<td>${dog.id}</td>
					<td>${dog.name}</td>
					<td>${dog.speed}</td>
					<td>${dog.weight}</td>
					<td>${dog.colour}</td>
					<td>${dog.dateOfBirth}</td>
				</tr>
			</table>
		</div>
		<div class="col-sm-6">
			<form action="${pageContext.request.contextPath}/assign-foods" method="post">
				<table class="table table bordered">
					<c:forEach items="${foods }" var="food">
						<tr>
							<td><input type="checkbox" value="${food.id}" name="foodIds" />${food.name}<br>
							<hr></td>
						</tr>
					</c:forEach>
				</table>
				<input type="hidden" name="dogId" value="${dog.id}"/>
				<button class="btn btn-success">Assign</button>
			</form>
		</div>
	</div>

</body>
</html>
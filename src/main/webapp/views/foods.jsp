<%@page import="java.util.List"%>
<%@page import="com.anmlmanagement.model.Food"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
    function CheckNumeric(e) {
        if (window.event) 
        {
            if ((e.keyCode <48 || e.keyCode > 57) & e.keyCode != 8 && e.keyCode != 44) {
                event.returnValue = false;
                return false;
            }
        }
        else {
            if ((e.which <48 || e.which > 57) & e.which != 8 && e.which != 44) {
                e.preventDefault();
                return false;
            }
        }
    }     
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<Table class="table table-dark table-striped">
					<tr>
						<td>food Id</td>
						<td>Name</td>
						<td>Type</td>
						<td colspan="2">Action</td>
					</tr>
					<c:forEach items="${foods }" var="food">
						<tr>
							<td>${food.id }</td>
							<td>${food.name }</td>
							<td>${food.type }</td>
							<td><a
								href="${pageContext.request.contextPath}/delete/${food.id }"><span
									class="glyphicon glyphicon-trash"></span></a></td>
							<td><a
								href="${pageContext.request.contextPath}/update/${food.id }"><span
									class="glyphicon glyphicon-edit"></span></a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-sm-6">
				<hr>
				<hr>
				<label for="id">Search by ID</label>
				<form action="getfoodbyid" method="get">
					<input type="number" id="id" name="id" placeholder="enter food id"
						required>
					<button type="submit" value="submit">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>
				<hr>
				<hr>
				<label for="name">Enter food's Name</label>
				<form class="form" action="foodsByName" method="get">
					<input type="text" name="name" id="name"
						placeholder="Enter food Name" required>
					<button type="submit" value="submit">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>
				<c:if test="${food != null}">
					<Table class="table table-dark table-striped">
						<tr>
							<td>food Id</td>
							<td>Name</td>
							<td>Type</td>
						</tr>
						<tr>
							<td>${food.id }</td>
							<td>${food.name }</td>
							<td>${food.type }</td>
							<td><a
								href="${pageContext.request.contextPath}/delete/${food.id }"><span
									class="glyphicon glyphicon-trash"></span></a></td>
							<td><a
								href="${pageContext.request.contextPath}/update/${food.id }"><span
									class="glyphicon glyphicon-edit"></span></a></td>
						</tr>
					</Table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>
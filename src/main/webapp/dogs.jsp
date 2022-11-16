<%@page import="java.util.List"%>
<%@page import="com.animalmanagement.model.Dog"%>
<%@page import="com.animalmanagement.model.Food"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
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
	<tr > 
	<td>Dog Id</td>
	<td>Name</td>
	<td>Speed</td>
	<td>Weight</td>
	<td>Date of Birth</td>
	<td>Gender</td>
	<td>Colour</td>
	</tr>
		<c:forEach items="${dogs }" var="dog">
		<tr>
		<td>${dog.id }</td>
		<td>${dog.name }</td>
		<td>${dog.speed }</td>
		<td>${dog.weight }</td>
		<td>${dog.dateOfBirth }</td>
		<td>${dog.gender }</td>
		<td>${dog.colour }</td>
		<td><a href="delete/${dog.id }"><span class="glyphicon glyphicon-trash"></span></a></td>
		<td><a href="update/${dog.id }"><span class="glyphicon glyphicon-edit"></span></a></td>
		</tr>
		</c:forEach>
	</Table>
	</div>
	<div class="col-sm-6">
	Search by ID
	<form action="getdogbyid" method="get">
	Dog id <input type ="number" name="id" placeholder="enter Dog id" required>
	<button type="submit" value="submit"><span class="glyphicon glyphicon-search"></span></button>
	</form>
	<c:if test="${dog != null}">
	<Table class="table table-dark table-striped">
	<tr > 
	<td>Dog Id</td>
	<td>Name</td>
	<td>Speed</td>
	<td>Weight</td>
	<td>Date of Birth</td>
	<td>Gender</td>
	<td>Colour</td>
	</tr>
	<tr>
	<td>${dog.id }</td>
	<td>${dog.name }</td>
	<td>${dog.speed }</td>
	<td>${dog.weight }</td>
	<td>${dog.dateOfBirth }</td>
	<td>${dog.gender }</td>
	<td>${dog.colour }</td>
	<td><a href="delete/${dog.id }"><span class="glyphicon glyphicon-trash"></span></a></td>
	<td><a href="update/${dog.id }"><span class="glyphicon glyphicon-edit"></span></a></td>
	</tr>
	</Table>
	</c:if>
	</div>
	</div>
	</div>
</body>
</html>
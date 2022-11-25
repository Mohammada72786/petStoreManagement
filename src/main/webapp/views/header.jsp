<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@page  isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<style>
.jumbotron {
	height: 35px;
}
</style>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
</head>
<body>
	<div class="container">
		<div class="jumbotron" style="background: khaki">
			<div class="text-center">
				<h3 class="bg-info">A pet is the only thing on earth that loves
					you more than you love yourself.</h3>
			</div>
		</div>
		<ul class="nav nav-pills nav-justified">
			<li class="active"><a href="${path }/index">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Dog <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${path }/adddog">Add Dog </a></li>
					<li><a href="${path }/displaydogs">Remove Dog</a></li>
					<li><a href="${path }/displaydogs">Update Dog </a></li>
					<li><a href="${path }/displaydogs"> Display Dogs</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Food<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${path }/addFood">Add Food</a></li>
					<li><a href="${path }/removefood.jsp">Remove Food</a></li>
					<li><a href="${path }/updatefood.jsp">Update Food</a></li>
					<li><a href="${path }/displayFoods"> Display Foods</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Pet Store<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${path }/addPetStore">Add Pet Store</a></li>
					<li><a href="${path }/removePetStore">Remove Pet Store</a></li>
					<li><a href="${path }/updatePetStore">Update Pet Store</a></li>
					<li><a href="${path }/displayPetStores"> Display Pet Stores</a></li>
				</ul></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Breed<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="${path }/addBreed">Add Breed</a></li>
					<li><a href="${path }/removeBreed">Remove breed</a></li>
					<li><a href="${path }/updateBreed">Update Breed</a></li>
					<li><a href="${path }/displayBreeds"> Display Breeds</a></li>
				</ul></li>
		</ul>
	</div>
</body>
</html>
<%@page import="java.util.List"%>
<%@page import="com.animalmanagement.model.Dog"%>
<%@page import="com.animalmanagement.model.Food"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<c:forEach items="${dogs} var="dog">
		<table><tr><td>${dog.id}</td></tr></table>
		
		</c:forEach>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="https://jakarta.ee/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car List</title>
</head>
<body>
    <h2>List of Cars</h2>
    <ul>
        <c:forEach var="car" items="${carList}">
            <li>${car}</li>
        </c:forEach>
    </ul>
</body>
</html>
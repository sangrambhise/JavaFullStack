<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Error</title></head>
<body>
    <h2>Error Occurred</h2>
    <p>${errorMessage}</p>
    <a href="/employees">Back to Employee List</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Employee List</title>
</head>
<body>
<h2>Employee List</h2>

<a href="/employees/add">Add New</a>

<form action="/employees/search" method="get" style="margin-top: 10px;">
    <input type="text" name="keyword" placeholder="Search by Name or ID" />
    <input type="submit" value="Search" />
</form>

<table border="1" style="margin-top: 10px;">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Type</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.type}</td>
            <td>
                <a href="/employees/edit/${emp.id}">Edit</a> |
                <a href="/employees/delete/${emp.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

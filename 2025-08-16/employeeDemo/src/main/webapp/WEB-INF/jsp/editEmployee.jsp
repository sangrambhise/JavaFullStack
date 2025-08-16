<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Edit Employee</title>
</head>
<body>

<h2>Edit Employee</h2>

<form action="/employees/update/${employee.id}" method="post">
    Name: <input type="text" name="name" value="${employee.name}" /><br/>
    Type: <input type="text" name="type" value="${employee.type}" /><br/>

    City: <input type="text" name="address.city" value="${employee.address.city}" /><br/>
    State: <input type="text" name="address.state" value="${employee.address.state}" /><br/>
    Country: <input type="text" name="address.country" value="${employee.address.country}" /><br/>
    Zip Code: <input type="text" name="address.zipCode" value="${employee.address.zipCode}" /><br/>

    Department: <input type="text" name="department.name" value="${employee.department.name}" /><br/>

    <input type="submit" value="Update" />
</form>

<a href="/employees">Back to List</a>

</body>
</html>

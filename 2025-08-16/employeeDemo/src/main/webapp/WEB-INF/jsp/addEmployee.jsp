<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head><title><c:if test="${employee.id == null}">Add</c:if><c:if test="${employee.id != null}">Edit</c:if> Employee</title></head>
<body>
<h2><c:if test="${employee.id == null}">Add</c:if><c:if test="${employee.id != null}">Edit</c:if> Employee</h2>

<c:if test="${employee.id == null}">
    <form action="/employees/save" method="post">
</c:if>
<c:if test="${employee.id != null}">
    <form action="/employees/update/${employee.id}" method="post">
</c:if>

    Name: <input type="text" name="name" value="${employee.name}"/><br/>
    Type: <input type="text" name="type" value="${employee.type}"/><br/>

    City: <input type="text" name="address.city" value="${employee.address.city}"/><br/>
    State: <input type="text" name="address.state" value="${employee.address.state}"/><br/>
    Country: <input type="text" name="address.country" value="${employee.address.country}"/><br/>
    Zip Code: <input type="text" name="address.zipCode" value="${employee.address.zipCode}"/><br/>

    Department:
    <select name="department.id">
        <c:forEach var="dept" items="${departments}">
            <option value="${dept.id}" <c:if test="${employee.department != null && employee.department.id == dept.id}">selected</c:if>>${dept.name}</option>
        </c:forEach>
    </select><br/>

    <input type="submit" value="Submit"/>
</form>

<a href="/employees">Back to List</a>
</body>
</html>

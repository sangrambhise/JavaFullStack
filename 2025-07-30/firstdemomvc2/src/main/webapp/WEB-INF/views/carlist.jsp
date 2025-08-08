<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Car List</title>
</head>
<body>
    <h2>Car Names</h2>
    <ul>
        <c:forEach var="car" items="${cars}">
            <li>${car}</li>
        </c:forEach>
    </ul>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration</h2>
    <form action="register" method="post">
        <label>Username:</label><br>
        <input type="text" name="username"><br><br>
        <label>Email:</label><br>
        <input type="email" name="userEmail"><br><br>
        <label>Phone:</label><br>
        <input type="text" name="userPhone"><br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>

<%@ page import="java.sql.*, com.mycompany.craftwebsite.business.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="style.css" >
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Order Confirmation</title>
</head>
<body>
    <h2>Order Confirmation</h2>
    <p>Thank you for your purchase! Your order ID is <c:out value="${param.orderId}" />.</p>
    <p><a href="home.jsp">Return to Home</a></p>
</body>
</html>
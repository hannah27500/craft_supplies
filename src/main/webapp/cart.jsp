
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name = "description" content ="Craft Supplies">
    <meta name = "author" content = "Hannah Evans">
    <meta name = "viewport" content = "width=device-width, initial-scale=1.0">
    <title>Craft Supplies Cart</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


    <link rel="stylesheet" href="style.css" >
</head>
<body>
<%@include file="header.jsp" %>
<section class="m-5">
<h1>Cart</h1>
    <c:choose>
        <c:when test="${empty sessionScope.cart}">
            <p>Your cart is empty.</p>
        </c:when>
        <c:otherwise>
            <div class="row">
                <c:forEach var="product" items="${sessionScope.cart}">
                    <div class="col-md-4 mb-4">
                        <div class="card">
                            <img src="images/${product.productID}.jpg" class="card-img-top" alt="${product.productName}">
                            <div class="card-body">
                                <h5 class="card-title">${product.productName}</h5>
                                <p class="card-text">${product.productDesc}</p>
                                <p class="card-text">$${product.price}</p>
                                <form action="CartServlet" method="post">
                                    <input type="hidden" name="cartItemID" value="${cartItem.cartItemID}">
                                   
                                    <button type="submit" class="btn btn-danger">Remove</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>
</section>
<%@include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>     
</body>

</html>
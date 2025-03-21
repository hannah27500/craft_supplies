
<%@page import="java.util.List"%>
<%@page import="com.mycompany.craftwebsite.business.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name = "description" content ="Craft Supplies">
    <meta name = "author" content = "Hannah Evans">
    <meta name = "viewport" content = "width=device-width, initial-scale=1.0">
    <title>Craft Supplies Shop</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


    <link rel="stylesheet" href="style.css" >
</head>
<%@include file="header.jsp" %>
<section class="m-5">
<h1>Our Products</h1>
    <!--Variable for product category-->
    <c:set var="currentCategory" value="" scope="page"/>
    <div class="row">
        <c:forEach var="product" items="${products}">
            
            <!-- Check if the category has changed -->
            <c:if test="${currentCategory ne product.category}">
                <div class="col-12">
                    <h2 class="mt-4">${product.category}</h2>
                    <hr>
                </div>
                <c:set var="currentCategory" value="${product.category}" scope="page"/>
            </c:if>
            
            <!-- Product Cards -->
            <div class="col-md-4 mb-4">
                <div class="card">
                    <img src="images/${product.productID}.jpg" class="card-img-top" alt="${product.productName}">
                    <div class="card-body">
                        <h5 class="card-title">${product.productName}</h5>
                        <p class="card-text">${product.productDesc}</p>
                        <p class="card-text">$${product.price}</p>

                       <form action="CartServlet" method="post">
                            <input type="hidden" name="productID" value="${product.productID}">
                            <input type="hidden" name="action" value="add">
                            <c:choose>
                                <c:when test="${product.stockQuantity > 0}">
                                    <button type="submit" class="btn btn-primary">Add to Cart</button>
                                </c:when>
                            <c:otherwise>
                                <button class="btn btn-secondary" disabled>Out of Stock</button>
                            </c:otherwise>
                        </c:choose>
</form>
                    </div>
                </div>
            </div>
            
        </c:forEach>
    </div>
</section>

<%@include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>     
</body>

</html>	

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.mycompany.craftwebsite.DAOClass" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css" >
</head>
<body>
    <%@ include file="header.jsp" %>

    <section class="m-5">
        <h1>Checkout</h1>
        
        <c:if test="${empty sessionScope.cart}">
            <p>Your cart is empty. <a href="index.jsp">Continue Shopping</a></p>
        </c:if>

        <c:if test="${not empty sessionScope.cart}">
            <h2>Order Summary</h2>
            <div class="row">
                <c:forEach var="cartItem" items="${sessionScope.cart}">
                    <div class="col-md-4 mb-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">${DAOClass.getProductByID(cartItem.productId).productName}</h5>
                                <p class="card-text">${DAOClass.getProductByID(cartItem.productId).productDesc}</p>
                                <p class="card-text">$${cartItem.totalPrice}</p>
                                <p class="card-text">Quantity: ${cartItem.quantity}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

           <h3>Total Price: $
    <c:set var="total" value="0" />
    <c:forEach var="cartItem" items="${sessionScope.cart}">
        <c:set var="total" value="${total + (cartItem.totalPrice * cartItem.quantity)}" />
    </c:forEach>
    <fmt:formatNumber value="${total}" type="number" minFractionDigits="2" maxFractionDigits="2" />
</h3>

            <h2>Enter Shipping and Payment Details</h2>
            <form action="PlaceOrderServlet" method="POST">
                <div class="mb-3">
                    <label for="firstName" class="form-label">First</label>
                    <input type="text" id="firstName" name="firstName" class="form-control" value="${sessionScope.firstName}" required>
                </div>
                <div class="mb-3">
                    <label for="lastName" class="form-label">First</label>
                    <input type="text" id="lastName" name="lastName" class="form-control" value="${sessionScope.lastName}" required>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Street Address</label>
                    <input type="text" id="address" name="address" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="city" class="form-label">City</label>
                    <input type="text" id="city" name="city" class="form-control" required>
                </div>
                <div>
                    <label for="state" class="form-label">State</label>
                    <input type="text" id="state" name="state" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="zip" class="form-label">Zip Code</label>
                    <input type="text" id="zip" name="zip" class="form-control"  required>
                    <c:if test="${param.error == 'InvalidZip'}">
                        <p style="color: red;">Invalid Zip Code. Please enter a 5-digit ZIP code.</p>
                    </c:if>
                </div>
                <div class="mb-3">
                    <label for="card-number" class="form-label">Card Number</label>
                    <input type="text" id="card-number" name="card-number" class="form-control" required>
                    <c:if test="${param.error == 'InvalidCardNum'}">
                        <p style="color: red;">Invalid Card Number. Please enter a 16-digit Card Number.</p>
                    </c:if>
                </div>
                <div class="mb-3">
                    <label for="cvv" class="form-label">CVV</label>
                    <input type="text" id="cvv" name="cvv" class="form-control" required>
                    <c:if test="${param.error == 'InvalidCVV'}">
                        <p style="color: red;">Invalid CVV. Please enter a 3-digit CVV.</p>
                    </c:if>
                </div>
                <button type="submit">Place Order</button>
            </form>
        </c:if>
    </section>

    <%@ include file="footer.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>     
</body>
</html>
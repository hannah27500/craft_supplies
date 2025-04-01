
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name = "description" content ="Craft Supplies">
    <meta name = "author" content = "Hannah Evans">
    <meta name = "viewport" content = "width=device-width, initial-scale=1.0">
    <title>Craft Supplies Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


    <link rel="stylesheet" href="style.css" >
</head>
<body>
<%@include file="header.jsp" %>

<section class="m-5">
   <h1>Craft Supplies</h1>
   <p>Welcome to Craft Supplies! We are a company devoted to making crafting as efficient and affordable for our customers. We provide free shipping worldwide and ensure a fast delivery within 5 business days. <br><br> Enjoy shopping with us!</p>
    <h2>Featured Craft Supplies</h2>
    <div class="row">
            <div class="col-md-4 mb-4">
                <div class="card bg-gray" style="color:white;">
                    <img src="images/watercolor_set.jpg" class="card-img-top" alt="Watercolor Set">
                    <div class="card-body">
                        <h5 class="card-title">Watercolor Set</h5>
                        <p class="card-text">A beginner-friendly set of watercolor paints.</p>
                        <p class="card-text">$12.99</p>
                    </div>
                </div>
            </div>
   
            <div class="col-md-4 mb-4">
                <div class="card bg-gray" style="color:white;">
                    <img src="images/sewing_machine.jpg" class="card-img-top" alt="Sewing Machine">
                    <div class="card-body">
                        <h5 class="card-title">Sewing Machine</h5>
                        <p class="card-text">Compact and easy-to-use sewing machine.</p>
                        <p class="card-text">$99.99</p>
                    </div>
                </div>
            </div>
    
            <div class="col-md-4 mb-4">
                <div class="card bg-gray" style="color:white;">
                    <img src="images/colored_pencils.jpg" class="card-img-top" alt="Colored Pencils">
                    <div class="card-body">
                        <h5 class="card-title">Colored Pencils Set</h5>
                        <p class="card-text">Assorted colored pencils for vibrant artwork.
</p>
                        <p class="card-text">$14.99</p>
                    </div>
                </div>
            </div>
    </div>
</section>
<section class="m-5">
    <h2>Why Shop With Us?</h2>
    <ul class="list-group">
        <li class="list-group-item"><strong>✨ High-Quality Supplies:</strong> We carefully select our materials to ensure durability and performance.</li>
        <li class="list-group-item"><strong>🚚 Fast & Free Shipping:</strong> Get your craft essentials delivered to your door quickly.</li>
        <li class="list-group-item"><strong>💰 Affordable Prices:</strong> Creativity should be accessible—our prices fit every budget.</li>
    </ul>
</section>

<%@include file="footer.jsp" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>     
</body>

</html>
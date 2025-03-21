
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Craft Supplies Login</title>
        <link rel="stylesheet" href="style.css" >
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="style.css">
       
    </head>
    <body>
    <header class="header" id="top">
        <h1>Craft Supplies</h1>
        <nav class="navbar sticky-top navbar-expand-lg bg-gray navbar-dark px-2 py-lg-2">
            <div class="container-fluid">
                <ul class="navbar-nav me-auto" style="padding: 20px;">
                </ul>
            </div>
        </nav>
    </header>
        <section class="m-5">
        <h1> Login to your account</h1>
        <div style="padding: 10px;">
           <form action="LoginServlet" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <button type="submit">Login</button>
            <br>
        </form>
        </div>
        <br>
        <p>Don't have an account?</p>
        <form action="create-account.jsp" method="GET">
                <button type="submit">Create Account</button>
            </form>
        </section>
        <section style="height: 400px"></section>
        <%@include file="footer.jsp" %>
        <a href="test.jsp">Test</a>
        </body>
</html>

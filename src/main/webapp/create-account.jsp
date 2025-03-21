<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create an Account</title>
    <link rel="stylesheet" href="style.css">
    <style>
        body {
            margin: 20px;
        }
        input {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h1>Create an Account</h1>
    <form action="NewAccountServlet" method="POST">
        
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required>
        <br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required>
        <br>
        
        <label for="newUsername">Username:</label>
        <input type="text" id="newUsername" name="newUsername" required>
         <br> 
        <label for="newPassword">Password:</label>
        <input type="password" id="newPassword" name="newPassword" required>
         <br>
        <button type="submit">Create Account</button>
    </form>
</body>
</html>
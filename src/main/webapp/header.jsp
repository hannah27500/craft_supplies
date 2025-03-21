<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header" id="top">
    <h1>Craft Supplies</h1>
    <nav class="navbar sticky-top navbar-expand-lg bg-gray navbar-dark px-2 py-lg-2">
        <div class="container-fluid">
            <ul class="navbar-nav me-auto">
                <li class="nav-item mx-lg-4"><a class="nav-link" href="home.jsp">Home</a></li>
                <li class="nav-item mx-lg-4"><a class="nav-link" href="shop">Shop</a></li>
                <li class="nav-item mx-lg-4"><a class="nav-link" href="cart.jsp">Cart</a></li>
             
            </ul>

            <!-- Display Logged-in Username (Only if User is Logged In) -->
            <ul class="navbar-nav">
                <%
                    String username = (String) session.getAttribute("username");
                    if (username != null) {
                %>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Logged in as: <%= username %>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                        <li><a class="dropdown-item" href="#" data-bs-toggle="modal" data-bs-target="#logoutModal">Logout</a></li>
                    </ul>
                </li>
                <% } %>
            </ul>
        </div>
    </nav>
</header>

<!-- Logout Modal -->
<div class="modal fade" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="logoutModalLabel">Confirm Logout</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Are you sure you want to log out?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                <form action="LogoutServlet" method="post">
                    <button type="submit" class="btn btn-danger">Logout</button>
                </form>
            </div>
        </div>
    </div>
</div>

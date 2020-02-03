<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>My Awesome Website</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css">
    <%--<link rel="stylesheet"--%>
          <%--href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">--%>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>

    <script>
        $(document).ready(function () {
            $("#products").click(function (event) {
                $('#main').load("products");
            });
            $("#all-orders").click(function (event) {
                $('#main').load("all-orders");
            });
            $("#user-orders").click(function (event) {
                $('#main').load("user-orders");
            });
            $("#wish-list").click(function (event) {
                $('#main').load("wish-list");
            });
            $("#cart").click(function (event) {
                $('#main').load("cart");
            });
            $("#about").click(function (event) {
                $('#main').load("about");
            });
            $("#signup").click(function (event) {
                $('#main').load("signup");
            });
        });


    </script>
</head>
<body>

<!-- the header -->
<header>

    <!-- our main logo -->
    <a id="logo" href="index.html">
        <img src="${pageContext.request.contextPath}/resource/images/avatar.png" alt="Logo">
        <span>Ecommerce Website</span>
    </a>

    <!-- main navigation links -->
    <nav>
        <ul>
            <li><a href="#" id="products">Products</a></li>
            <li><a href="#" id="cart">Cart</a></li>
            <li><a href="#" id="user-orders">My Orders</a></li>
            <li><a href="#" id="all-orders">All Orders</a></li>
            <li><a href="#" id="wish-list">Wish list</a></li>
            <li><a href="#" id="about">About</a></li>
            <li><a href="#" id="signup">Sign Up</a></li>
        </ul>
    </nav>

</header>

<!-- the content -->
<main>

    <!-- testimonials section -->
    <div class="site-section site-section-secondary">
        <div class="site-section-inside" id="main" style="min-height: 500px">


        </div>


    </div>

</main>

<!-- the footer -->
<footer>
    <img src="<spring:url value="/resource/images/avatar.png"/>" alt="Footer Logo">
    <span>Ecommerce Website</span>
</footer>

</body>
</html>

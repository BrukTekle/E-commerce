<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>My Awesome Website</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/style.css"/>

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>

    <script>
        $(document).ready(function () {
            $("#products").click(function (event) {
                $('#main').load("products");
            });
            $("#addProduct").click(function (event) {
                $('#main').load("addProduct");
            });
            $("#all-orders").click(function (event) {
                $('#main').load("orders/all-orders");
            });
            $("#user-orders").click(function (event) {

                <security:authorize access="isAuthenticated()">
                $('#main').load("orders/<security:authentication property="principal.username"/>");
                </security:authorize>

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
            $("#login").click(function (event) {
                $('#main').load("login");
            });

        });


    </script>
</head>
<body>

<!-- the header -->
<header>

    <a id="logo" href="index.html">
        <img src="${pageContext.request.contextPath}/resource/images/avatar.png" alt="Logo"/>
        <span>Ecommerce Website
           <P>  Welcome Back</P>
            <security:authorize access="isAuthenticated()">
                <div id="username"><security:authentication property="principal.username"/></div>
            </security:authorize>
        </span>
    </a>

    <!-- main navigation links -->
    <nav>
        <ul>
        	<li><a href="#" id="about">About</a></li>
            <li><a href="#" id="products">Products</a></li>
            <security:authorize access="hasRole('ROLE_ADMIN')">

			    <li><a href="<spring:url value='/addProduct' />" id="addProduct">Add Product</a></li>
            	<li><a href="#" id="all-orders">All Orders</a></li>
			</security:authorize>
            
            <security:authorize access="!isAuthenticated()">
				<li><a href="<spring:url value='/members/add' />" id="signup">Sign Up</a></li>
	            <li><a href="<spring:url value='/login' />" id="login">Login</a></li>
			</security:authorize>
			
			 <security:authorize access="isAuthenticated()">
				 <li><a href="#" id="cart">Cart</a></li>
	             <li><a href="#" id="user-orders">My Orders</a></li>
	             <li><a href="#" id="wish-list">Wish list</a></li>
				 <li><a href="<spring:url value="/logout" />" id="logout">Logout</a></li> 
			</security:authorize>
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
    <img src="<spring:url value='/resource/images/avatar.png'/>" alt="Footer Logo">
    <span>Ecommerce Website</span>
</footer>

</body>
</html>

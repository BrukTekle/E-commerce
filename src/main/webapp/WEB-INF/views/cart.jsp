<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <security:csrfMetaTags/>

    <script>

        $(document).ready(function () {
            $("#placeOrder").click(function (event) {

                <security:authorize access="isAuthenticated()">
                $('#main').load("orders/placeOrder/<security:authentication property="principal.username"/>");
                </security:authorize>
                alert("Order Completed Successfully !");
            });

            <%--$("#placeOrder").click(function (event) {--%>
            <%--// alert(event.target.id);--%>
            <%--// alert($("#username").text());--%>
            <%--$.ajax({--%>
            <%--url: "orders/placeOrder",--%>
            <%--type: 'POST',--%>
            <%--async: true,--%>
            <%--headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},--%>

            <%--data: {--%>
            <%--"orderId": ${order.orderId},--%>
            <%--},--%>
            <%--success: function (data) {--%>
            <%--alert("Order Completed Successfully !");--%>
            <%--&lt;%&ndash;$('#main').load("orders/cart/<security:authentication property="principal.username"/>");&ndash;%&gt;--%>

            <%--}--%>
            <%--});--%>
            <%--});--%>



            <%--$("#placeOrder").click(function (event) {--%>
            <%--// alert(event.target.id);--%>
            <%--// alert($("#username").text());--%>
            <%--$.ajax({--%>
            <%--url: "orders/placeOrder",--%>
            <%--type: 'POST',--%>
            <%--async: true,--%>
            <%--headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},--%>

            <%--data: {--%>
            <%--"orderId": ${order.orderId},--%>
            <%--},--%>
            <%--success: function (data) {--%>
            <%--alert("Order Completed Successfully !");--%>
            <%--&lt;%&ndash;$('#main').load("orders/cart/<security:authentication property="principal.username"/>");&ndash;%&gt;--%>

            <%--}--%>
            <%--});--%>
            <%--});--%>

        });
    </script>
    <style>
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
        }

        .panel {
            padding: 0 18px;
            background-color: white;
            max-height: 0;
            transition: max-height 0.2s ease-out;
        }

        #orders {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #orders td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #orders tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #orders tr:hover {
            background-color: #ddd;
        }

        #orders th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #1a0600;
            color: white;
        }
    </style>


</head>
<body>

<c:if test="${empty order}">
    <h1>Your Card Is Empty Please Select Some Products First</h1>
</c:if>

<c:if test="${not empty order}">

    <h1>This is your Current cart please review well before completing your order # ${order.orderId}</h1>

    <div class="panel">
        <table id="orders">
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Amount</th>
                <th>Single Unite Price</th>
            </tr>
            <c:forEach items="${order.cartItems}" var="cartItem" varStatus="stat">
                <tr>
                    <td>${cartItem.product.id}</td>
                    <td>${cartItem.product.name}</td>
                    <td>${cartItem.amount}</td>
                    <td>${cartItem.product.price}</td>
                </tr>
            </c:forEach>
        </table>

        </br>

        <P> Your Total price is ${order.totalPrice}</P>
        <button class="button" id="placeOrder"> Place Your Order !</button>
    </div>
</c:if>

</body>
</html>


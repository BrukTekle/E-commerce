<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <security:csrfMetaTags/>

    <title>Products</title>
    <script>

        $(document).ready(function () {


            $(".addToCard").click(function (event) {
                // alert(event.target.id);
                // alert($("#username").text());
                $.ajax({
                    url: "addProductToCard",
                    type: 'POST',
                    async: true,
                    headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
                    data: {
                        "productId": event.target.id,
                        "username": $("#username").text()
                    },
                    success: function (data) {
                        alert("Product was added to the cart successfully");
                        $('#main').load("products");

                    }
                });
            });

        });
    </script>

    <style>
        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            max-width: 300px;
            margin: auto;
            text-align: center;
            font-family: arial;
        }

        .price {
            color: grey;
            font-size: 22px;
        }

        .card button {
            border: none;
            outline: 0;
            padding: 12px;
            color: white;
            background-color: #000;
            text-align: center;
            cursor: pointer;
            width: 100%;
            font-size: 18px;
        }

        .card button:hover {
            opacity: 0.7;
        }


    </style>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
            <p>All the available products in our store</p>
        </div>
    </div>
</section>
<table>
    <c:forEach items="${productList}" var="product" varStatus="stat">
        <fmt:parseNumber var="i" type="number" value="${stat.index}"></fmt:parseNumber>
        <c:if test="${i%5==0}">

            <section class="container">
            <tr class="row">

        </c:if>
        <td>
            <div class="card"><!--  P1234.png-->
                <img src="${pageContext.request.contextPath}/resource/images/${product.name}.png" alt="Denim Jeans"
                     style="width:25%"/>
                <h1>${product.name}</h1>
                <p class="price">${product.price}</p>
                <p>${product.description}</p>
                <p>Stock : ${product.amount}</p>
                <p>
                    <button id="${product.id}" class="addToCard">Add to Cart</button>
                </p>
            </div>
        </td>
        <c:if test="${i%5+1==0}">

            </tr>
            </section>

        </c:if>


    </c:forEach>


</table>


</div>


</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        .accordion {
            background-color: #eee;
            color: #444;
            cursor: pointer;
            padding: 18px;
            width: 100%;
            border: none;
            text-align: left;
            outline: none;
            font-size: 15px;
            transition: 0.4s;
        }

        .active, .accordion:hover {
            background-color: #ccc;
        }

        .accordion:after {
            content: '\002B';
            color: #777;
            font-weight: bold;
            float: right;
            margin-left: 5px;
        }

        .active:after {
            content: "\2212";
        }

        .panel {
            padding: 0 18px;
            background-color: white;
            max-height: 0;
            overflow: hidden;
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

        #orders tr:nth-child(even){background-color: #f2f2f2;}

        #orders tr:hover {background-color: #ddd;}

        #orders th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #1a0600;
            color: white;
        }
    </style>
</head>
<body >

</table>
<c:forEach items="${orderList}" var="order" varStatus="stat">
    <tr>
        <div class="accordion">
            <table>
                <tr>
                    <td> Order # : ${order.orderId}</td>
                    <td align="left"> Total price : ${order.totalPrice}</td>
                </tr>
            </table>

        </div>

        <div class="panel">
            <table id="orders">
                <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Amount</th>
                <th>Single Unite Price</th>
                </tr>
                <c:forEach items="${order.cartItems}" var="cartItem" varStatus="stat2">
                    <tr>
                        <td>${cartItem.product.id}</td>
                        <td>${cartItem.product.name}</td>
                        <td>${cartItem.amount}</td>
                        <td>${cartItem.product.price}</td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </tr>

    </table>

</c:forEach>
<script>
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function () {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight) {
                panel.style.maxHeight = null;
            } else {
                panel.style.maxHeight = panel.scrollHeight + "px";
            }
        });
    }
</script>

</body>
</html>


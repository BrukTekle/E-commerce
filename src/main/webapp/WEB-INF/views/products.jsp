<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Products</title>
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
	<div>

		<form:select path="catagory">
			<form:option value=" NONE">--selectcatagory--</form:option>
			<form:option value=${catagory.id}"> "${catagory}"></form:option>

		</form:select>

		<%-- <%-- 	<form:select path="catagory"  items="${catagory}" > </form:select
	<form:select id="catagory" path="catagory.id" items="${catagory}"
			itemValue="id" itemLabel="name" />
 --%>

		<ul>
			<li><a href ="  ">product</a>
			<li>
		</ul>

	</div>












	</div>

	<section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<img
							src="<c:url value="/resource/images/${product.id}.png"></c:url>"
							alt="image" style="width: 100%" />
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>


							<p>
								<a
									href=" <spring:url value="/products/product?id=${product.productId}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Details
								</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>

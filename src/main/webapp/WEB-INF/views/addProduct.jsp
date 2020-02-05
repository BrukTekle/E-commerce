<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
<section>
	<div class="container">
		<h1>Add New products</h1>
		<p>The admin will use this page to add new products</p>
		
		<form:form modelAttribute="newProduct" action="addProduct" method="post" enctype="multipart/form-data"> 
 			<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
 			<fieldset>
				<legend>Add new product</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>

					<label for="pname"><spring:message code="addProduct.form.name.label"/></label>
					<div>
						<form:input id="pname" path="name" type="text"/>
						<%-- <form:errors path="name" cssClass="text-danger"/> --%>
					</div>
					
					<label for="unitPrice"><spring:message code="addProduct.form.unitPrice.label"/></label>

						<div >
							<form:input id="unitPrice" path="price" />
							<%-- <form:errors path="price" /> --%>
	
					</div>
	

					<label for="description"><spring:message code="addProduct.form.description.label"/></label>
					<div>
						<form:textarea id="description" path="description" rows = "2"/>
					</div>


					<label class="control-label col-lg-2" for="manufacturer"><spring:message code="addProduct.form.manufacturer.label"/></label>

						<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>

			<%-- 		<label for="category"><spring:message code="addProduct.form.category.label"/></label>

						<form:input id="category" path="catagory" /> --%>

				  <div class="form-group">
					<form:select path="catagory.id">
   						<form:option value="0" label="--- Select ---"/>
   						<form:options items="${categoryList}" itemLabel="name" itemValue="id" />
					</form:select>
				</div>   
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="unitsInStock"><spring:message code="addProduct.form.unitsInStock.label"/></label>

						<form:input id="unitsInStock" path="amount" type="text" class="form:input-large"/>

				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="productCondition"><spring:message code="addProduct.form.productCondition.label"/></label>

						<form:radiobutton path="productCondition" value="New" />New
						<form:radiobutton path="productCondition" value="Old" />Old
						<form:radiobutton path="productCondition" value="Refurbished"/>Refurbished
	
				</div>
				
				 <div class="form-group">
					<label class="control-label col-lg-2" for="productImage"><spring:message code="addProduct.form.productImage.label"/></label>

						<form:input id="productImage" path="productImage" type="file" />
						
				</div> 

				<div class="form-group">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>

				</div>
			</fieldset>
		</form:form>
	</div>

</section>
</body>
</html>

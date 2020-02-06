<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
 	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/cart.js"/>"></script>
</head>
<body>

<section>
	<div class="container">
		<h1>Add New products</h1>
		
		<form:form modelAttribute="newProduct" action="addProduct" method="post" enctype="multipart/form-data"> 
 			<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
 			<fieldset>
				<legend>Add new product</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>
<div>
					<label for="pname"><spring:message code="addProduct.form.name.label"/></label>
					
						<form:input id="pname" path="name" type="text"/>
						<form:errors path="name" cssStyle="color : red;"/> 
					
					</div>
					<div>
					<label for="unitPrice"><spring:message code="addProduct.form.unitPrice.label"/></label>
						
							<form:input id="unitPrice" path="price" />
							<form:errors path="price" cssStyle="color : red;"/> 
	</div>
					
	<div>

					<label for="description"><spring:message code="addProduct.form.description.label"/></label>
					
						<form:textarea id="description" path="description" rows = "2"/>
						<form:errors path="description" cssStyle="color : red;"/> 
					</div>

<div>
					<label for="manufacturer"><spring:message code="addProduct.form.manufacturer.label"/></label>

						<form:input id="manufacturer" path="manufacturer" type="text" />

</div>
				  <div >
				  <label ><spring:message code="addProduct.form.catagory.label"/></label>
					<form:select path="catagory.id">
   						<form:option value="0" label="--- Select ---"/>
   						<form:options items="${categoryList}" itemLabel="name" itemValue="id" />
					</form:select>
				</div>   
				
				<div class="form-group">
					<label for="unitsInStock"><spring:message code="addProduct.form.unitsInStock.label"/></label>

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
	
	
	<form id="categoryForm" method="post">
			<!-- <input type="hidden" name="id" value="0"> -->
          
          <p>
            <label for="name"> Name    : </label>
             <input type="text" name="name" id="name" value="" />
        </p>
         <p>
            <label for="description"> Description: </label>
            <input id="description" name="description" type="text"/>
        </p>
 
            <input type="button" value="Add Category" onclick="categorySubmit();return false;"> 
     
    </form>

</section>

<div id="result" >   	
    	    <p id="success" > 

    		</p> 
    		<p id="errors" > 
    		</p>
   </div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <%-- <link rel="stylesheet"	href="//netdna.bo<!--  -->otstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"> --%>
<title>Sign Up</title>
</head>
<body>
	<section>

			<div class="container">
				<h1>Sign Up Here</h1>
				<!-- <p>Add a new one<p> -->
			</div>

	</section>
	<section class="container">
		<form:form  modelAttribute="newMember" class="form-horizontal"  >
			<fieldset>
				<legend>User Information</legend>

				<form:errors path="*" cssStyle="color: red;" element="div"/>
				<%-- <div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="memberNumber"> Member Number</label>
					<div class="col-lg-10">
						<form:input id="memberNumber" path="memberNumber" type="text" class="form:input-large"/>
						<form:errors path="memberNumber" cssClass="text-danger"/>
					</div>
				</div> --%>

				<div class="form-group">
					<label class="control-label col-lg-2" for="firstName">First Name</label>
					<div class="col-lg-10">
						<form:input id="firstName" path="firstName" type="text" class="form:input-large"/>
						<form:errors path="firstName" cssStyle="color: red;"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="lastName">Last Name</label>
					<div class="col-lg-10">
						<form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
						<form:errors path="lastName" cssStyle="color: red;"/>
					</div>
				</div>
				<%-- <div class="form-group">
					<label class="control-label col-lg-2" for="dateOfBirth">Date of Birth</label>
					<div class="col-lg-10">
						<form:input id="dateOfBirth" path="dateOfBirth" type="text" class="form:input-large"/>
						<form:errors path="dateOfBirth" cssStyle="color: red;"/>
					</div>
				</div>  --%>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="phone">Phone</label>
					<div class="col-lg-10">
						<form:input id="phone" path="phone" type="text" class="form:input-large"/>
						<form:errors path="phone" cssStyle="color: red;"/>
					</div>
				</div> 
				<div class="form-group">
					<h3> Address</h3>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="street">Street</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="street" path="address.street" type="text" class="form:input-large"/>
							<form:errors path="address.street" cssStyle="color: red;"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="city">City</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="city" path="address.city" type="text" class="form:input-large"/>
							<form:errors path="address.city" cssStyle="color: red;"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="zipCode">ZipCode</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="zipCode" path="address.zipCode" type="text" class="form:input-large"/>
							<form:errors path="address.zipCode" cssStyle="color: red;"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="country">Country</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="country" path="address.country" type="text" class="form:input-large"/>
							<form:errors path="address.country" cssStyle="color: red;"/>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<h3> User Credentials</h3>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="userName">User Name</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="username" path="userCredentials.username" type="text" class="form:input-large"/>
							<form:errors path="userCredentials.username" cssStyle="color: red;"/>
						</div>
					</div>
				</div>

	
				<div class="form-group">
					<label class="control-label col-lg-2" for="password">Password</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:password id="password" path="userCredentials.password"  class="form:input-large"/>
							<form:errors path="userCredentials.password" cssStyle="color: red;"/>
						</div>
					</div>
				</div>

	
				<div class="form-group">
					<label class="control-label col-lg-2" for="verifyPassword">Verify Password</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:password  path="userCredentials.verifyPassword"  class="form:input-large"/>
							<form:errors path="userCredentials.verifyPassword" cssStyle="color: red;"/>
						</div>
					</div>
				</div>
				
					<div class="form-group" style="visibility:hidden">
					<label class="control-label col-lg-2" for="authority">Role</label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input  path="userCredentials.authority[0].authority" type="text" value="ROLE_USER" class="form:input-large"/>
							<form:errors path="userCredentials.authority[0].authority" cssStyle="color: red;"/>
						</div>
					</div>
				</div>
 
						<form:hidden path="userCredentials.enabled" value="TRUE"  />

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>

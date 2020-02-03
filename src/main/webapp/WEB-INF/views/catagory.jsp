<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div>
	<form:select  path="catagoryList">
	<label for="catagory"><spring:message
					code="" text=""></spring:message></label>
	 <option value="  ">selectCatagory</option>
		<form:option  value="${catagoty}"/> </option>
		
		
		
		
		
		</form:select>

	</div>
		
		
		
			









</body>
</html>
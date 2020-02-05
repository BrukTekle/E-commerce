// jQuery example

$(document).ready(function() {
	
	var cartId;
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
	
	addToCart = function(productId){
		
			$.ajax({
		 		url: contextRoot + '/rest/cart/add/' + productId,
		 		type: 'PUT',
				dataType: "json",
				success: function(response){
	 		 		alert("Product Successfully added to the Cart!");

				},
				error: function(){						
					alert('Error while request..');
				}
			});
		}

	   removeFromCart = function(productId) {
			$.ajax({
				url: contextRoot + '/rest/cart/remove/'+ productId,
		 		type: 'PUT',
				dataType: "json",
			 	 success: function (response) {
		 		 		location.reload(true);
					},
					error: function(){						
						alert('Error while request..');
			 	 } 
		   });
	   }
	   
	   //add catagory
	   categorySubmit = function (){
		   alert('my message');
		   	var dataToSend = JSON.stringify(serializeObject($('#categoryForm')));	   	
		   	 $.ajax({
				type: 'POST',
				url: contextRoot + '/addCatagory',
				dataType: "json",         
		 		data:dataToSend,
		 		contentType: 'application/json',   
				success: function(){
					$('#errors').html("");
		 			$("#result").append( '<H3 align="center"> OKAY!! <H3>');                
			 	    $('#result').show();
				},
		 
				error: function(errorObject ){	

					if (errorObject.responseJSON.errorType == "ValidationError") {
			 			$('#success').html("");
			 			$('#errors').html("");
			 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
			  			    $("#result").append( '<p>');
			  	
			  			    var errorList = errorObject.responseJSON.errors;
			 	 	        $.each(errorList,  function(i,error) {			   
			 		    		$("#errors").append( error.message + '<br>');
					    	});
			 	 	        $("#errors").append( '</p>');
			 	 	        $('#result').show();
					}
					else {
						alert(errorObject.responseJSON.errors(0));   
					}
		 		}
			});
		}
	   
	   
	 // Click on Product [row]  in cart
       $("#cart_table").find("tr").click(function() {  
	       	var productId=  $(this).find("td:first").html();
				showProduct(productId);
	          });

	   // Get product object from Server...
	   function showProduct(productId) {
			$.ajax({
				url: contextRoot + '/rest/cart/showProduct',
		 		type: 'GET',
		 		async:false,
				dataType: "json",
				data:'id=' + productId,
			 	 success: function (response) {
		 		 		 displayProduct(response);
					},
					error: function(){						
 			 	 } 
		   });
	   }
	   
	   function displayProduct(product) {
	 
			$('#result').html("");
			$("#result").append('<h4 align="right"> <a href="#" onclick="toggle_visibility(\'result\');"><b>CLOSE</b> </a> </h4>');
			$("#result").append( '<H3 align="center"> Product Information <H3>');                
			$("#result").append( '<H4 align="center">' + product.productId + '<H4>');                
			$("#result").append( '<H4 align="center">' + product.name + '<H4>');               	 
			$("#result").append( '<H4 align="center">' + product.unitPrice + '<H4>');                
			$("#result").append( '<H4 align="center">' + product.manufacturer + '<H4>');                
			$("#result").append( '<H4 align="center">' + product.category + '<H4>');                
			$("#result").attr("style", "display: block")
	 		} 
	 
	   toggle_visibility = function(id) {
	       var e = document.getElementById(id);
	       if(e.style.display == 'block')
	          e.style.display = 'none';
	       else
	          e.style.display = 'block';
	    }	   
//------------------TO BE Implemented-------------------------------------	   
	   
/*		 getCartId = function( ) {
				$.ajax({
					url: '/webstore08/rest/cart/getId/',
					type: 'GET',
					success : function(id) {
					 		 		 cartId = id;
					 	 		}
			});
		 }


 
		 refreshCart = function() {
		 		getCartId();
				$.ajax({
					url: '/webstore8/rest/cart/'+ cartId,
					type: 'GET',
					dataType: "json",
					success : function(cartData) {
  					 }
			});
		 }

*/
	   
});

 
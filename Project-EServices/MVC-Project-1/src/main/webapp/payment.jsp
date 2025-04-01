<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Page</title>
<style>
.bttnStyle {
	background-color: lightblue;
	border-radius: 0.5rem;
	border: 1px solid transparent;
}
</style>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
	var xhttp = new XMLHttpRequest();
	var RazorpayOrderId;

	function CreateOrderID() {
		alert("1");
		var number = document.getElementById("amount").value;
		xhttp.open("GET",
				"http://localhost:8080/MVC-Project-1/OrderCreation?amount="
						+ number, false);
		alert("2");
		xhttp.send();
		RazorpayOrderId = xhttp.responseText;
		OpenCheckOut();
	}

	function OpenCheckOut() {
		alert("3");
		var number = document.getElementById("amount").value;
		alert(number);

		var options = {
			"key" : "rzp_test_KGwT3XcJybhKgu",
			"amount" : number,
			"currency" : "INR",
			"name" : "Tops",
			"description" : "Test",
			"order_id" : RazorpayOrderId,
			"callback_url" : "http://localhost:8080/MVC-Project-1/OrderCreation",
			"prefill" : {
				"name" : "rahul sanghavi",
				"email" : "rahulsanghavi.tops@gmail.com",
				"contact" : "9016545414"
			},
			"notes" : {
				"address" : "s.nagar"
			},
			"theme" : {
				"color" : "#3399cc"
			}
		};

		var rzp1 = new Razorpay(options);
		rzp1.on('payment.failed', function(response) {
			alert(response.error.code);
			alert(response.error.description);
			alert(response.error.source);
			alert(response.error.step);
			alert(response.error.reason);
			alert(response.error.metadata.order_id);
			alert(response.error.metadata.payment_id);
		});
		rzp1.open();
	}
</script>
</head>
<body>
	<%
	if (session.getAttribute("firstname") == null || session.getAttribute("lastname") == null
			|| session.getAttribute("customerid") == null) {
		response.sendRedirect("index.jsp");
		return; // Ensures no further code execution after redirect
	}

	// Set headers after the redirect check
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	%>
	<div id="order_id"></div>
	<center>
		<%
		String price = request.getParameter("price");
		%>
		<input type="hidden" id="amount" value="<%=price%>">
		<button id="payButton" onclick="CreateOrderID()" class="bttnStyle">Pay
			Now</button>
	</center>
</body>
</html>

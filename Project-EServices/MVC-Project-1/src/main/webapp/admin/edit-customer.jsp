<%@page import="com.model.CustomerModel"%>
<%@page import="com.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<%
	// Check Admin Login Session
	if (session.getAttribute("username") == null || session.getAttribute("password") == null) {
		response.sendRedirect("admin-index.jsp");
		return; // Ensures no further code execution after redirect
	}

	// Prevent Cache for Sensitive Data
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	int customerId = Integer.parseInt(request.getParameter("id"));
	CustomerDAO dao = new CustomerDAO();
	CustomerModel customer = dao.getCustomerById(customerId);
	%>
	<div class="container-xxl position-relative bg-white d-flex p-0">
		<%@ include file="admin-sidebar.jsp"%>
		<div class="content">
			<%@ include file="admin-header.jsp"%>
			<!-- Main Content Area -->
			<div class="main-content">
				<h1 class="text-center">Edit Customer Details</h1>
				<div class="card p-4">
					<form action="../CustomerController" method="post"
						onsubmit="return validateForm()">
						<input type="hidden" name="action" value="update"> <input
							type="hidden" name="customerid"
							value="<%=customer.getCustomerid()%>">

						<!-- First Name -->
						<div class="mb-3">
							<label class="form-label">First Name:</label> <input type="text"
								id="firstname" name="firstname"
								value="<%=customer.getFirstname()%>" class="form-control"
								pattern="[A-Za-z\s]+"
								title="Only letters and spaces are allowed" required>
						</div>

						<!-- Last Name -->
						<div class="mb-3">
							<label class="form-label">Last Name:</label> <input type="text"
								id="lastname" name="lastname"
								value="<%=customer.getLastname()%>" class="form-control"
								pattern="[A-Za-z\s]+"
								title="Only letters and spaces are allowed" required>
						</div>

						<!-- Phone Number -->
						<div class="mb-3">
							<label class="form-label">Phone Number:</label> <input
								type="text" id="number" name="number"
								value="<%=customer.getNumber()%>" class="form-control"
								pattern="\d{10}" title="Phone Number must be 10 digits" required>
						</div>

						<!-- Email -->
						<div class="mb-3">
							<label class="form-label">Email:</label> <input type="email"
								id="email" name="email" value="<%=customer.getEmail()%>"
								class="form-control" required>
						</div>

						<!-- Address -->
						<div class="mb-3">
							<label class="form-label">Address:</label> <input type="text"
								id="address" name="address" value="<%=customer.getAddress()%>"
								class="form-control" required>
						</div>

						<!-- City -->
						<div class="mb-3">
							<label class="form-label">City:</label> <input type="text"
								id="city" name="city" value="<%=customer.getCity()%>"
								class="form-control" pattern="[A-Za-z\s]+"
								title="Only letters and spaces are allowed" required>
						</div>

						<!-- State -->
						<div class="mb-3">
							<label class="form-label">State:</label> <input type="text"
								id="state" name="state" value="<%=customer.getState()%>"
								class="form-control" pattern="[A-Za-z\s]+"
								title="Only letters and spaces are allowed" required>
						</div>

						<!-- Pincode -->
						<div class="mb-3">
							<label class="form-label">Pincode:</label> <input type="text"
								id="pincode" name="pincode" value="<%=customer.getPincode()%>"
								class="form-control" pattern="\d{6}"
								title="Pincode must be 6 digits" required>
						</div>

						<button type="submit" class="btn btn-primary">Update
							Customer</button>
					</form>
				</div>
			</div>
			<%@ include file="admin-footer.jsp"%>
		</div>
	</div>

	<!-- JavaScript Libraries -->
	<script>
		// Real-time validation for text fields
		document.getElementById("firstname").addEventListener("input",
				function() {
					this.value = this.value.replace(/[^a-zA-Z\s]/g, '');
				});

		document.getElementById("lastname").addEventListener("input",
				function() {
					this.value = this.value.replace(/[^a-zA-Z\s]/g, '');
				});

		document.getElementById("city").addEventListener("input", function() {
			this.value = this.value.replace(/[^a-zA-Z\s]/g, '');
		});

		document.getElementById("state").addEventListener("input", function() {
			this.value = this.value.replace(/[^a-zA-Z\s]/g, '');
		});

		function validateForm() {
			let firstname = document.getElementById("firstname").value.trim();
			let lastname = document.getElementById("lastname").value.trim();
			let number = document.getElementById("number").value.trim();
			let email = document.getElementById("email").value.trim();
			let address = document.getElementById("address").value.trim();
			let city = document.getElementById("city").value.trim();
			let state = document.getElementById("state").value.trim();
			let pincode = document.getElementById("pincode").value.trim();

			// Validation rules
			if (!/^[A-Za-z\s]+$/.test(firstname)) {
				alert("First Name must contain only letters and spaces.");
				return false;
			}
			if (!/^[A-Za-z\s]+$/.test(lastname)) {
				alert("Last Name must contain only letters and spaces.");
				return false;
			}
			if (!/^\d{10}$/.test(number)) {
				alert("Phone Number must be 10 digits.");
				return false;
			}
			if (!/\S+@\S+\.\S+/.test(email)) {
				alert("Invalid Email format.");
				return false;
			}
			if (address === "") {
				alert("Address is required.");
				return false;
			}
			if (!/^[A-Za-z\s]+$/.test(city)) {
				alert("City must contain only letters and spaces.");
				return false;
			}
			if (!/^[A-Za-z\s]+$/.test(state)) {
				alert("State must contain only letters and spaces.");
				return false;
			}
			if (!/^\d{6}$/.test(pincode)) {
				alert("Pincode must be 6 digits.");
				return false;
			}

			return true; // If all validations pass
		}
	</script>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="lib/chart/chart.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/waypoints/waypoints.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="lib/tempusdominus/js/moment.min.js"></script>
	<script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>
	<script src="../js/jquery-1.12.1.min.js"></script>
	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>
</html>
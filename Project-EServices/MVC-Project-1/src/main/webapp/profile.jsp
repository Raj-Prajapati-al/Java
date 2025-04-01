<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>E-Service</title>
<link rel="icon" href="img/favicon.png">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- animate CSS -->
<link rel="stylesheet" href="css/animate.css">
<!-- owl carousel CSS -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/all.css">
<!-- flaticon CSS -->
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/themify-icons.css">
<!-- font awesome CSS -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- swiper CSS -->
<link rel="stylesheet" href="css/slick.css">
<!-- style CSS -->
<link rel="stylesheet" href="css/style.css">
<title>Edit Profile</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f9;
}

.container {
	margin: auto;
	background: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

h1 {
	text-align: center;
	color: #333;
}

.form-group {
	margin: 15px 0;
}

label {
	font-weight: bold;
	display: block;
	margin-bottom: 5px;
}

input {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.submit-button {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 4px;
	text-align: center;
	font-size: 16px;
	cursor: pointer;
}

.submit-button:hover {
	background-color: #0056b3;
}
</style>
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
	<%@ include file="header.jsp"%>
	<!-- feature_part start-->
	<section class="feature_part padding_top">
		<div class="container">
			<c:if test="${not empty successMsg}">
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					<strong>Success!</strong> ${successMsg}
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
					<%
					session.removeAttribute("successMsg");
					%>
				</div>
			</c:if>
			<c:if test="${not empty error}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					<strong>Error!</strong> ${error}
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
					<%
					session.removeAttribute("errorMsg");
					%>
				</div>
			</c:if>
			<h1>Edit Profile</h1>
			<form action="CustomerController" method="post"
				onsubmit="return validateForm()">
				<div class="form-group">
					<label>First Name:</label> <input type="text" id="firstname"
						name="firstname"
						value="${model.firstname != null ? model.firstname : ''}"
						class="form-control" pattern="[A-Za-z\s]+"
						title="Only letters and spaces are allowed." required>
				</div>
				<div class="form-group">
					<label>Last Name:</label> <input type="text" id="lastname"
						name="lastname" value="${model.lastname}" class="form-control"
						pattern="[A-Za-z\s]+" title="Only letters and spaces are allowed."
						required>
				</div>
				<div class="form-group">
					<label>Phone Number:</label> <input type="text" id="number"
						name="number" value="${model.number}" class="form-control"
						pattern="\d{10}" title="Phone Number must be 10 digits." required>
				</div>
				<div class="form-group">
					<label>Email:</label> <input type="email" id="email" name="email"
						value="${model.email}" class="form-control" required>
				</div>
				<div class="form-group">
					<label>Address:</label> <input type="text" id="address"
						name="address" value="${model.address}" class="form-control"
						required>
				</div>
				<div class="form-group">
					<label>City:</label> <input type="text" id="city" name="city"
						value="${model.city}" class="form-control" pattern="[A-Za-z\s]+"
						title="Only letters and spaces are allowed." required>
				</div>
				<div class="form-group">
					<label>State:</label> <input type="text" id="state" name="state"
						value="${model.state}" class="form-control" pattern="[A-Za-z\s]+"
						title="Only letters and spaces are allowed." required>
				</div>
				<div class="form-group">
					<label>Pincode:</label> <input type="text" id="pincode"
						name="pincode"
						value="${model.pincode != null ? model.pincode : ''}"
						class="form-control" pattern="\d{6}"
						title="Pincode must be 6 digits." required>
				</div>
				<input type="hidden" name="modelid" value="${model.customerid}">
				<input type="hidden" name="action" value="EditCustomer">
				<button type="submit" class="submit-button">Update Profile</button>
			</form>
		</div>
	</section>
	<%@ include file="footer.jsp"%>
	<script>
        // Real-time validation for text fields
        function allowOnlyLetters(inputId) {
            document.getElementById(inputId).addEventListener("input", function() {
                this.value = this.value.replace(/[^a-zA-Z\s]/g, '');
            });
        }
        allowOnlyLetters("firstname");
        allowOnlyLetters("lastname");
        allowOnlyLetters("city");
        allowOnlyLetters("state");

        function validateForm() {
            const fields = ["firstname", "lastname", "number", "email", "address", "city", "state", "pincode"];
            for (let field of fields) {
                let value = document.getElementById(field).value.trim();
                if (!value) {
                    alert(`${field.charAt(0).toUpperCase() + field.slice(1)} is required.`);
                    return false;
                }
            }

            const number = document.getElementById("number").value.trim();
            const pincode = document.getElementById("pincode").value.trim();

            if (!/^\d{10}$/.test(number)) {
                alert("Phone Number must be 10 digits.");
                return false;
            }
            if (!/^\d{6}$/.test(pincode)) {
                alert("Pincode must be 6 digits.");
                return false;
            }

            return true;
        }
    </script>
	<!-- jquery plugins here-->
	<script src="js/jquery-1.12.1.min.js"></script>
	<!-- popper js -->
	<script src="js/popper.min.js"></script>
	<!-- bootstrap js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- easing js -->
	<script src="js/jquery.magnific-popup.js"></script>
	<!-- swiper js -->
	<script src="js/swiper.min.js"></script>
	<!-- swiper js -->
	<script src="js/masonry.pkgd.js"></script>
	<!-- particles js -->
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<!-- slick js -->
	<script src="js/slick.min.js"></script>
	<script src="js/jquery.counterup.min.js"></script>
	<script src="js/waypoints.min.js"></script>
	<script src="js/contact.js"></script>
	<script src="js/jquery.ajaxchimp.min.js"></script>
	<script src="js/jquery.form.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/mail-script.js"></script>
	<!-- custom js -->
	<script src="js/custom.js"></script>
</body>
</html>
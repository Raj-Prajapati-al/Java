<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Delete Customer</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

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

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">

<!-- Footer Adjustment -->
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<%
	// Check Admin Login Session
	if (session.getAttribute("username") == null || session.getAttribute("password") == null) {
		response.sendRedirect("admin-index.jsp");
		return; // Prevents further execution after redirect
	}

	// Prevent Cache for Sensitive Data
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	%>

	<div class="container-xxl position-relative bg-white d-flex p-0">
		<%@ include file="admin-sidebar.jsp"%>
		<div class="content">
			<%@ include file="admin-header.jsp"%>

			<!-- Main Content Area -->
			<div class="main-content">
				<h1 class="text-center">Delete Customer</h1>

				<!-- Fetch Customer ID from Query Parameter -->
				<%
				int customerId = Integer.parseInt(request.getParameter("id"));
				%>

				<div class="card p-4 text-center">
					<p>
						Are you sure you want to delete customer with ID <strong><%=customerId%></strong>?
					</p>
					<form action="../CustomerController" method="post">
						<input type="hidden" name="action" value="deletecustomer">
						<input type="hidden" name="customerid" value="<%=customerId%>">
						<button type="submit" class="btn btn-danger">Yes, Delete</button>
						<a href="view-customers.jsp" class="btn btn-secondary">Cancel</a>
					</form>
				</div>
			</div>

			<%@ include file="admin-footer.jsp"%>
		</div>

		<!-- Back to Top -->
		<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top">
			<i class="bi bi-arrow-up"></i>
		</a>
	</div>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>
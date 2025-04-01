<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Delete SubService</title>
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

<!-- Footer Adjustment   -->
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
	<%
	if (session.getAttribute("username") == null || session.getAttribute("password") == null) {
		response.sendRedirect("admin-index.jsp");
		return; // Ensures no further code execution after redirect
	}

	// Set headers after the redirect check
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
				<!-- Add page-specific content here -->
				<h1 class="text-center">Delete SubService</h1>
				<%
				int subServiceId = Integer.parseInt(request.getParameter("id"));
				%>
				<div class="card p-4 text-center">
					<p>
						Are you sure you want to delete subservice with ID <strong><%=subServiceId%></strong>?
					</p>
					<form action="../AdminController" method="post">
						<input type="hidden" name="action" value="deletesubservice">
						<input type="hidden" name="subserviceid" value="<%=subServiceId%>">
						<button type="submit" class="btn btn-danger">Yes, Delete</button>
						<a href="viewsubservice.jsp" class="btn btn-secondary">Cancel</a>
					</form>
				</div>
			</div>


			<%@ include file="admin-footer.jsp"%>
		</div>
	</div>
	<!-- JavaScript Libraries -->
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

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>
</html>
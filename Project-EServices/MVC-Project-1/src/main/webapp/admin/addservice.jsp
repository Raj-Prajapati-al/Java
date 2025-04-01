<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>DASHMIN - Bootstrap Admin Template</title>
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

<!-- Footer Adjustment   -->
<link href="css/styles.css" rel="stylesheet">

<style type="text/css">
.content {
	margin-top: 20px; /* Creates a gap below the header */
}

.main-content {
	padding-top: 20px; /* Additional padding for the main content area */
}
</style>
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
			<div class="main-content w-100">
				<!-- Form Start -->
				<div class="container-fluid">
					<div class="row justify-content-center">
						<div class="col-sm-12 col-xl-6">
							<div class="bg-light rounded h-100 p-4 text-center">
								<h6 class="mb-4">Add Service</h6>
								<c:if test="${not empty errorMsg}">
									<div class="alert alert-danger alert-dismissible fade show"
										role="alert">
										<strong>Error! </strong>${errorMsg}
										<button type="button" class="close" data-bs-dismiss="alert"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</c:if>
								<form method="post" action="../AdminController"
									enctype="multipart/form-data">
									<div class="mb-3 text-start">
										<label for="servicename" class="form-label">Service
											Name</label> <input type="text" name="servicename"
											class="form-control" id="servicename"
											aria-describedby="emailHelp" required>
									</div>
									<div class="mb-3 text-start">
										<label for="image" class="form-label">Image</label> <input
											type="file" name="image" class="form-control" id="image"
											required>
									</div>
									<button type="submit" name="action" value="addservice"
										class="btn btn-primary">Submit</button>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- Form End -->
			</div>

			<%
			// Clear session attributes 
			if (session.getAttribute("errorMsg") != null) {
				session.removeAttribute("errorMsg");
			}
			%>
			<%@ include file="admin-footer.jsp"%>
		</div>
		<!-- Back to Top -->
		<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
			class="bi bi-arrow-up"></i></a>
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
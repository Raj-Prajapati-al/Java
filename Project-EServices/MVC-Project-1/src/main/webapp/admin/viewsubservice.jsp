<%@page import="com.model.AddSubServiceModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>View Subservices</title>
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
				<h1 class="text-center">View Subservices</h1>
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
				<c:if test="${not empty errorMsg}">
					<div class="alert alert-danger alert-dismissible fade show"
						role="alert">
						<strong>Error!</strong> ${errorMsg}
						<button type="button" class="btn-close" data-bs-dismiss="alert"
							aria-label="Close"></button>
						<%
						session.removeAttribute("errorMsg");
						%>
					</div>
				</c:if>
				<div class="table-responsive mt-4">
					<table
						class="table table-bordered table-striped table-hover align-middle text-center w-100">
						<thead class="table-dark">
							<tr>
								<th style="width: 10%;">SubService ID</th>
								<th style="width: 10%;">Service ID</th>
								<th style="width: 25%;">SubService Name</th>
								<th style="width: 25%;">Feature</th>
								<th style="width: 15%;">Price</th>
								<th style="width: 15%;">Actions</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<AddSubServiceModel> subServiceList = (List<AddSubServiceModel>) session.getAttribute("subServiceList");
							for (AddSubServiceModel subService : subServiceList) {
							%>
							<tr>
								<td><span class="badge bg-primary"><%=subService.getSubserviceid()%></span>
								</td>
								<td><span class="badge bg-secondary"><%=subService.getServiceid()%></span>
								</td>
								<td><%=subService.getSubservicename()%></td>
								<td>
									<div class="text-truncate" style="max-width: 200px;">
										<%=subService.getFeature()%>
									</div>
								</td>
								<td><span class="text-success fw-bold">₹<%=subService.getPrice()%></span>
								</td>
								<td><a
									href="editsubservice.jsp?id=<%=subService.getSubserviceid()%>"
									class="btn btn-sm btn-warning"> <i
										class="bi bi-pencil-square"></i> Edit
								</a> <a
									href="deletesubservice.jsp?id=<%=subService.getSubserviceid()%>"
									class="btn btn-sm btn-danger"> <i class="bi bi-trash-fill"></i>
										Delete
								</a></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
			</div>


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
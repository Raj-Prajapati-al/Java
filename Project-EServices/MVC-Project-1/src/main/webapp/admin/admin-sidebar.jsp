<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Sidebar Start -->
	<div class="sidebar pe-4 pb-3">
		<nav class="navbar bg-light navbar-light">
			<a href="index.html" class="navbar-brand mx-4 mb-3">
				<h3 class="text-primary">
					<i class="fa fa-hashtag me-2"></i>Admin
				</h3>
			</a>
			<div class="d-flex align-items-center ms-4 mb-4">
				<div class="position-relative">
					<img class="rounded-circle" src="img/user.jpg" alt=""
						style="width: 40px; height: 40px;">
					<div
						class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
				</div>
				<div class="ms-3">
					<h6 class="mb-0">Raj</h6>
					<span>Admin</span>
				</div>
			</div>
			<div class="navbar-nav w-100">
				<a href="admin-dashboard.jsp" class="nav-item nav-link active"><i
					class="fa fa-tachometer-alt me-2"></i>Dashboard</a>
				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle"
						data-bs-toggle="dropdown"> <i class="fa fa-laptop me-2"></i>Services
					</a>
					<div class="dropdown-menu bg-transparent border-0">
						<a href="addservice.jsp" class="dropdown-item">Add Service</a>

						<!-- Form for View Service -->
						<form action="../AdminController" method="post"
							style="display: inline;">
							<input type="hidden" name="action" value="viewservice">
							<button type="submit" class="dropdown-item">View Service</button>
						</form>

						<a href="addsubservice.jsp" class="dropdown-item">Add Sub
							Service</a>

						<!-- Form for View Sub Service -->
						<form action="../AdminController" method="post"
							style="display: inline;">
							<input type="hidden" name="action" value="viewsubservice">
							<button type="submit" class="dropdown-item">View Sub
								Service</button>
						</form>
					</div>
				</div>
				<div class="nav-item dropdown">
					<a href="#" class="nav-link dropdown-toggle"
						data-bs-toggle="dropdown"> <i class="fa fa-laptop me-2"></i>Customers
					</a>
					<div class="dropdown-menu bg-transparent border-0">
						<!-- Form for View Service -->
						<form action="../CustomerController" method="post"
							style="display: inline;">
							<input type="hidden" name="action" value="viewcustomers">
							<button type="submit" class="dropdown-item">View
								Customers</button>
						</form>
					</div>
				</div>
			</div>
		</nav>
	</div>
	<!-- Sidebar End -->
</body>
</html>
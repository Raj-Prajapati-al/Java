<%@page import="com.dao.CustomerDAO"%>
<%@page import="com.model.CustomerModel"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.CustomerUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
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
	<!--================Home Banner Area =================-->
	<!-- breadcrumb start-->
	<section class="breadcrumb breadcrumb_bg">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8">
					<div class="breadcrumb_iner">
						<div class="breadcrumb_iner_item">
							<h2>Sub Services Checkout</h2>
							<p>
								Home <span>-</span> SubServices
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- breadcrumb start-->

	<!--================Checkout Area =================-->
	<section class="checkout_area padding_top">
		<div class="container">
			<%
			CustomerModel model = (CustomerModel) session.getAttribute("model");
			if (model != null) {
				int subserviceid = Integer.parseInt(request.getParameter("subserviceid"));
				String price = request.getParameter("price");
			%>
			<div class="billing_details">
				<div class="row">
					<div class="col-lg-8">
						<h3>Billing Details</h3>
						<form class="row contact_form" action="CustomerController"
							method="post">
							<div class="col-md-6 form-group p_star">
								<input type="text" class="form-control" id="first"
									name="firstname" placeholder="First Name"
									value="<%=model.getFirstname()%>">
							</div>
							<div class="col-md-6 form-group p_star">
								<input type="text" class="form-control" id="last"
									name="lastname" placeholder="Last Name"
									value="<%=model.getLastname()%>">
							</div>
							<div class="col-md-6 form-group p_star">
								<input type="text" class="form-control" id="number"
									name="mobileno" placeholder="Mobile Number"
									value="<%=model.getNumber()%>">
							</div>
							<div class="col-md-6 form-group p_star">
								<input type="text" class="form-control" id="email" name="email"
									placeholder="Email">
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="add1" name="address"
									placeholder="Address" value="<%=model.getAddress()%>">
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="city" name="city"
									placeholder="City" value="<%=model.getCity()%>">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="subServiceName"
									placeholder="SubService Name"
									value="<%=new CustomerDAO().subServiceName(subserviceid)%>">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="price" name="price"
									placeholder="Price" value="<%=price%>">
							</div>
							<input type="hidden" name="subserviceid"
								value="<%=subserviceid%>"> <input type="hidden"
								name="customerid" value="<%=model.getCustomerid()%>">
							<button type="submit" class="btn_3" name="action"
								value="Proceed to Pay">Proceed to Pay</button>
						</form>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</section>
	<!--================End Checkout Area =================-->

	<%@ include file="footer.jsp"%>

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

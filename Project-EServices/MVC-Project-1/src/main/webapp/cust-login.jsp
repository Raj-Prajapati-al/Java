<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<%@ include file="header.jsp"%>
	<!--================login_part Area =================-->
	<section class="login_part padding_top">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-6 col-md-6">
					<div class="login_part_text text-center">
						<div class="login_part_text_iner">
							<h2>New to Our E-Service?</h2>
							<p>We Provide's lots of Service's.</p>
							<a href="cust-signup.jsp" class="btn_3">Create an Account</a>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="login_part_form">
						<div class="login_part_form_iner">
							<c:if test="${not empty errorMsg}">
								<div class="alert alert-danger alert-dismissible fade show"
									role="alert">
									<strong>Error! </strong>${errorMsg}
									<button type="button" class="close" data-bs-dismiss="alert"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<%
									// Clear session attributes 
									if (session.getAttribute("errorMsg") != null) {
										session.removeAttribute("errorMsg");
									}
									%>
								</div>
							</c:if>
							<h3>
								Welcome Back ! <br> Please Login in now
							</h3>
							<form class="row contact_form" action="CustomerController"
								method="post" novalidate="novalidate">
								<div class="col-md-12 form-group p_star">
									<input type="email" class="form-control" id="name" name="email"
										placeholder="Email">
								</div>
								<div class="col-md-12 form-group p_star">
									<input type="password" class="form-control" id="password"
										name="password" placeholder="Password">

								</div>
								<div class="col-md-12 form-group">
									<button type="submit" name="action" value="login" class="btn_3">
										Login</button>
									<a class="lost_pass" href="cust-forgot.jsp">forgot
										password?</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================login_part end =================-->
	<%@ include file="footer.jsp"%>
</body>
</html>
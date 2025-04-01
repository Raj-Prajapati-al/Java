<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Service Banner</title>
<style>
.responsive-img {
	max-width: 100%;
	height: auto;
	display: block;
}

.banner_img {
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<!-- Banner part start -->
	<section class="banner_part">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-12">
					<div class="banner_slider owl-carousel">
						<div class="single_banner_slider">
							<div class="row">
								<div class="col-lg-5 col-md-8">
									<div class="banner_text">
										<div class="banner_text_iner">
											<h1>Plumber Service</h1>
											<p>Reliable and efficient plumbing solutions for all your
												home and business needs</p>
											<c:if test="${empty firstname}">
												<a href="cust-login.jsp" class="btn_2">Login</a>
											</c:if>
										</div>
									</div>
								</div>
								<div class="col-lg-7 banner_img">
									<img class="responsive-img" src="img/plumber.png"
										alt="Plumber Service">
								</div>
							</div>
						</div>
						<div class="single_banner_slider">
							<div class="row">
								<div class="col-lg-5 col-md-8">
									<div class="banner_text">
										<div class="banner_text_iner">
											<h1>A.C Services</h1>
											<p>Professional setup of air conditioning units, ensuring
												proper placement, connections, and functionality for optimal
												cooling and energy efficiency.</p>
											<c:if test="${empty firstname}">
												<a href="cust-login.jsp" class="btn_2">Login</a>
											</c:if>
										</div>
									</div>
								</div>
								<div class="col-lg-7 banner_img">
									<img class="responsive-img" src="img/product/AC.jpeg"
										alt="A.C Services">
								</div>
							</div>
						</div>
						<div class="single_banner_slider">
							<div class="row">
								<div class="col-lg-5 col-md-8">
									<div class="banner_text">
										<div class="banner_text_iner">
											<h1>Car Washing Services</h1>
											<p>Removes dirt, grime, and road salt from the car's
												exterior using water, soap, and brushes, leaving it looking
												clean and shiny.</p>
											<c:if test="${empty firstname}">
												<a href="cust-login.jsp" class="btn_2">Login</a>
											</c:if>
										</div>
									</div>
								</div>
								<div class="col-lg-7 banner_img">
									<img class="responsive-img"
										src="img/product/washing image.jfif"
										alt="Car Washing Services">
								</div>
							</div>
						</div>
					</div>
					<div class="slider-counter"></div>
				</div>
			</div>
		</div>
	</section>
	<!-- Banner part end -->
</body>
</html>
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
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
	<%@ include file="header.jsp" %>
	<%@ include file="banner.jsp" %>
	<!-- feature_part start-->
    <section class="feature_part padding_top">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="section_tittle text-center">
                        <h2>Sub Services</h2>
                    </div>
                </div>
            </div>    
            <div class="row align-items-center justify-content-between">
             <%
                 	int serviceid=Integer.parseInt(request.getParameter("serviceid"));
	          		Connection cn=new CustomerUtil().getConnectionCustomer();
	           		String qry="select * from subservice where serviceid=?";
	          		PreparedStatement st=cn.prepareStatement(qry);
	          		st.setInt(1, serviceid);
	          		ResultSet rs=st.executeQuery();
	         		while(rs.next())
	             	{
	        %>
                <div class="col-lg-6 col-sm-6">
                    <div class="single_feature_post_text">
                        <p><%=rs.getString(4) %></p>
                        <h3><%=rs.getString(3) %>(RS : <%=rs.getString(5) %>)</h3>
                        <a href="#" class="feature_btn">Booked Service<i class="fas fa-play"></i></a>
                        <img src="img/product/<%=rs.getString(3) %>" alt="">
                    </div>
                </div>
           <%
	             	}
                cn.close();
           %>
            </div>
        </div>
    </section>
    <!-- upcoming_event part start-->
    <%@ include file="footer.jsp" %>
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
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
  <!-- nice select CSS -->
  <link rel="stylesheet" href="css/nice-select.css">
  <!-- font awesome CSS -->
  <link rel="stylesheet" href="css/all.css">
  <!-- flaticon CSS -->
  <link rel="stylesheet" href="css/flaticon.css">
  <link rel="stylesheet" href="css/themify-icons.css">
  <!-- font awesome CSS -->
  <link rel="stylesheet" href="css/magnific-popup.css">
  <!-- swiper CSS -->
  <link rel="stylesheet" href="css/slick.css">
  <link rel="stylesheet" href="css/price_rangs.css">
  <!-- style CSS -->
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <section class="login_part padding_top">
     <div class="container">
      <div class="billing_details">
        <div class="row align-items-center">
          
         <!--   <div class="col-lg-4">
            <div class="order_box" style="background:white;">
              <img alt="" src="https://images.pexels.com/photos/3585000/pexels-photo-3585000.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2" height="500px" width="500px" style="border-radius:10px">
            </div>
          </div>
           -->
             <div class="col-lg-6 col-md-6">
                      <div class="login_part_text text-center" >
                        <div class="login_part_text_iner">
                            <h2>Already Register in E-Service?</h2>
                            <p>We Provide's lots of Service's.</p>
                            <a href="cust-login.jsp" class="btn_3">Login</a>
                        </div>
                    </div>
             </div>
            <div class="col-lg-6">
            <h3>Sign Up</h3>
            <form class="row contact_form" action="CustomerController" method="post" id="signupForm" novalidate="novalidate">
              <div class="col-md-6 form-group p_star">
                <input type="text" class="form-control" id="first" name="firstname" required/>
                <span class="placeholder" data-placeholder="First name"></span>
              </div>
              <div class="col-md-6 form-group p_star">
                <input type="text" class="form-control" id="last" name="lastname" required />
                <span class="placeholder" data-placeholder="Last name"></span>
              </div>
              <div class="col-md-6 form-group p_star">
                <input type="text" class="form-control" id="number" name="number" required/>
                <span class="placeholder" data-placeholder="Phone number"></span>
              </div>
              <div class="col-md-6 form-group p_star">
                <input type="email" class="form-control" id="email" name="email" required/>
                <span class="placeholder" data-placeholder="Email Address"></span>
              </div>
              <div class="col-md-12 form-group p_star">
                <input type="password" class="form-control" id="password" name="password" required/>
                <span class="placeholder" data-placeholder="Password"></span>
              </div>
              <div class="col-md-12 form-group p_star">
                <input type="text" class="form-control" id="address" name="address" required/>
                <span class="placeholder" data-placeholder="Enter address"></span>
              </div>
              <div class="col-md-12 form-group p_star">
                <input type="text" class="form-control" id="city" name="city" required/>
                <span class="placeholder" data-placeholder="Enter Town/City"></span>
              </div>
              <div class="col-md-12 form-group p_star">
                <input type="text" class="form-control" id="state" name="state" required/> <span class="placeholder" data-placeholder="Enter State"></span>
							</div>
              <div class="col-md-12 form-group">
                <input type="text" class="form-control" id="pincode" name="pincode" placeholder="Postcode/ZIP" required/>
              </div>
              <div class="col-md-12 form-group">
                <input type="submit" name="action" value="SignUp" class="btn_3" style="border-radius:10px;color:white;">
              </div>
            </form>
          </div>
         </div>
        </div>
      </div> 
  </section>
  <%@ include file="footer.jsp" %>
  <!-- jquery plugins here-->
  <!-- jquery -->
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
  <script src="js/stellar.js"></script>
  <script src="js/price_rangs.js"></script>
  <!-- custom js -->
  <script src="js/custom.js"></script>

  <script>
    $(document).ready(function(){
      $("#signupForm").validate({
        rules: {
          firstname: "required",
          lastname: "required",
          number: {
            required: true,
            digits: true,
            minlength: 10,
            maxlength: 10
          },
          email: {
            required: true,
            email: true
          },
          password: {
            required: true,
            minlength: 6
          },
          address: "required",
          city: "required",
          state: "required",
          pincode: {
            required: true,
            digits: true,
            minlength: 6,
            maxlength: 6
          }
        },
        messages: {
          firstname: "Please enter your firstname",
          lastname: "Please enter your lastname",
          number: {
            required: "Please enter your phone number",
            digits: "Please enter only digits",
            minlength: "Phone number should be 10 digits",
            maxlength: "Phone number should be 10 digits"
          },
          email: {
            required: "Please enter your email address",
            email: "Please enter a valid email address"
          },
          password: {
            required: "Please enter a password",
            minlength: "Password should be at least 6 characters long"
          },
          address: "Please enter your address",
          city: "Please enter your city",
          state: "Please enter your state",
          pincode: {
            required: "Please enter your pincode",
            digits: "Please enter only digits",
            minlength: "Pincode should be 6 digits",
            maxlength: "Pincode should be 6 digits"
          }
        },
        errorElement: "div",
        errorPlacement: function(error, element) {
          error.addClass("invalid-feedback");
          error.insertAfter(element);
        },
        highlight: function(element, errorClass, validClass) {
          $(element).addClass("is-invalid").removeClass("is-valid");
        },
        unhighlight: function(element, errorClass, validClass) {
          $(element).addClass("is-valid").removeClass("is-invalid");
        }
      });
    });
  </script>
</body>
</html>

<%@ include file="header.jsp" %>
<html>
<head>
    <title>Enter OTP</title>
</head>
<body>
    <div class="container">
        <h2>Enter OTP</h2>
        <form action="VerifyOTPController" method="post">
            <div class="form-group">
                <label for="otp">OTP:</label>
                <input type="text" class="form-control" id="otp" name="otp">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>
</html>

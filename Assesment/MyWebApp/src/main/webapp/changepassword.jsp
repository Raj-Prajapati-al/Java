<%@ include file="header.jsp" %>
<html>
<head>
    <title>Change Password</title>
</head>
<body>
	<% if (user == null) {
         response.sendRedirect("login.jsp");
     } else { %>
        <div class="container">
        <h2>Change Password</h2>
        <form action="ChangePasswordController" method="post">
            <div class="form-group">
    
                <label for="oldPassword">Old Password:</label>
                <input type="password" class="form-control" id="oldPassword" name="oldPassword">
            </div>
            <div class="form-group">
                <label for="newPassword">New Password:</label>
                <input type="password" class="form-control" id="newPassword" name="newPassword">
            </div>
            <div class="form-group">
                <label for="confirmNewPassword">Confirm New Password:</label>
                <input type="password" class="form-control" id="confirmNewPassword" name="confirmNewPassword">
            </div>
            <button type="submit" class="btn btn-primary">Change Password</button>
        </form>
     <% } %>
    
    </div>
    <script src="js/validation.js"></script>
    <%@ include file="footer.jsp" %>
</body>
</html>

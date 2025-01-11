<%@ include file="header.jsp" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div class="container">
     	<% if(request.getAttribute("errorMessage") != null) { %>
            <p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
        <h2>Login</h2>
        <form action="LoginController" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
        <a href="forgotpassword.jsp">Forgot Password?</a>
    </div>
</body>
</html>

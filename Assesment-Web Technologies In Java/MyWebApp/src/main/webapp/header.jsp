<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.model.Student" %>
<%
    session = request.getSession(false);
    String user = (session != null) ? (String) session.getAttribute("user") : null;
    Student student = (session != null) ? (Student) session.getAttribute("student") : null;
%>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<% 	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); %>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <a class="navbar-brand" href="index.jsp">MyWebApp</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                <% if (user == null) { %>
                    <li class="nav-item"><a class="nav-link" href="signup.jsp">Sign Up</a></li>
                    <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
                <% } else { %>
                    <li class="nav-item"><a class="nav-link" href="LogoutController">Logout (<%= user %>)</a></li>
                	<li class="nav-item"><a class="nav-link" href="changepassword.jsp">Change Password</a></li>
                <% } %>
            </ul>
        </div>
    </nav>
</body>
</html>
  

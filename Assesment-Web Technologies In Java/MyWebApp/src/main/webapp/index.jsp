<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container mt-5">
        <h1>Welcome to MyWebApp</h1>
        <p>This is the home page of your web application.</p>

        <% if (student != null) { %>
            <h2>User Details</h2>
            <table class="table">
                <tr>
                    <th>Name</th>
                    <td><%= student.getFirstName() %></td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td><%= student.getEmail() %></td>
                </tr>
                <!-- Add more fields as necessary -->
            </table>
        <% } %>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>

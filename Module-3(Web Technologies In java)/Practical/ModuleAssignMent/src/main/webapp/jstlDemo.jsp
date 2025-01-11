<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List, java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP with JSTL and Scriptlets</title>
</head>
<body>
    <h2>Iterating through a List using JSTL</h2>

    <%
        // Example list
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        request.setAttribute("namesList", names);
    %>

    <ul>
        <c:forEach var="name" items="${namesList}">
            <li>${name}</li>
        </c:forEach>
    </ul>

    <h2>Displaying a Scriptlet</h2>
    <%
        String message = "Hello from a Scriptlet!";
        out.println("<p>" + message + "</p>");
    %>

    <h2>Accessing Implicit Objects</h2>
    <p>Server Name: <%= application.getServerInfo() %></p>
    <p>Current Session ID: <%= session.getId() %></p>
    <p>Client IP Address: <%= request.getRemoteAddr() %></p>
</body>
</html>

<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <%
        HttpSession sessionTwo = request.getSession(false);
        String username = null;

        if (sessionTwo != null) {
            username = (String) session.getAttribute("username");
        }

        if (username == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        username = cookie.getValue();
                        break;
                    }
                }
            }
        }

        if (username != null) {
            out.println("<h2>Welcome, " + username + "!</h2>");
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>

package com.SessionDemo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServletTwo")
public class LoginServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Dummy validation (Replace with actual validation logic)
        if ("admin".equals(username) && "password".equals(password)) {
            // Create session and set attribute
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Create cookie
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(30 * 60); // 30 minutes
            response.addCookie(userCookie);

            response.sendRedirect("welcomeTwo.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("loginTwo.jsp").forward(request, response);
        }
    }
}

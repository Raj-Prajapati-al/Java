package com.controller;

import com.dao.StudentDAO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        StudentDAO studentDAO = new StudentDAO();
        if (studentDAO.isEmailRegistered(email)) {
            // Generate and send OTP (This part is simplified)
            String otp = "123456"; // Replace with actual OTP generation logic
            request.getSession().setAttribute("otp", otp);
            request.getSession().setAttribute("email", email);
            // Send OTP to email (simplified)
            response.sendRedirect("enterotp.jsp");
        } else {
            request.setAttribute("errorMessage", "Email is not registered.");
            request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
        }
    }
}

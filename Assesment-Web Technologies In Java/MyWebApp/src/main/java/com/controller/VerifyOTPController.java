package com.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/VerifyOTPController")
public class VerifyOTPController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String enteredOtp = request.getParameter("otp");
        String generatedOtp = (String) session.getAttribute("otp");

        if (enteredOtp != null && enteredOtp.equals(generatedOtp)) {
            response.sendRedirect("resetpassword.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid OTP. Please try again.");
            request.getRequestDispatcher("enterotp.jsp").forward(request, response);
        }
    }
}

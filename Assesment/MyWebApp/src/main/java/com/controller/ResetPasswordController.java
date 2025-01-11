package com.controller;

import com.dao.StudentDAO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ResetPasswordController")
public class ResetPasswordController extends HttpServlet 
{
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");

        if (newPassword != null && newPassword.equals(confirmNewPassword)) 
        {
            StudentDAO studentDAO = new StudentDAO();
            boolean isUpdated = studentDAO.updatePassword(email, newPassword);
            if (isUpdated) {
                session.invalidate();
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("errorMessage", "Failed to reset password. Please try again.");
                request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Passwords do not match. Please try again.");
            request.getRequestDispatcher("resetpassword.jsp").forward(request, response);
        }
    }
}

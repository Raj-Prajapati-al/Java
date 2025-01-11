package com.controller;

import com.dao.StudentDAO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ChangePasswordController")
public class ChangePasswordController extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("user");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmNewPassword = request.getParameter("confirmNewPassword");

        StudentDAO studentDAO = new StudentDAO();
        if (studentDAO.getStudentByEmailAndPassword(email, oldPassword) != null) {
            if (newPassword.equals(confirmNewPassword)) {
                boolean isUpdated = studentDAO.updatePassword(email, newPassword);
                if (isUpdated) {
                    session.invalidate();
                    response.sendRedirect("login.jsp");
                } else {
                    request.setAttribute("errorMessage", "Failed to update password.");
                    request.getRequestDispatcher("changepassword.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "New password and confirm password do not match.");
                request.getRequestDispatcher("changepassword.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Old password is incorrect.");
            request.getRequestDispatcher("changepassword.jsp").forward(request, response);
        }
    }
}

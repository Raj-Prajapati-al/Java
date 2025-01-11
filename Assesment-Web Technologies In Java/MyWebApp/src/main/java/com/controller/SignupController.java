package com.controller;

import com.dao.StudentDAO;
import com.model.Student;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");

        StudentDAO studentDAO = new StudentDAO();
        if (!studentDAO.isEmailRegistered(email)) {
            Student student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setEmail(email);
            student.setMobile(mobile);
            student.setAddress(address);
            student.setGender(gender);
            student.setPassword(password);
            boolean isRegistered = studentDAO.registerStudent(student);
            if (isRegistered) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("errorMessage", "Failed to register. Please try again.");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Email is already registered.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }
}

package com.controller;

import com.dao.StudentDAO;
import com.model.Student;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentByEmailAndPassword(email, password);

        if (student != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", student.getEmail()); // Set the user's email in the session
            session.setAttribute("student", student); // Set the user's data in the session
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid email or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

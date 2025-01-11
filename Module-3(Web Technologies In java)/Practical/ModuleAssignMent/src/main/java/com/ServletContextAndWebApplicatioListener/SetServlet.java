package com.ServletContextAndWebApplicatioListener;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetServlet")
public class SetServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        getServletContext().setAttribute("sharedData", "This data is shared across servlets.");
        response.getWriter().println("Data has been set in ServletContext.");
    }
}

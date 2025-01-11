package com.ServletConfigDemo;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyConfigServlet extends HttpServlet 
{
    private String greeting;

    @Override
    public void init(ServletConfig config) throws ServletException 
    {
        super.init(config);
        // Fetch the initialization parameter
        greeting = config.getInitParameter("greeting");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>" + greeting + "</h1>");
    }
}

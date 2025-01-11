package com.HttpServletAndGenericServletDemo;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;

@WebServlet("/GenericHelloServlet")
public class GenericHelloServlet extends GenericServlet 
{
    @Override
    public void service(ServletRequest request, ServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        out.println("<html><head><title>Hello GenericServlet</title></head>");
        out.println("<body>");
        out.println("<h1>Hello, " + name + "!</h1>");
        out.println("</body></html>");
    }
}

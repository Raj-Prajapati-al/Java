package com.ServletDemos;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        out.println("<html><head><title>Hello Servlet</title></head>");
        out.println("<body>");
        if (name == null || name.isEmpty()) {
            out.println("<h1>Hello, Stranger!</h1>");
        } else {
            out.println("<h1>Hello, " + name + "!</h1>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }
}

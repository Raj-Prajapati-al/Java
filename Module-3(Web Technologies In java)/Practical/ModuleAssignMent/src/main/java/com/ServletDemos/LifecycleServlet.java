package com.ServletDemos;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LifecycleServlet")
public class LifecycleServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        log("init() method called");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        log("service() method called");
        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        log("doGet() method called");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Servlet Lifecycle</title></head>");
        out.println("<body>");
        out.println("<h1>Servlet Lifecycle Example</h1>");
        out.println("<p>Check the server logs for lifecycle method calls.</p>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        log("doPost() method called");
        doGet(request, response);
    }

    @Override
    public void destroy() {
        log("destroy() method called");
        super.destroy();
    }

    @Override
    public void log(String message) {
        System.out.println("LifecycleServlet: " + message);
    }
}

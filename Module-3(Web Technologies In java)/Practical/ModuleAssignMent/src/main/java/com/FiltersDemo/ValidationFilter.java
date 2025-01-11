package com.FiltersDemo;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/LoginServlet")
public class ValidationFilter implements Filter 
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException 
    {
    	
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            response.getWriter().println("Invalid input: Username and password must not be empty.");
            return;
        }

        // Input is valid, proceed with the request
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() 
    {
    	
    }
}

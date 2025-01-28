package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDAO;
import com.model.CustomerModel;


@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action=request.getParameter("action");	
		if(action.equalsIgnoreCase("SignUp"))
		{
			CustomerModel rmodel=new CustomerModel();
			rmodel.setFirstname(request.getParameter("firstname"));
			rmodel.setLastname(request.getParameter("lastname"));
			rmodel.setNumber(request.getParameter("number"));
			rmodel.setEmail(request.getParameter("email"));
			rmodel.setPassword(request.getParameter("password"));
			rmodel.setAddress(request.getParameter("address"));
			rmodel.setCity(request.getParameter("city"));
			rmodel.setState(request.getParameter("state")); 
			rmodel.setPincode(Integer.parseInt(request.getParameter("pincode")));
			
			int x=new CustomerDAO().getCustomerData(rmodel);
			if(x>0)
			{
				request.getRequestDispatcher("cust-login.jsp").forward(request, response);
				
			}
			else
			{
				request.getRequestDispatcher("cust-signup.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login"))
		{
			CustomerModel lmodel=new CustomerModel();
			lmodel.setEmail(request.getParameter("email"));
			lmodel.setPassword(request.getParameter("password"));
			
			CustomerModel model=new CustomerDAO().customerLogin(lmodel);
			if(model != null)
			{
				HttpSession session=request.getSession();
			    session.setAttribute("firstname", model.getFirstname());
//				request.getRequestDispatcher("index.jsp").forward(request, response);
			    response.sendRedirect("cust-home.jsp");
			}
			else
			{
				request.getRequestDispatcher("cust-login.jsp").forward(request, response);
			}
		}
	}

}

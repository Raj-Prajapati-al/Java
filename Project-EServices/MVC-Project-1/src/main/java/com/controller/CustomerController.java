package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.AdminDAO;
import com.dao.CustomerDAO;
import com.model.AddServiceModel;
import com.model.BookModel;
import com.model.CustomerModel;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.equalsIgnoreCase("SignUp")) {
			CustomerModel rmodel = new CustomerModel();
			rmodel.setFirstname(request.getParameter("firstname"));
			rmodel.setLastname(request.getParameter("lastname"));
			rmodel.setNumber(request.getParameter("number"));
			rmodel.setEmail(request.getParameter("email"));
			rmodel.setPassword(request.getParameter("password"));
			rmodel.setAddress(request.getParameter("address"));
			rmodel.setCity(request.getParameter("city"));
			rmodel.setState(request.getParameter("state"));
			rmodel.setPincode(Integer.parseInt(request.getParameter("pincode")));

			int x = new CustomerDAO().getCustomerData(rmodel);
			if (x > 0) {
				request.getRequestDispatcher("cust-login.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("cust-signup.jsp").forward(request, response);
			}
		}

		else if (action.equalsIgnoreCase("login")) {
			CustomerModel lmodel = new CustomerModel();
			lmodel.setEmail(request.getParameter("email"));
			lmodel.setPassword(request.getParameter("password"));

			CustomerModel model = new CustomerDAO().customerLogin(lmodel);
			if (model != null) {
				HttpSession session = request.getSession();
				session.setAttribute("model", model);
				session.setAttribute("customerid", model.getCustomerid());
				session.setAttribute("firstname", model.getFirstname());
				session.setAttribute("lastname", model.getLastname());

				response.sendRedirect("cust-home.jsp");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("errorMsg", "Invalid credentials");
				response.sendRedirect("cust-login.jsp");
			}
		}

		else if (action.equalsIgnoreCase("Proceed to Pay")) {
			BookModel bmodel = new BookModel();
			bmodel.setCustomerid(Integer.parseInt(request.getParameter("customerid")));
			bmodel.setSubserviceid(Integer.parseInt(request.getParameter("subserviceid")));
			bmodel.setPrice(request.getParameter("price"));

			// Use the correct way to get the current date
			Date d1 = new Date(System.currentTimeMillis());

			SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yyyy"); // Fixed incorrect date format
			bmodel.setOrderdate(s1.format(d1));

			SimpleDateFormat s2 = new SimpleDateFormat("hh:mm:ss a");
			bmodel.setOrdertime(s2.format(d1));

			bmodel.setBstatus("Pending");
			bmodel.setPstatus("Pending");

			int x = new CustomerDAO().bookSubServices(bmodel);
			if (x > 0) {
				response.sendRedirect("payment.jsp?price=" + bmodel.getPrice());
			} else {
				response.sendRedirect("book.jsp");
			}
		} else if (action.equalsIgnoreCase("viewcustomers")) {
			List<CustomerModel> customerList = new CustomerDAO().getAllCustomers();
			HttpSession session = request.getSession();
			session.setAttribute("customerList", customerList);
			response.sendRedirect("admin/view-customers.jsp");
		} else if (action.equalsIgnoreCase("EditCustomer")) {
			CustomerModel emodel = new CustomerModel();

			// Backend validation for empty fields
			String firstname = request.getParameter("firstname").trim();
			String lastname = request.getParameter("lastname").trim();
			String number = request.getParameter("number").trim();
			String email = request.getParameter("email").trim();
			String address = request.getParameter("address").trim();
			String city = request.getParameter("city").trim();
			String state = request.getParameter("state").trim();
			String pincodeStr = request.getParameter("pincode").trim();

			if (firstname.isEmpty() || lastname.isEmpty() || number.isEmpty() || email.isEmpty() || address.isEmpty()
					|| city.isEmpty() || state.isEmpty() || pincodeStr.isEmpty()) {
				request.setAttribute("error", "All fields are required. Please fill out the form completely.");
				request.getRequestDispatcher("cust-profile.jsp").forward(request, response);
				return;
			}

			// Proceed with setting values and updating the database
			emodel.setCustomerid(Integer.parseInt(request.getParameter("modelid")));
			emodel.setFirstname(firstname);
			emodel.setLastname(lastname);
			emodel.setNumber(number);
			emodel.setEmail(email);
			emodel.setAddress(address);
			emodel.setCity(city);
			emodel.setState(state);
			emodel.setPincode(Integer.parseInt(pincodeStr));

			boolean isUpdated = new CustomerDAO().updateCustomer(emodel);
			if (isUpdated) {
				HttpSession session = request.getSession();
				session.setAttribute("model", emodel);
				session.setAttribute("successMsg", "Profile Updated Successfully");
				response.sendRedirect("profile.jsp"); // Redirect to profile page
			} else {
				request.setAttribute("error", "Unable to update profile. Please try again.");
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("update")) {
			CustomerModel customer = new CustomerModel();
			customer.setCustomerid(Integer.parseInt(request.getParameter("customerid")));
			customer.setFirstname(request.getParameter("firstname"));
			customer.setLastname(request.getParameter("lastname"));
			customer.setNumber(request.getParameter("number"));
			customer.setEmail(request.getParameter("email"));
			customer.setAddress(request.getParameter("address"));
			customer.setCity(request.getParameter("city"));
			customer.setState(request.getParameter("state"));
			customer.setPincode(Integer.parseInt(request.getParameter("pincode")));

			boolean isUpdated = new CustomerDAO().updateCustomer(customer);
			if (isUpdated) {
				HttpSession session = request.getSession();
				// Fetch the updated service list and set it in the session
				List<CustomerModel> updatedCustomerList = new CustomerDAO().getAllCustomers();
				session.setAttribute("customerList", updatedCustomerList);

				session.setAttribute("successMsg", "Customer Updated Successfully");
				response.sendRedirect("admin/view-customers.jsp");
			} else {
				request.setAttribute("error", "Failed to update customer.");
				request.getRequestDispatcher("admin/edit-customer.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("deletecustomer")) {
			int customerId = Integer.parseInt(request.getParameter("customerid"));
			boolean isDeleted = new CustomerDAO().deleteCustomer(customerId);
			if (isDeleted) {
				HttpSession session = request.getSession();
				// Fetch the updated service list and set it in the session
				List<CustomerModel> updatedCustomerList = new CustomerDAO().getAllCustomers();
				session.setAttribute("customerList", updatedCustomerList);

				session.setAttribute("successMsg", "Customer Deleted Successfully");
				response.sendRedirect("admin/view-customers.jsp");
			} else {
				request.setAttribute("error", "Failed to delete the customer.");
				request.getRequestDispatcher("admin/view-customers.jsp").forward(request, response);
			}
		}
	}
}

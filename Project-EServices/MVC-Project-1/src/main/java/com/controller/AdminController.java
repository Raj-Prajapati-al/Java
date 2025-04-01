package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.dao.AdminDAO;
import com.model.AddServiceModel;
import com.model.AddSubServiceModel;
import com.model.AdminModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/AdminController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, // 512MB
		maxFileSize = 1024 * 1024 * 512, // 512MB
		maxRequestSize = 1024 * 1024 * 512) // 512MB
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("password");
		session.invalidate();
		// Prevent caching of sensitive pages
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", 0); // Proxies

		response.sendRedirect("admin/admin-index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		if (action.equalsIgnoreCase("signup")) {
			AdminModel armodel = new AdminModel();
			armodel.setUsername(request.getParameter("username"));
			armodel.setEmail(request.getParameter("email"));
			armodel.setPassword(request.getParameter("password"));

			int x = new AdminDAO().getAdminData(armodel);
			if (x > 0) {
				session.setAttribute("successMsg", "Signup successful");
				request.getRequestDispatcher("admin/admin-index.jsp").forward(request, response);
			} else {
				session.setAttribute("errorMsg", "Signup failed");
				request.getRequestDispatcher("admin/admin-register.jsp").forward(request, response);
			}
		} else if (action.equalsIgnoreCase("login")) {
			AdminModel almodel = new AdminModel();
			almodel.setUsername(request.getParameter("username"));
			almodel.setPassword(request.getParameter("password"));

			AdminModel model = new AdminDAO().getAdminLoginData(almodel);
			if (model != null) {
				session.setAttribute("username", almodel.getUsername());
				session.setAttribute("password", almodel.getPassword());
				response.sendRedirect("admin/admin-dashboard.jsp");
			} else {
				session.setAttribute("errorMsg", "Invalid credentials");
				response.sendRedirect("admin/admin-index.jsp");
			}
		} else if (action.equalsIgnoreCase("addservice")) {
			String savePath = "C:\\Users\\tops\\eclipse-workspace\\MVC-Project-1\\src\\main\\webapp\\img\\product";
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			Part file = request.getPart("image");
			String fileName = file.getSubmittedFileName();
			file.write(savePath + File.separator + fileName);
			AddServiceModel asm = new AddServiceModel();
			String serviceName = request.getParameter("servicename");
			if (serviceName.equals("")) {
				session.setAttribute("errorMsg", "Please Enter Service Name");
				response.sendRedirect("admin/addservice.jsp");
			} else {
				asm.setServicename(serviceName);
				asm.setImage(fileName);

				int x = new AdminDAO().getServiceData(asm);
				if (x > 0) {
					session.setAttribute("successMsg", "Service Added Successfully");
					response.sendRedirect("admin/admin-dashboard.jsp");
				} else {
					session.setAttribute("errorMsg", "Service Not Added Successfully");
					response.sendRedirect("admin/addservice.jsp");
				}
			}
		} else if (action.equalsIgnoreCase("addsubservice")) {
			AddSubServiceModel assm = new AddSubServiceModel();
			assm.setServiceid(Integer.parseInt(request.getParameter("serviceid")));
			assm.setSubservicename(request.getParameter("subservicename"));
			assm.setFeature(request.getParameter("feature"));
			assm.setPrice(request.getParameter("price"));

			int x = new AdminDAO().getSubServiceData(assm);
			if (x > 0) {
				session.setAttribute("successMsg", "SubService Added Successfully");
				response.sendRedirect("admin/admin-dashboard.jsp");
			} else {
				session.setAttribute("errorMsg", "SubService Not Added");
				response.sendRedirect("admin/addsubservice.jsp");
			}

		} else if (action.equalsIgnoreCase("viewservice")) {
			List<AddServiceModel> serviceList = new AdminDAO().getAllServices();
			session.setAttribute("serviceList", serviceList);
			response.sendRedirect("admin/viewservice.jsp");
		} else if (action.equalsIgnoreCase("viewsubservice")) {
			List<AddSubServiceModel> subServiceList = new AdminDAO().getAllSubServices();
			session.setAttribute("subServiceList", subServiceList);
			response.sendRedirect("admin/viewsubservice.jsp");
		} else if (action.equalsIgnoreCase("editservice")) {
			int serviceId = Integer.parseInt(request.getParameter("serviceid"));
			String serviceName = request.getParameter("servicename");
			Part file = request.getPart("image");
			String fileName = file.getSubmittedFileName();

			// Retrieve the existing image if no new file is uploaded
			String currentImage = new AdminDAO().getServiceImageById(serviceId);
			String savePath = "C:\\Users\\tops\\eclipse-workspace\\MVC-Project-1\\src\\main\\webapp\\img\\product";
			if (!fileName.isEmpty()) {
				file.write(savePath + File.separator + fileName);
			} else {
				fileName = currentImage; // Keep the existing image
			}

			AddServiceModel asm = new AddServiceModel();
			asm.setServiceid(serviceId);
			asm.setServicename(serviceName);
			asm.setImage(fileName);

			int x = new AdminDAO().updateService(asm);
			if (x > 0) {
				// Fetch the updated service list and set it in the session
				List<AddServiceModel> updatedServiceList = new AdminDAO().getAllServices();
				session.setAttribute("serviceList", updatedServiceList);

				session.setAttribute("successMsg", "Service Updated Successfully");
				response.sendRedirect("admin/viewservice.jsp");
			} else {
				session.setAttribute("errorMsg", "Service Update Failed");
				response.sendRedirect("admin/editservice.jsp?id=" + serviceId);
			}
		} else if (action.equalsIgnoreCase("editsubservice")) {
			int subServiceId = Integer.parseInt(request.getParameter("subserviceid"));
			String subServiceName = request.getParameter("subservicename");
			String feature = request.getParameter("feature");
			String price = request.getParameter("price");

			AddSubServiceModel assm = new AddSubServiceModel();
			assm.setSubserviceid(subServiceId);
			assm.setSubservicename(subServiceName);
			assm.setFeature(feature);
			assm.setPrice(price);

			int x = new AdminDAO().updateSubService(assm);
			if (x > 0) {
				// Fetch the updated subservice list and set it in the session
				List<AddSubServiceModel> updatedSubServiceList = new AdminDAO().getAllSubServices();
				session.setAttribute("subServiceList", updatedSubServiceList);

				session.setAttribute("successMsg", "SubService Updated Successfully");
				response.sendRedirect("admin/viewsubservice.jsp");
			} else {
				session.setAttribute("errorMsg", "SubService Update Failed");
				response.sendRedirect("admin/editsubservice.jsp?id=" + subServiceId);
			}
		} else if (action.equalsIgnoreCase("deleteservice")) {
			int serviceId = Integer.parseInt(request.getParameter("serviceid"));

			// Call the DAO to delete the service
			int x = new AdminDAO().deleteService(serviceId);
			if (x > 0) {
				// Fetch the updated service list and set it in the session
				List<AddServiceModel> updatedServiceList = new AdminDAO().getAllServices();
				session.setAttribute("serviceList", updatedServiceList);

				session.setAttribute("successMsg", "Service Deleted Successfully");
				response.sendRedirect("admin/viewservice.jsp");
			} else {
				session.setAttribute("errorMsg", "Service Deletion Failed");
				response.sendRedirect("admin/viewservice.jsp");
			}
		} else if (action.equalsIgnoreCase("deletesubservice")) {
			int subServiceId = Integer.parseInt(request.getParameter("subserviceid"));

			// Call the DAO to delete the subservice
			int x = new AdminDAO().deleteSubService(subServiceId);
			if (x > 0) {
				// Fetch the updated subservice list and set it in the session
				List<AddSubServiceModel> updatedSubServiceList = new AdminDAO().getAllSubServices();
				session.setAttribute("subServiceList", updatedSubServiceList);

				session.setAttribute("successMsg", "SubService Deleted Successfully");
				response.sendRedirect("admin/viewsubservice.jsp");
			} else {
				session.setAttribute("errorMsg", "SubService Deletion Failed");
				response.sendRedirect("admin/viewsubservice.jsp");
			}
		}

	}
}

package com.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.dao.AdminDAO;
import com.model.AddServiceModel;
import com.model.AddSubServiceModel;
import com.model.AdminModel;

@WebServlet("/AdminController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, //512MB
maxFileSize = 1024 * 1024 * 512, //512MB
maxRequestSize = 1024 * 1024 * 512) //512MB
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public AdminController() {
        super();
    }
    private String extractfilename(Part file)
    {
    	String cd= file.getHeader("content-disposition");
    	System.out.println(cd);
    	String[] item = cd.split(";");
    	for(String string : item)
    	{
    		if(string.trim().startsWith("filename"))
    		{
    			return string.substring(string.indexOf("=") + 2, string.length()-1);
    		}
    	}
    	return "";
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.invalidate();
        response.sendRedirect("admin/admin-index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        if(action.equalsIgnoreCase("signup")) 
        {
            AdminModel armodel = new AdminModel();
            armodel.setUsername(request.getParameter("username"));
            armodel.setEmail(request.getParameter("email"));
            armodel.setPassword(request.getParameter("password"));
            
            int x = new AdminDAO().getAdminData(armodel);
            if(x > 0) 
            {
                session.setAttribute("successMsg", "Signup successful");
                request.getRequestDispatcher("admin/admin-index.jsp").forward(request, response);
            } 
            else 
            {
                session.setAttribute("errorMsg", "Signup failed");
                request.getRequestDispatcher("admin/admin-register.jsp").forward(request, response);
            }
        } 
        else if(action.equalsIgnoreCase("login")) 
        {
            AdminModel almodel = new AdminModel();
            almodel.setUsername(request.getParameter("username"));
            almodel.setPassword(request.getParameter("password"));
            
            AdminModel model = new AdminDAO().getAdminLoginData(almodel);
            if(model != null) 
            {
                session.setAttribute("username", almodel.getUsername());
                session.setAttribute("password", almodel.getPassword());
                response.sendRedirect("admin/admin-dashboard.jsp");
            } 
            else 
            {
                session.setAttribute("errorMsg", "Invalid credentials");
                response.sendRedirect("admin/admin-index.jsp");
            }
        } 
        else if(action.equalsIgnoreCase("addservice")) 
        {
        	String savePath="C:\\Users\\asfakansari\\eclipse-workspace\\MVC_Project\\src\\main\\webapp\\img\\product";
        	File fileSaveDir=new File(savePath);
        	if(!fileSaveDir.exists())
        	{
        		fileSaveDir.mkdir();
        	}
        	Part file=request.getPart("image");
        	String fileName=extractfilename(file);
        	file.write(savePath+File.separator+fileName);
            AddServiceModel asm = new AddServiceModel();
            String serviceName = request.getParameter("servicename");
            if(serviceName.equals("")) 
            {
                session.setAttribute("errorMsg", "Please Enter Service Name");
                response.sendRedirect("admin/addservice.jsp");
            } 
            else 
            {
                asm.setServicename(serviceName);
                asm.setImage(fileName);
                
                int x = new AdminDAO().getServiceData(asm);
                if(x > 0) 
                {
                    session.setAttribute("successMsg", "Service Added Successfully");
                    response.sendRedirect("admin/admin-dashboard.jsp");
                } 
                else 
                {
                    session.setAttribute("errorMsg", "Service Not Added Successfully");
                    response.sendRedirect("admin/addservice.jsp");
                }
            }
        }
        else if(action.equalsIgnoreCase("addsubservice"))
        {
        	 AddSubServiceModel assm=new AddSubServiceModel();
           	 assm.setServiceid(Integer.parseInt(request.getParameter("serviceid")));
           	 assm.setSubservicename(request.getParameter("subservicename"));
           	 assm.setFeature(request.getParameter("feature"));
           	 assm.setPrice(request.getParameter("price"));
           	 
           	 int x=new AdminDAO().getSubServiceData(assm);
           	 if(x > 0) 
             {
                   session.setAttribute("successMsg", "SubService Added Successfully");
                   response.sendRedirect("admin/admin-dashboard.jsp");
             } 
             else 
             {
                  session.setAttribute("errorMsg", "SubService Not Added");
                  response.sendRedirect("admin/addsubservice.jsp");
             }
           			 
          }
     }
}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.AddServiceModel;
import com.model.AddSubServiceModel;
import com.model.AdminModel;
import com.util.CustomerUtil;

public class AdminDAO 
{
	Connection cn=null;
	public int getAdminData(AdminModel armodel)
	{
		int x=0;
		cn=new CustomerUtil().getConnectionCustomer();
		String qry="Insert into admin(username,email,password) Values (?,?,?)";
		try 
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, armodel.getUsername());
			st.setString(2, armodel.getEmail());
			st.setString(3, armodel.getPassword());
			x=st.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
	public AdminModel getAdminLoginData(AdminModel armodel)
	{
		AdminModel model=null;
		cn=new CustomerUtil().getConnectionCustomer();
		String qry="select * from admin where username=? and password=?";
		try 
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, armodel.getUsername());
			st.setString(2, armodel.getPassword());
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				model=new AdminModel();
				model.setAdminid(rs.getInt(1));
				model.setUsername(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setPassword(rs.getString(4));
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
	}
	
	public int getServiceData(AddServiceModel asm)
	{
		int x=0;
		cn=new CustomerUtil().getConnectionCustomer();
		String qry="Insert into service(servicename,image) Values(?,?)";
		try 
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, asm.getServicename());
			st.setString(2, asm.getImage());
			x=st.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	public int getSubServiceData(AddSubServiceModel assm)
	{
		int x=0;
		cn=new CustomerUtil().getConnectionCustomer();
		String qry="Insert into subservice(serviceid,subservicename,feature,price) Values(?,?,?,?)";
		try 
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setInt(1, assm.getServiceid());
			st.setString(2, assm.getSubservicename());
			st.setString(3,assm.getFeature());
			st.setString(4, assm.getPrice());
			x=st.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model.CustomerModel;
import com.util.CustomerUtil;

public class CustomerDAO 
{
	Connection cn=null;
	public int getCustomerData(CustomerModel rmodel)
	{
		int x=0;
		cn=new CustomerUtil().getConnectionCustomer();
		String qry="Insert into customer(firstname,lastname,number,email,password,address,city,state,pincode) Values(?,?,?,?,?,?,?,?,?)";
		try 
		{
			PreparedStatement ps=cn.prepareStatement(qry);
			ps.setString(1,rmodel.getFirstname());
			ps.setString(2,rmodel.getLastname());
			ps.setString(3,rmodel.getNumber());
			ps.setString(4,rmodel.getEmail());
			ps.setString(5,rmodel.getPassword());
			ps.setString(6,rmodel.getAddress());
			ps.setString(7,rmodel.getCity());
			ps.setString(8,rmodel.getState());
			ps.setInt(9,rmodel.getPincode());
			x=ps.executeUpdate();
			cn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
	
	public CustomerModel customerLogin(CustomerModel lmodel)
	{
		CustomerModel model=null;
		cn=new CustomerUtil().getConnectionCustomer();
		String qry="select * from customer where email=? and password=?";
		try 
		{
			PreparedStatement st=cn.prepareStatement(qry);
			st.setString(1, lmodel.getEmail());
			st.setString(2, lmodel.getPassword());
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				model=new CustomerModel();
				model.setCustomerid(rs.getInt(1));
				model.setFirstname(rs.getString(2));
				model.setLastname(rs.getString(3));
				model.setNumber(rs.getString(4));
				model.setEmail(rs.getString(5));
				model.setPassword(rs.getString(6));
				model.setAddress(rs.getString(7));
				model.setCity(rs.getString(8));
				model.setState(rs.getString(9));
				model.setPincode(rs.getInt(10));
				
			}
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
		
	}

}

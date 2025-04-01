package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.model.CustomerModel;
import com.util.CustomerUtil;

public class ForgotDAO {
	
	public CustomerModel checkEmail(String email)
	{
		CustomerModel f=new CustomerModel();
		try {
		
			Connection conn=new CustomerUtil().getConnectionCustomer();
			String sql="select * from  customer where email=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				f.setCustomerid(rs.getInt(1));
				f.setEmail(rs.getString("email"));
				f.setFirstname(rs.getString(2));
				f.setLastname(rs.getString(3));
			}
			else
			{
				f=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}
	public int resetPassword(CustomerModel f)
	{
		int r=0;
		try {
			Connection conn=new CustomerUtil().getConnectionCustomer();
			String sql="update customer set password=? where customerid=?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, f.getPassword());
			stmt.setInt(2, f.getCustomerid());
			r=stmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

}

package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.BookModel;
import com.model.CustomerModel;
import com.util.CustomerUtil;

public class CustomerDAO {
	Connection cn = null;

	public int getCustomerData(CustomerModel rmodel) {
		int x = 0;
		cn = new CustomerUtil().getConnectionCustomer();
		String qry = "Insert into customer(firstname,lastname,number,email,password,address,city,state,pincode) Values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(qry);
			ps.setString(1, rmodel.getFirstname());
			ps.setString(2, rmodel.getLastname());
			ps.setString(3, rmodel.getNumber());
			ps.setString(4, rmodel.getEmail());
			ps.setString(5, rmodel.getPassword());
			ps.setString(6, rmodel.getAddress());
			ps.setString(7, rmodel.getCity());
			ps.setString(8, rmodel.getState());
			ps.setInt(9, rmodel.getPincode());
			x = ps.executeUpdate();
			cn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return x;
	}

	public CustomerModel customerLogin(CustomerModel lmodel) {
		CustomerModel model = null;
		cn = new CustomerUtil().getConnectionCustomer();
		String qry = "select * from customer where email=? and password=?";
		try {
			PreparedStatement st = cn.prepareStatement(qry);
			st.setString(1, lmodel.getEmail());
			st.setString(2, lmodel.getPassword());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				model = new CustomerModel();
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

	public List<CustomerModel> getAllCustomers() {
		List<CustomerModel> customerList = new ArrayList<>();
		String query = "SELECT * FROM customer";

		try (Connection conn = new CustomerUtil().getConnectionCustomer();
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				CustomerModel customer = new CustomerModel();
				customer.setCustomerid(rs.getInt("customerid"));
				customer.setFirstname(rs.getString("firstname"));
				customer.setLastname(rs.getString("lastname"));
				customer.setNumber(rs.getString("number"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setAddress(rs.getString("address"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPincode(rs.getInt("pincode"));
				customerList.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return customerList;
	}

	public String subServiceName(int subserviceid) {
		cn = new CustomerUtil().getConnectionCustomer();
		String qry = "select subservicename from subservice where subserviceid=?";
		String ssname = null;
		try {
			PreparedStatement st = cn.prepareStatement(qry);
			st.setInt(1, subserviceid);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				ssname = rs.getString(1);
			}
			cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ssname;
	}

	public int bookSubServices(BookModel bmodel) {
		int x = 0;

		cn = new CustomerUtil().getConnectionCustomer();
		String qry = "insert into book(subserviceid,customerid,orderdate,ordertime,price,bstatus,pstatus) values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = cn.prepareStatement(qry);
			st.setInt(1, bmodel.getSubserviceid());
			st.setInt(2, bmodel.getCustomerid());
			st.setString(3, bmodel.getOrderdate());
			st.setString(4, bmodel.getOrdertime());
			st.setString(5, bmodel.getPrice());
			st.setString(6, bmodel.getBstatus());
			st.setString(7, bmodel.getPstatus());
			x = st.executeUpdate();
			cn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	public boolean updateCustomer(CustomerModel customer) {
		String query = "UPDATE customer SET firstname = ?, lastname = ?, number = ?, email = ?, address = ?, city = ?, state = ?, pincode = ? WHERE customerid = ?";
		try (Connection conn = new CustomerUtil().getConnectionCustomer();
				PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, customer.getFirstname());
			ps.setString(2, customer.getLastname());
			ps.setString(3, customer.getNumber());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getCity());
			ps.setString(7, customer.getState());
			ps.setInt(8, customer.getPincode());
			ps.setInt(9, customer.getCustomerid());

			int result = ps.executeUpdate();
			return result > 0; // Return true if the update was successful
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public CustomerModel getCustomerById(int id) {
		String query = "SELECT * FROM customer WHERE customerid = ?";
		try (Connection conn = new CustomerUtil().getConnectionCustomer();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				CustomerModel customer = new CustomerModel();
				customer.setCustomerid(rs.getInt("customerid"));
				customer.setFirstname(rs.getString("firstname"));
				customer.setLastname(rs.getString("lastname"));
				customer.setNumber(rs.getString("number"));
				customer.setEmail(rs.getString("email"));
				customer.setAddress(rs.getString("address"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPincode(rs.getInt("pincode"));
				return customer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteCustomer(int id) {
		String query = "DELETE FROM customer WHERE customerid = ?";
		try (Connection conn = new CustomerUtil().getConnectionCustomer();
				PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

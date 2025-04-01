package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.AddServiceModel;
import com.model.AddSubServiceModel;
import com.model.AdminModel;
import com.util.CustomerUtil;

public class AdminDAO {
	Connection cn = null;

	public int getAdminData(AdminModel armodel) {
		int x = 0;
		cn = new CustomerUtil().getConnectionCustomer();
		String qry = "Insert into admin(username,email,password) Values (?,?,?)";
		try {
			PreparedStatement st = cn.prepareStatement(qry);
			st.setString(1, armodel.getUsername());
			st.setString(2, armodel.getEmail());
			st.setString(3, armodel.getPassword());
			x = st.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return x;
	}

	public AdminModel getAdminLoginData(AdminModel armodel) {
		AdminModel model = null;
		cn = new CustomerUtil().getConnectionCustomer();
		String qry = "select * from admin where username=? and password=?";
		try {
			PreparedStatement st = cn.prepareStatement(qry);
			st.setString(1, armodel.getUsername());
			st.setString(2, armodel.getPassword());
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				model = new AdminModel();
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

	public int getServiceData(AddServiceModel asm) {
		int x = 0;
		cn = new CustomerUtil().getConnectionCustomer();
		String qry = "Insert into service(servicename,image) Values(?,?)";
		try {
			PreparedStatement st = cn.prepareStatement(qry);
			st.setString(1, asm.getServicename());
			st.setString(2, asm.getImage());
			x = st.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	public int getSubServiceData(AddSubServiceModel assm) {
		int x = 0;
		cn = new CustomerUtil().getConnectionCustomer();
		String qry = "Insert into subservice(serviceid,subservicename,feature,price) Values(?,?,?,?)";
		try {
			PreparedStatement st = cn.prepareStatement(qry);
			st.setInt(1, assm.getServiceid());
			st.setString(2, assm.getSubservicename());
			st.setString(3, assm.getFeature());
			st.setString(4, assm.getPrice());
			x = st.executeUpdate();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

	public List<AddServiceModel> getAllServices() {
		List<AddServiceModel> serviceList = new ArrayList<>();
		cn = new CustomerUtil().getConnectionCustomer();
		String qry = "SELECT * FROM service";
		try {
			PreparedStatement st = cn.prepareStatement(qry);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				AddServiceModel asm = new AddServiceModel();
				asm.setServiceid(rs.getInt("serviceid"));
				asm.setServicename(rs.getString("servicename"));
				asm.setImage(rs.getString("image"));
				serviceList.add(asm);
			}
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serviceList;
	}

	public List<AddSubServiceModel> getAllSubServices() {
		List<AddSubServiceModel> subServiceList = new ArrayList<>();
		cn = new CustomerUtil().getConnectionCustomer();
		String qry = "SELECT * FROM subservice";
		try {
			PreparedStatement st = cn.prepareStatement(qry);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				AddSubServiceModel assm = new AddSubServiceModel();
				assm.setSubserviceid(rs.getInt("subserviceid"));
				assm.setServiceid(rs.getInt("serviceid"));
				assm.setSubservicename(rs.getString("subservicename"));
				assm.setFeature(rs.getString("feature"));
				assm.setPrice(rs.getString("price"));
				subServiceList.add(assm);
			}
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subServiceList;
	}
	// Method to retrieve service by ID
	public AddServiceModel getServiceById(int serviceId) {
	    AddServiceModel service = null;
	    cn = new CustomerUtil().getConnectionCustomer();
	    String qry = "SELECT * FROM service WHERE serviceid = ?";
	    try {
	        PreparedStatement st = cn.prepareStatement(qry);
	        st.setInt(1, serviceId);
	        ResultSet rs = st.executeQuery();
	        if (rs.next()) {
	            service = new AddServiceModel();
	            service.setServiceid(rs.getInt("serviceid"));
	            service.setServicename(rs.getString("servicename"));
	            service.setImage(rs.getString("image"));
	        }
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return service;
	}
	//Return image name based on Id
	public String getServiceImageById(int serviceId) {
	    String image = "";
	    cn = new CustomerUtil().getConnectionCustomer();
	    String qry = "SELECT image FROM service WHERE serviceid = ?";
	    try {
	        PreparedStatement st = cn.prepareStatement(qry);
	        st.setInt(1, serviceId);
	        ResultSet rs = st.executeQuery();
	        if (rs.next()) {
	            image = rs.getString("image");
	        }
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return image;
	}
	// Method to update service
	public int updateService(AddServiceModel service) {
	    int x = 0;
	    cn = new CustomerUtil().getConnectionCustomer();
	    String qry = "UPDATE service SET servicename = ?, image = ? WHERE serviceid = ?";
	    try {
	        PreparedStatement st = cn.prepareStatement(qry);
	        st.setString(1, service.getServicename());
	        st.setString(2, service.getImage());
	        st.setInt(3, service.getServiceid());
	        x = st.executeUpdate();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return x;
	}

	// Method to delete service
	public int deleteService(int serviceId) {
	    int x = 0;
	    cn = new CustomerUtil().getConnectionCustomer();
	    String qry = "DELETE FROM service WHERE serviceid = ?";
	    try {
	        PreparedStatement st = cn.prepareStatement(qry);
	        st.setInt(1, serviceId);
	        x = st.executeUpdate();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return x;
	}

	// Method to retrieve subservice by ID
	public AddSubServiceModel getSubServiceById(int subServiceId) {
	    AddSubServiceModel subService = null;
	    cn = new CustomerUtil().getConnectionCustomer();
	    String qry = "SELECT * FROM subservice WHERE subserviceid = ?";
	    try {
	        PreparedStatement st = cn.prepareStatement(qry);
	        st.setInt(1, subServiceId);
	        ResultSet rs = st.executeQuery();
	        if (rs.next()) {
	            subService = new AddSubServiceModel();
	            subService.setSubserviceid(rs.getInt("subserviceid"));
	            subService.setServiceid(rs.getInt("serviceid"));
	            subService.setSubservicename(rs.getString("subservicename"));
	            subService.setFeature(rs.getString("feature"));
	            subService.setPrice(rs.getString("price"));
	        }
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return subService;
	}

	// Method to update subservice
	public int updateSubService(AddSubServiceModel subService) {
	    int x = 0;
	    cn = new CustomerUtil().getConnectionCustomer();
	    String qry = "UPDATE subservice SET subservicename = ?, feature = ?, price = ? WHERE subserviceid = ?";
	    try {
	        PreparedStatement st = cn.prepareStatement(qry);
	        st.setString(1, subService.getSubservicename());
	        st.setString(2, subService.getFeature());
	        st.setString(3, subService.getPrice());
	        st.setInt(4, subService.getSubserviceid());
	        x = st.executeUpdate();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return x;
	}

	// Method to delete subservice
	public int deleteSubService(int subServiceId) {
	    int x = 0;
	    cn = new CustomerUtil().getConnectionCustomer();
	    String qry = "DELETE FROM subservice WHERE subserviceid = ?";
	    try {
	        PreparedStatement st = cn.prepareStatement(qry);
	        st.setInt(1, subServiceId);
	        x = st.executeUpdate();
	        cn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return x;
	}
}

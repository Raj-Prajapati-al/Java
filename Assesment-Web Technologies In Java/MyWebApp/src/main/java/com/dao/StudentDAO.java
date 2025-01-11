package com.dao;
import com.model.Student;
import com.util.DBUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class StudentDAO 
{
	private static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
    public boolean registerStudent(Student student) 
    {
        String query = "INSERT INTO student (firstname, lastname, email, mobile, address, gender, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getLastName());
            pstmt.setString(3, student.getEmail());
            pstmt.setString(4, student.getMobile());
            pstmt.setString(5, student.getAddress());
            pstmt.setString(6, student.getGender());
            pstmt.setString(7, student.getPassword());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEmailRegistered(String email) 
    {
        String query = "SELECT COUNT(*) FROM student WHERE email = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Student getStudentByEmailAndPassword(String email, String password) 
    {
        String query = "SELECT * FROM student WHERE email = ? AND password = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("studentid"));
                student.setFirstName(rs.getString("firstname"));
                student.setLastName(rs.getString("lastname"));
                student.setEmail(rs.getString("email"));
                student.setMobile(rs.getString("mobile"));
                student.setAddress(rs.getString("address"));
                student.setGender(rs.getString("gender"));
                student.setPassword(rs.getString("password"));
                return student;
            } else {
                LOGGER.log(Level.INFO, "No student found with email: {0} and password: {1}", new Object[]{email, password});
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL exception in getStudentByEmailAndPassword", e);
        }
        return null;
    }
    
    public boolean updatePassword(String email, String newPassword) 
    {
        String query = "UPDATE student SET password = ? WHERE email = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, newPassword);
            pstmt.setString(2, email);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

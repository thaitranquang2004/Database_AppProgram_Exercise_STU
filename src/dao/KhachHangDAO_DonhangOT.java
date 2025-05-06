package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.KhachHang_DonhangOT;

public class KhachHangDAO_DonhangOT {
	public List<KhachHang_DonhangOT> findAll() {
	    List<KhachHang_DonhangOT> list = new ArrayList<>();
	    String sql = "SELECT * FROM khachhang";
	    try (Connection con = DatabaseConnection_DonhangOT.getConnection();
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	        	KhachHang_DonhangOT lop = new KhachHang_DonhangOT(rs.getInt("id"), rs.getString("ten_khachhang"));
	            list.add(lop);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
	public KhachHang_DonhangOT findByID(int id) {
	    String sql = "SELECT * FROM khachhang WHERE id = ?";
	    try (Connection con = DatabaseConnection_DonhangOT.getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new KhachHang_DonhangOT(rs.getInt("id"), rs.getString("ten_khachhang"));
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}

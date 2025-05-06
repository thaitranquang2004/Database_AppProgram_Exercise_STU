package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.TacGia_ThiGK;

public class TacGiaDAO_ThiGK {
	public List<TacGia_ThiGK> findAll() {
	    List<TacGia_ThiGK> list = new ArrayList<>();
	    String sql = "SELECT * FROM TacGia";
	    try (Connection con = DatabaseConnection_ThiGK.getConnection();
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	        	TacGia_ThiGK lop = new TacGia_ThiGK(rs.getInt("id"), rs.getString("ten_tacgia"));
	            list.add(lop);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}
	
	public TacGia_ThiGK findByID(int id) {
	    String sql = "SELECT * FROM TacGia WHERE id = ?";
	    try (Connection con = DatabaseConnection_ThiGK.getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new TacGia_ThiGK(rs.getInt("id"), rs.getString("ten_tacgia"));
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}

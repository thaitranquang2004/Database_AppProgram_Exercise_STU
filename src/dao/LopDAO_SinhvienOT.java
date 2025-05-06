package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Lop_SinhvienOT;
public class LopDAO_SinhvienOT {
	public List<Lop_SinhvienOT> findAll() {
	    List<Lop_SinhvienOT> list = new ArrayList<>();
	    String sql = "SELECT * FROM lop";
	    try (Connection con = DatabaseConnection_SinhvienOT.getConnection();
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {
	        while (rs.next()) {
	            Lop_SinhvienOT lop = new Lop_SinhvienOT(rs.getInt("id"), rs.getString("tenlop"));
	            list.add(lop);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

	public Lop_SinhvienOT findByID(int id) {
	    String sql = "SELECT * FROM lop WHERE id = ?";
	    try (Connection con = DatabaseConnection_SinhvienOT.getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return new Lop_SinhvienOT(rs.getInt("id"), rs.getString("tenlop"));
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}


}

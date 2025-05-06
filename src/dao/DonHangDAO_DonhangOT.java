package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DonHang_DonhangOT;

public class DonHangDAO_DonhangOT {
	public List<DonHang_DonhangOT> findAll() {
        List<DonHang_DonhangOT> list = new ArrayList<>();
        String sql = "SELECT * FROM DonHang";
        try (Connection con = DatabaseConnection_DonhangOT.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	DonHang_DonhangOT sv = new DonHang_DonhangOT(
                    rs.getInt("id"),
                    rs.getString("ma_donhang"),
                    rs.getDate("ngay_tao"),
                    rs.getFloat("tong_tien"),
                    rs.getInt("khachhang_id")
                );
                list.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	public DonHang_DonhangOT findByID(int id) {
	    String sql = "SELECT * FROM DonHang WHERE id = ?";
	    try (Connection con = DatabaseConnection_DonhangOT.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, id);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new DonHang_DonhangOT(
	                        rs.getInt("id"),
	                        rs.getString("ma_donhang"),
	                        rs.getDate("ngay_tao"),
	                        rs.getFloat("tong_tien"),
	                        rs.getInt("khachhang_id")
	                );
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null; 
	}
    public boolean insert(DonHang_DonhangOT sv) {
        String sql = "INSERT INTO DonHang (ma_donhang, ngay_tao, tong_tien,khachhang_id) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection_DonhangOT.getConnection();
             PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, sv.getMa_donhang());
            
            //java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(sv.getNgay_tao().getTime());

            ps.setDate(2,sqlDate);
            ps.setFloat(3, sv.getTong_tien());
            ps.setInt(4, sv.getKhachhang_id());
			int i=ps.executeUpdate();
			if(i>0) {
				ResultSet rs=ps.getGeneratedKeys();
				while(rs.next()) {
					int id=rs.getInt(1);
					sv.setId(id);
				}
				return true;
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(int id) {
        String sql = "DELETE FROM DonHang WHERE id = ?";
        try (Connection con = DatabaseConnection_DonhangOT.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(DonHang_DonhangOT sv) {
        String sql = "UPDATE DonHang SET ma_donhang = ?, ngay_tao = ?, tong_tien = ?, khachhang_id = ? WHERE id = ?";
        try (Connection con = DatabaseConnection_DonhangOT.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sv.getMa_donhang());
            
            java.sql.Date sqlDate = new java.sql.Date(sv.getNgay_tao().getTime());
            ps.setDate(2,sqlDate);
            
            ps.setFloat(3, sv.getTong_tien());
            ps.setInt(4, sv.getKhachhang_id());
            
            ps.setInt(5, sv.getId());
            
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}

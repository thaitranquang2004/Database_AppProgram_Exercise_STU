package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Sach_ThiGK;

public class SachDAO_ThiGK {
	public List<Sach_ThiGK> findAll() {
        List<Sach_ThiGK> list = new ArrayList<>();
        String sql = "SELECT * FROM Sach";
        try (Connection con = DatabaseConnection_ThiGK.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
            	Sach_ThiGK sv = new Sach_ThiGK(
                    rs.getInt("id"),
                    rs.getString("ten_sach"),
                    rs.getString("mo_ta"),
                    rs.getFloat("gia"),
                    rs.getInt("tacgia_id")
                );
                list.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public Sach_ThiGK findByID(int id) {
	    String sql = "SELECT * FROM Sach WHERE id = ?";
	    try (Connection con = DatabaseConnection_ThiGK.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, id);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new Sach_ThiGK(
	                        rs.getInt("id"),
	                        rs.getString("ten_sach"),
	                        rs.getString("mo_ta"),
	                        rs.getFloat("gia"),
	                        rs.getInt("tacgia_id")
	                );
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null; 
	}
	
    public boolean insert(Sach_ThiGK sv) {
        String sql = "INSERT INTO Sach (ten_sach, mo_ta, gia, tacgia_id) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection_ThiGK.getConnection();
             PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
        	
            ps.setString(1, sv.getTen_sach());
            ps.setString(2, sv.getMo_ta());
            ps.setFloat(3, sv.getGia());
            ps.setInt(4, sv.getTacgia_id());
                        
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
        String sql = "DELETE FROM Sach WHERE id = ?";
        try (Connection con = DatabaseConnection_ThiGK.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean update(Sach_ThiGK sv) {
        String sql = "UPDATE Sach SET ten_sach = ?, mo_ta = ?, gia = ?, tacgia_id = ? WHERE id = ?";
        try (Connection con = DatabaseConnection_ThiGK.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sv.getTen_sach());
            
            ps.setString(2, sv.getMo_ta());
            
            ps.setFloat(3, sv.getGia());
            ps.setInt(4, sv.getTacgia_id());
            
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

package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien_SinhvienOT;

public class SinhVienDAO_SinhvienOT {
	public List<SinhVien_SinhvienOT> findAll() {
        List<SinhVien_SinhvienOT> list = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien";
        try (Connection con = DatabaseConnection_SinhvienOT.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                SinhVien_SinhvienOT sv = new SinhVien_SinhvienOT(
                    rs.getInt("id"),
                    rs.getString("hoten"),
                    rs.getFloat("dtb"),
                    rs.getInt("malop")
                );
                list.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	public SinhVien_SinhvienOT findByID(int id) {
	    String sql = "SELECT * FROM sinhvien WHERE id = ?";
	    try (Connection con = DatabaseConnection_SinhvienOT.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setInt(1, id);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return new SinhVien_SinhvienOT(
	                    rs.getInt("id"),
	                    rs.getString("hoten"),
	                    rs.getFloat("dtb"),
	                    rs.getInt("malop")
	                );
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null; 
	}

    public boolean insert(SinhVien_SinhvienOT sv) {
        String sql = "INSERT INTO sinhvien (hoten, dtb, malop) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection_SinhvienOT.getConnection();
             PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, sv.getHoTen());
            ps.setFloat(2, sv.getDtb());
            ps.setInt(3, sv.getMaLop());
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
        String sql = "DELETE FROM sinhvien WHERE id = ?";
        try (Connection con = DatabaseConnection_SinhvienOT.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(SinhVien_SinhvienOT sv) {
        String sql = "UPDATE sinhvien SET hoten = ?, dtb = ?, malop = ? WHERE id = ?";
        try (Connection con = DatabaseConnection_SinhvienOT.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sv.getHoTen());
            ps.setFloat(2, sv.getDtb());
            ps.setInt(3, sv.getMaLop());
            ps.setInt(4, sv.getId());
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

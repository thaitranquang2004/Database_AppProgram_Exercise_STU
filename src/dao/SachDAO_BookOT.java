package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Sach_BookOT;
public class SachDAO_BookOT {
	// Lấy danh sách tất cả sách
    public List<Sach_BookOT> findAll() {
        List<Sach_BookOT> list = new ArrayList<>();
        String sql = "SELECT * FROM sach";
        try (Connection conn = DatabaseConnection_BookOT.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Sach_BookOT(rs.getString("maSach"), rs.getString("tenSach"), rs.getFloat("gia"), rs.getInt("maLoai")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm một cuốn sách mới
    public boolean insert(Sach_BookOT sach) {
        String sql = "INSERT INTO sach (maSach, tenSach, gia, maLoai) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection_BookOT.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sach.getMaSach());
            stmt.setString(2, sach.getTenSach());
            stmt.setFloat(3, sach.getGia());
            stmt.setInt(4, sach.getMaLoai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin cuốn sách
    public boolean update(Sach_BookOT sach) {
        String sql = "UPDATE sach SET tenSach = ?, gia = ?, maLoai = ? WHERE maSach = ?";
        try (Connection conn = DatabaseConnection_BookOT.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sach.getTenSach());
            stmt.setFloat(2, sach.getGia());
            stmt.setInt(3, sach.getMaLoai());
            stmt.setString(4, sach.getMaSach());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa một cuốn sách
    public boolean delete(String maSach) {
        String sql = "DELETE FROM sach WHERE maSach = ?";
        try (Connection conn = DatabaseConnection_BookOT.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maSach);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

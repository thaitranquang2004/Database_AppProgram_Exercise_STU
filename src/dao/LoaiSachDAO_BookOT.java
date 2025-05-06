package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.LoaiSach_BookOT;
public class LoaiSachDAO_BookOT {
	  // Lấy danh sách tất cả loại sách
    public List<LoaiSach_BookOT> findAll() {
        List<LoaiSach_BookOT> list = new ArrayList<>();
        String sql = "SELECT * FROM loaisach";
        try (Connection conn = DatabaseConnection_BookOT.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new LoaiSach_BookOT(rs.getInt("maLoai"), rs.getString("tenLoai")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
 // Lấy thông tin loại sách theo mã loại
    public LoaiSach_BookOT findByID(int maLoai) {
        LoaiSach_BookOT loaiSach = null;
        String sql = "SELECT * FROM loaisach WHERE maLoai = ?";
        try (Connection conn = DatabaseConnection_BookOT.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maLoai);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    loaiSach = new LoaiSach_BookOT(rs.getInt("maLoai"), rs.getString("tenLoai"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loaiSach;
    }

    // Thêm một loại sách mới
    public boolean insert(LoaiSach_BookOT loaiSach) {
        String sql = "INSERT INTO loaisach (tenLoai) VALUES (?)";
        try (Connection conn = DatabaseConnection_BookOT.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, loaiSach.getTenLoai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin loại sách
    public boolean update(LoaiSach_BookOT loaiSach) {
        String sql = "UPDATE loaisach SET tenLoai = ? WHERE maLoai = ?";
        try (Connection conn = DatabaseConnection_BookOT.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, loaiSach.getTenLoai());
            stmt.setInt(2, loaiSach.getMaLoai());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa một loại sách
    public boolean delete(int maLoai) {
        String sql = "DELETE FROM loaisach WHERE maLoai = ?";
        try (Connection conn = DatabaseConnection_BookOT.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maLoai);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

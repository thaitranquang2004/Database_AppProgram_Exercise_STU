package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.HinhTron;

public class HinhTronDAO {
	private final String DB_URL = "jdbc:mysql://localhost:3306/hinhtrontable?useSSL=false&serverTimezone=UTC";
	private final String USER = "root";
    private final String PASS = "";
	
	
	public boolean insertHinhTron(HinhTron hinhTron) {
        String query = "INSERT INTO hinhtron (bankinh) VALUES (?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, hinhTron.getR());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	public List<HinhTron> getAllHinhTron() {
        List<HinhTron> hinhTronList = new ArrayList<>();
        String query = "SELECT * FROM hinhtron";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                HinhTron hinhTron = new HinhTron(rs.getInt("id"), rs.getDouble("bankinh"));
                hinhTronList.add(hinhTron);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hinhTronList;
    }
	
	public boolean updateHinhTron(int id, double newBanKinh) {
        String query = "UPDATE hinhtron SET bankinh = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, newBanKinh);
            stmt.setInt(2, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa hình tròn
    public boolean deleteHinhTron(int id) {
        String query = "DELETE FROM hinhtron WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	public boolean themHinhTron(HinhTron hinhTron) {
		// TODO Auto-generated method stub
		return false;
	}

}
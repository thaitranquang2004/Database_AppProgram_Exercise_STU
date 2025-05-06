package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection_ThiGK {
	 private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
	    private static final String USER = "root";
	    private static final String PASSWORD = "";

	    public static Connection getConnection() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

}

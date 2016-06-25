package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	private final String url = "jdbc:mysql://127.0.0.1:3306/dormitory";
	private final String userName = "root";
	private final String password = "123456";
	private Connection conn = null;
	private Statement stmt = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public connection() {
		creatConn();
	}
	
	public boolean executeUpdate(String sql) {
		if (conn == null) {
			creatConn();
		}
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public ResultSet executeQuery(String sql) {
		ResultSet rs;
		try {
			if (conn == null) {
				creatConn();
			}
			stmt = conn.createStatement();
			try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
		return rs;
	}

	public boolean creatConn() {
		try {
			conn = DriverManager.getConnection(url, userName, password);
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	public void close() {
		try {
			if (stmt != null) {
				stmt.close();

			}
			if (conn != null) {
				conn.close();
			}
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}

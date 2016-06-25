package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import connection.connection;
import model.LoginModel;

public class LoginDao {
	private connection connection = null;

	public LoginDao() {
		connection = new connection();
	}

	public boolean loginIn(LoginModel loginModel) {
		String sql = "select * from stu_user where sid = '" + loginModel.getUsername() + "'";
		ResultSet rs = connection.executeQuery(sql);
		try {
			if (rs.next()) {
				if (rs.getString("sid").equals(loginModel.getUsername())
						&& rs.getString("password").equals(loginModel.getPassword())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean tloginIn(LoginModel loginModel) {
		String sql = "select * from tch_user where tid = '" + loginModel.getUsername() + "'";
		ResultSet rs = connection.executeQuery(sql);
		try {
			if (rs.next()) {
				if (rs.getString("tid").equals(loginModel.getUsername())
						&& rs.getString("pwd").equals(loginModel.getPassword())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean aloginIn(LoginModel loginModel) {
		String sql = "select * from admin_user where name = '" + loginModel.getUsername() + "'";
		ResultSet rs = connection.executeQuery(sql);
		try {
			if (rs.next()) {
				if (rs.getString("name").equals(loginModel.getUsername())
						&& rs.getString("pwd").equals(loginModel.getPassword())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}

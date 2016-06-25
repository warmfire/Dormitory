package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginModel;
import model.StudentModel;
import model.StudentUserModel;
import connection.connection;

public class RegisterDao {
	private connection connection = null;
	private PreparedStatement pstmt = null;
	private Connection conn = null;

	public RegisterDao() {
		connection = new connection();
	}
	
	public boolean Register(StudentUserModel stuUserModel) {
		try {
			String sql = "insert into stu_user(name,sid,password) values('"+stuUserModel.getName()+"','"+stuUserModel.getSid()+"','"+stuUserModel.getPassword()+"')";
			if(connection.executeUpdate(sql)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}

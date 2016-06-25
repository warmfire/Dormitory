package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginModel;
import connection.connection;

public class CPwdDao {
	private connection connection = null;

	public CPwdDao() {
		connection = new connection();
	}
	
	public boolean CheckPwd(String sid,String oldpwd){
		try {
			String pwd="";
			String sql = "select password from stu_user where sid='"+sid+"'";
			ResultSet rs = connection.executeQuery(sql);
			while(rs.next()){
				pwd = rs.getString(1);
				System.out.println(pwd);
			}
			if(oldpwd.equals(pwd)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;		
	}
	public boolean CPwdDao(String sid,String newpwd) {
		try {
			String sql = "update stu_user set password = '"+newpwd+"' where sid = '"+sid+"'";
			if(connection.executeUpdate(sql)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.connection;
import model.BaoxiuModel;
import model.StudentModel;
import model.StudentUserModel;

public class studentdao {

	/**
	 * ����Ĺ��ܣ�ʵ�ֱ�student����ɾ�Ĳ�ȹ��ܡ�
	 */

	private connection connection = null;

	public studentdao() {
		connection = new connection();
	}

	/**
	 * @param operation
	 *            �������ͣ�����ֵΪ���ӣ��޸ģ�ɾ��(1,2,3)
	 * @param model
	 *            ѧ���û����󣬶����е�����ֵ��ΪSQL���Ĳ�������
	 * @return �������ͣ���������ɹ����򷵻�true������false
	 * @see StudentModel
	 */
	public boolean operateStudent(int operation, StudentModel model) {
		boolean flag = false;
		String sql = null;
		if (operation == DaoOperatorMethod.RECORD_INSERT)
			sql = "insert into student(name,sex,date,beizhu,admin,sid,dmt_id) values('"+model.getName()+"','"+model.getSex()+
					"','"+model.getDate()+"','"+model.getBeizhu()+"','"+model.getAdmin()+"','"+model.getSid()+"','"+model.getDmt_id()+"')";
		if (operation == DaoOperatorMethod.RECORD_UPDATE)
			sql = "";
		if (operation == DaoOperatorMethod.RECORD_DELETE)
			sql = "";
		if (connection.executeUpdate(sql)) {
			flag = true;
		}
		connection.close();
		return flag;
	}

	/**
	 * ��ѯ����ѧ�����ϣ���List��ʽ���ء�
	 * 
	 * @return ����ѧ�����б�
	 * @see StudentModel
	 */
	public List<StudentModel> queryStudentList(String sid) {
		List<StudentModel> list = new ArrayList<StudentModel>();
		String sql = null;

		sql = "select * from student where sid = '"+sid+"'";

		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				StudentModel studentModel = new StudentModel();
				studentModel.setName(rs.getString(2));
				studentModel.setSex(rs.getString(3));
				studentModel.setDate(rs.getString(4));
				studentModel.setBeizhu(rs.getString(5));
				studentModel.setAdmin(rs.getString(6));
				studentModel.setSid(rs.getString(7));
				studentModel.setDmt_id(rs.getString(8));
				list.add(studentModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return list;
	}
	public List<StudentModel> querytStudentList() {
		List<StudentModel> list = new ArrayList<StudentModel>();
		String sql = null;

		sql = "select * from student";

		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				StudentModel studentModel = new StudentModel();
				studentModel.setName(rs.getString(2));
				studentModel.setSex(rs.getString(3));
				studentModel.setDate(rs.getString(4));
				studentModel.setBeizhu(rs.getString(5));
				studentModel.setAdmin(rs.getString(6));
				studentModel.setSid(rs.getString(7));
				studentModel.setDmt_id(rs.getString(8));
				list.add(studentModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return list;
	}
	public List<BaoxiuModel> queryBaoxiuList(String sid) {
		List<BaoxiuModel> list = new ArrayList<BaoxiuModel>();
		String sql = null;

		sql = "select * from baoxiu where dmt_id = (select dmt_id from student where sid='"+sid+"')";

		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				BaoxiuModel baoxiuModel = new BaoxiuModel();
				baoxiuModel.setDmt_id(rs.getString(2));
				baoxiuModel.setName(rs.getString(3));
				baoxiuModel.setXiangqing(rs.getString(4));
				baoxiuModel.setZhuangtai(rs.getString(5));
				list.add(baoxiuModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return list;
	}
	public List<BaoxiuModel> queryTBaoxiuList() {
		List<BaoxiuModel> list = new ArrayList<BaoxiuModel>();
		String sql = null;

		sql = "select * from baoxiu";

		ResultSet rs = connection.executeQuery(sql);
		try {
			while (rs.next()) {
				BaoxiuModel baoxiuModel = new BaoxiuModel();
				baoxiuModel.setId(rs.getInt(1));
				baoxiuModel.setDmt_id(rs.getString(2));
				baoxiuModel.setName(rs.getString(3));
				baoxiuModel.setXiangqing(rs.getString(4));
				baoxiuModel.setZhuangtai(rs.getString(5));
				list.add(baoxiuModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return list;
	}
	/**
	 * ����ĳ��idֵ���ҵ��ض�ѧ����
	 * 
	 * @param id
	 *            ѧ��id
	 * @return ĳ��ѧ������ӦstudentModel����
	 * @see StudentModel
	 */
	public StudentModel queryStudentModel(String id) {
		String sql = "select * from student where id= '" + id + "'";
		ResultSet rs = connection.executeQuery(sql);
		StudentModel studentModel = new StudentModel();;
		try {
			rs.next();
			studentModel.setName(rs.getString(1));
			studentModel.setSex(rs.getString(2));
			studentModel.setDate(rs.getString(3));
			studentModel.setBeizhu(rs.getString(4));
			studentModel.setAdmin(rs.getString(5));
			studentModel.setSid(rs.getString(6));
			studentModel.setDmt_id(rs.getString(7));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return studentModel;
	}
	
	public boolean baoxiu(BaoxiuModel baoxiuModel) {
		try {
			String sql = "insert into baoxiu(dmt_id,name,xiangqing,zhuangtai) values('"+baoxiuModel.getDmt_id()+"',"
					+ "'"+baoxiuModel.getName()+"','"+baoxiuModel.getXiangqing()+"','δ���')";
			if(connection.executeUpdate(sql)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean baoxiudelete(BaoxiuModel baoxiuModel) {
		try {
			String sql = "delete from baoxiu where id="+baoxiuModel.getId();
			if(connection.executeUpdate(sql)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean stuadd(StudentModel stuModel) {
		try {
			String name = selectteaname(stuModel.getAdmin());
			String sql = "insert into student(name,sex,date,beizhu,admin,sid,dmt_id) values('"+stuModel.getName()+"','"+stuModel.getSex()+"','"+stuModel.getDate()+"',"
					+ "'"+stuModel.getBeizhu()+"','"+name+"','"+stuModel.getSid()+"','"+stuModel.getDmt_id()+"')";
			if(connection.executeUpdate(sql)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	public String selectteaname(String str) {
		try {
			String sql = "select name from tch_user where tid = '"+str+"'";
			ResultSet rs = connection.executeQuery(sql);
			if(rs.next()) return rs.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean baoxiuModify(BaoxiuModel baoxiuModel) {
		try {
			String sql = "update baoxiu set dmt_id='"+baoxiuModel.getDmt_id()+"',name='"+baoxiuModel.getName()+"'"
					+ ",xiangqing='"+baoxiuModel.getXiangqing()+"',zhuangtai='"+baoxiuModel.getZhuangtai()+"' where id="+baoxiuModel.getId();
			if(connection.executeUpdate(sql)){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}

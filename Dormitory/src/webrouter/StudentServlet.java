package webrouter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CPwdDao;
import dao.studentdao;
import dao.LoginDao;
import dao.RegisterDao;
import model.BaoxiuModel;
import model.LoginModel;
import model.StudentModel;
import model.StudentUserModel;

public class StudentServlet extends HttpServlet{
	
	private String method;
	private String sid;
	private LoginModel loginModel = new LoginModel();
	private StudentModel sm = new StudentModel();
	private BaoxiuModel baoxiuModel = new BaoxiuModel();
	private StudentUserModel stuUserModel = new StudentUserModel();
	private LoginDao loginDao = new LoginDao();
	private RegisterDao rgstDao = new RegisterDao();
	private studentdao studentdao = new studentdao();
	private CPwdDao cpwdDao = new CPwdDao();
	/**
	 * 
	 */
	private static final long serialVersionUID = 2176228095000754725L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		method = request.getParameter("method");
		HttpSession session = request.getSession();
		if(method.equals("1")) {
			String shenfen = request.getParameter("shenfen");
			if("学生".equals(shenfen)){			
				loginModel.setUsername(request.getParameter("sid"));
				String sid = request.getParameter("sid");
				loginModel.setPassword(request.getParameter("password"));
				if(loginDao.loginIn(loginModel)) {
					session.setAttribute("isLogin", "1");
					out.print("<script>window.location.href=\"stuindex.jsp?sid=");
					out.print(request.getParameter("sid"));
					out.print("\";</script>");
				}
				else {
					out.print("<script>alert(\"Login Failed\");window.location.href=\"login.jsp\";</script>");
				}
			} 
			if("宿管".equals(shenfen)){			
				loginModel.setUsername(request.getParameter("sid"));
				String sid = request.getParameter("sid");
				loginModel.setPassword(request.getParameter("password"));
				if(loginDao.tloginIn(loginModel)) {
					session.setAttribute("isLogin", "1");
					out.print("<script>window.location.href=\"teaindex.jsp?tid=");
					out.print(request.getParameter("sid"));
					out.print("\";</script>");
				}
				else {
					out.print("<script>alert(\"Login Failed\");window.location.href=\"login.jsp\";</script>");
				}
			} 
			else {
				out.print("<script>alert(\"Login Failed\");window.location.href=\"login.jsp\";</script>");
			}
		}
		else if(method.equals("2")) {
			//修改密码
			String sid = request.getParameter("sid");
			String oldpwd = request.getParameter("oldpwd");
			String newpwd = request.getParameter("newpwd");
			if(cpwdDao.CheckPwd(sid, oldpwd)){
				if(cpwdDao.CPwdDao(sid, newpwd)){
					out.print("<script>alert(\"Change Password Success\");window.location.href=\"login.jsp?method=7\";</script>");
				}
				else{
					out.print("<script>alert(\"Change Password Failed\");window.location.href=\"login.jsp?method=7\";</script>");
				}				
			}
			else{
				out.print("<script>alert(\"Change Password Failed\");window.location.href=\"stuchangepwd.jsp?sid=");
				out.print(request.getParameter("sid"));
				out.print("\";</script>");
			}
		} 
		else if(method.equals("3")) {
			//注册
			String name = request.getParameter("name");
			String sid = request.getParameter("sid");
			String password = request.getParameter("password");
			stuUserModel.setName(name);
			stuUserModel.setSid(sid);
			stuUserModel.setPassword(password);
			if(name.equals("")||sid.equals("")||password.equals("")){
				out.print("<script>alert(\"Register Failed\");window.location.href=\"register.jsp\";</script>");
			}
			else{
				if(rgstDao.Register(stuUserModel)) {
					out.print("<script>alert(\"Register Success\");window.location.href=\"login.jsp\";</script>");
				}
				else{
					out.print("<script>alert(\"Register Failed\");window.location.href=\"register.jsp\";</script>");
				}
			}
		}else if(method.equals("4")) {
			//保修
			String dmt_id = request.getParameter("dmt_id");
			String name = request.getParameter("name");
			String xiangqing = request.getParameter("xiangqing");
			baoxiuModel.setName(name);
			baoxiuModel.setSid(sid);
			baoxiuModel.setDmt_id(dmt_id);
			baoxiuModel.setXiangqing(xiangqing);
			if(name.equals("")||xiangqing.equals("")||dmt_id.equals("")){
				out.print("<script>alert(\"Submit Failed\");window.location.href=\"stubaoxiu.jsp?sid=");
				out.print(request.getParameter("sid"));
				out.print("\";</script>");
			}
			else{
				if(studentdao.baoxiu(baoxiuModel)) {
					out.print("<script>alert(\"Submit Success\");window.location.href=\"stubaoxiu.jsp?sid=");
					out.print(request.getParameter("sid"));
					out.print("\";</script>");
				}
				else{
					out.print("<script>alert(\"Submit Failed\");window.location.href=\"stubaoxiu.jsp?sid=");
					out.print(request.getParameter("sid"));
					out.print("\";</script>");
				}
			}
		}else if(method.equals("5")) {
			//保修修改
			int id =Integer.parseInt(request.getParameter("id"));
			String dmt_id = request.getParameter("dmt_id");
			String name = request.getParameter("name");
			String xiangqing = request.getParameter("xiangqing");
			String zhuangtai = request.getParameter("zhuangtai");
			baoxiuModel.setId(id);
			baoxiuModel.setName(name);
			baoxiuModel.setDmt_id(dmt_id);
			baoxiuModel.setXiangqing(xiangqing);
			baoxiuModel.setZhuangtai(zhuangtai);
			if(name.equals("")||xiangqing.equals("")||dmt_id.equals("")||zhuangtai.equals("")){
				out.print("<script>alert(\"Submit Failed\");window.location.href=\"baoxiu.jsp?tid=");
				out.print(request.getParameter("tid"));
				out.print("\";</script>");
			}
			else{
				if(studentdao.baoxiuModify(baoxiuModel)) {
					out.print("<script>alert(\"Submit Success\");window.location.href=\"baoxiu.jsp?tid=");
				out.print(request.getParameter("tid"));
				out.print("\";</script>");
				}
				else{
					out.print("<script>alert(\"Submit Failed\");window.location.href=\"baoxiu.jsp?tid=");
				out.print(request.getParameter("tid"));
				out.print("\";</script>");
				}
			}
		}
		else if(method.equals("6")) {
			//保修删除
			int id =Integer.parseInt(request.getParameter("id"));
			baoxiuModel.setId(id);
			if(studentdao.baoxiudelete(baoxiuModel)) {
				out.print("<script>alert(\"Delete Success\");window.location.href=\"baoxiu.jsp?tid=");
				out.print(request.getParameter("tid"));
				out.print("\";</script>");
			}
			else{
				out.print("<script>alert(\"Delete Failed\");window.location.href=\"baoxiu.jsp?tid=");
				out.print(request.getParameter("tid"));
				out.print("\";</script>");
			}
		}else if(method.equals("7")) {
			session.setAttribute("isLogin", "2");
			response.sendRedirect("login.jsp");
		}
		else if(method.equals("8")) {
			//增加
			sm.setName(request.getParameter("name"));
			sm.setSex(request.getParameter("sex"));
			sm.setSid(request.getParameter("sid"));
			sm.setDate(request.getParameter("date"));
			sm.setBeizhu(request.getParameter("beizhu"));
			sm.setDmt_id(request.getParameter("dmt_id"));
			sm.setAdmin(request.getParameter("tid"));
			if(studentdao.stuadd(sm)) {
				out.print("<script>alert(\"Insert Success\");window.location.href=\"teaindex.jsp?tid=");
				out.print(request.getParameter("tid"));
				out.print("\";</script>");
			}
			else{
				out.print("<script>alert(\"Insert Failed\");window.location.href=\"teaadd.jsp?tid=");
				out.print(request.getParameter("tid"));
				out.print("\";</script>");
			}
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="model.StudentModel" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页 - 校园宿舍管理系统</title>
<link href="CSS/index.css" rel="stylesheet" type="text/css">
<jsp:useBean id="studentDao" class="dao.studentdao" scope="page"></jsp:useBean>
<%
	List<StudentModel> studentList = null;
	studentList = studentDao.querytStudentList();
%>
</head>

<body>
	<%
		if (session.getAttribute("isLogin").equals("2")) {
			response.sendRedirect("login.jsp");
		}
	%>
	<div id="index_list">
        <div><p align="center">校园宿舍管理系统</p></div>
        <a href="teaindex.jsp?tid=<%= request.getParameter("tid")%>"><div id="index_list_in"><p align="center">学生信息</p></div></a>
        <a href="baoxiu.jsp?tid=<%= request.getParameter("tid")%>"><div><p align="center">保修信息</p></div></a>
        <a href="StudentServlet?method=7"><div><p align="center">退出登录</p></div></a>
    </div>
    <div id="center">
    	<div id="title">
            <p align="center">我的信息</p>
        </div>
        <div id="table">
        	<a href="teaadd.jsp?tid=<%= request.getParameter("tid")%>"><p align="center" color="#FFFFFF">[新增学生信息]</p></a>
        	<table align="center" border="1" bordercolor="#CCCCCC" id="table_title">
                <tr bgcolor="#798ea2"  align="center">
                    <td width="150"><b>寝室号</b></td>   
                    <td width="150"><b>姓名</b></td>
                    <td width="150"><b>性别</b></td>
                    <td width="200"><b>日期</b></td>
                    <td width="309"><b>备注</b></td>
                    <td width="150"><b>登记人</b></td> 
                </tr>
                <%
					for (StudentModel student : studentList) {
				%>
		        <tr align="center">
		            <td><%=student.getDmt_id()%></td>
		            <td><%=student.getName()%></td>   
		            <td><%=student.getSex()%></td>
		            <td><%=student.getDate()%></td>
		            <td><%=student.getBeizhu()%></td>
		            <td><%=student.getAdmin()%></td> 
		        </tr>
		        <%
				}
				%>	
            </table>
            
        </div>
    </div>
</body>
<script>
	function js(id)
	{
		return document.getElementById(id).getElementsByTagName("div");
	}
	function delBackgroundColor()
	{
		for(var i=0;i<js("index_list").length;i++)
		{
			js("index_list")[i].style.background = '';
			js("index_list")[i].style.color = '#fff';
		}
	}
</script>
</html>
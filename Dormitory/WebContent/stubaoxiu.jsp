<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="model.BaoxiuModel" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我要报修 - 校园宿舍管理系统</title>
<link href="CSS/index.css" rel="stylesheet" type="text/css">
<jsp:useBean id="studentDao" class="dao.studentdao" scope="page"></jsp:useBean>
<%
	List<BaoxiuModel> baoxiuList = null;
	baoxiuList = studentDao.queryBaoxiuList(request.getParameter("sid"));
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
        <a href="stuindex.jsp?sid=<%= request.getParameter("sid")%>"><div><p align="center">我的信息</p></div></a>
        <a href="stuchangepwd.jsp?sid=<%= request.getParameter("sid")%>"><div><p align="center">修改密码</p></div></a>
        <a href="stubaoxiu.jsp?sid=<%= request.getParameter("sid")%>"><div id="index_list_in"><p align="center">我要保修</p></div></a>
        <a href="StudentServlet?method=7"><div><p align="center">退出登录</p></div></a>
    </div>
    <div id="center">
    	<div id="title">
            <p align="center">我要报修</p>
        </div>
        <div id="table">
        	<form action = "StudentServlet?method=4&sid=<%= request.getParameter("sid")%>" method = "post">
                <table  align = "center">
                <tr align = "center">
                    <td><p id="register_p1">寝室号：</p></td>
                    <td><input type = "text" name = "dmt_id"></td>
                </tr>
                <tr align = "center">
                    <td><p id="register_p1">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</p></td>
                    <td><input type = "text" name = "name"></td>
                </tr>
                <tr align = "center">
                    <td><p id="register_p1">详&nbsp;&nbsp;&nbsp;&nbsp;情：</p></td>
                    <td><input type = "text" name = "xiangqing"></td>
                </tr>
                <tr align = "center">
                    <td colspan="2">
                        <input type = "submit" id="submit" value="">
                        <input type = "reset" id="reset" value="">
                    </td>
                </tr>
            </table>
            
		</form>
		<table align="center" border="1" bordercolor="#CCCCCC" id="table_title">
                <tr bgcolor="#798ea2"  align="center">
                    <td width="150"><b>寝室号</b></td>   
                    <td width="150"><b>姓名</b></td>
                    <td width="150"><b>详情</b></td>
                    <td width="150"><b>状态</b></td>
                </tr>
                <%
					for (BaoxiuModel baoxiu : baoxiuList) {
				%>
		        <tr align="center">
		            <td><%=baoxiu.getDmt_id()%></td>
		            <td><%=baoxiu.getName()%></td>   
		            <td><%=baoxiu.getXiangqing()%></td>
		            <td><%=baoxiu.getZhuangtai()%></td>
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
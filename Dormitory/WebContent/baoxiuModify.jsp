<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="model.BaoxiuModel" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>报修信息 - 校园宿舍管理系统</title>
<link href="CSS/index.css" rel="stylesheet" type="text/css">
</head>
<jsp:useBean id="dbc" class="connection.connection" scope="page"></jsp:useBean>

<%
		String id = request.getParameter("id");
		String sql = "select * from baoxiu where id=" + id;
		ResultSet rs = dbc.executeQuery(sql);
		rs.next();
%>
<body>
	<%
		if (session.getAttribute("isLogin").equals("2")) {
			response.sendRedirect("login.jsp");
		}
	%>
	<div id="index_list">
        <div><p align="center">校园宿舍管理系统</p></div>
        <a href="teaindex.jsp?tid=<%= request.getParameter("tid")%>"><div><p align="center">学生信息</p></div></a>
        <a href="baoxiu.jsp?tid=<%= request.getParameter("tid")%>"><div id="index_list_in"><p align="center">保修信息</p></div></a>
        <a href="StudentServlet?method=7"><div><p align="center">退出登录</p></div></a>
    </div>
    <div id="center">
    	<div id="title">
            <p align="center">报修修改</p>
        </div>
        <div id="table">
        <form action = "StudentServlet?method=5&tid=<%= request.getParameter("tid")%>&id=<%=rs.getInt(1)%>" method = "post">
			<table align="center" border="1" bordercolor="#CCCCCC" id="baoxiu_table_title" width="250">
	                <tr bgcolor="#798ea2" align="center">
	                    <td width="100"><b>寝室号</b></td>
	                    <td width="150"><input type="text" name="dmt_id" value="<%=rs.getString(2)%>"/></td>
	                </tr>
			        <tr bgcolor="#798ea2"  align="center">
	                    <td width="100"><b>姓名</b></td>
	                    <td width="150"><input type="text" name="name" value="<%=rs.getString(3)%>"/></td>
	                </tr>
	                <tr bgcolor="#798ea2"  align="center">
	                    <td width="100"><b>详情</b></td>
	                    <td width="150"><input type="text" name="xiangqing" value="<%=rs.getString(4)%>"/></td>
	                </tr>
	                <tr bgcolor="#798ea2"  align="center">
	                    <td width="100"><b>状态</b></td>
	                    <td width="150"><input type="text" name="zhuangtai" value="<%=rs.getString(5)%>"/></td>
	                </tr>
	                <tr bgcolor="#798ea2"  align="center">
	                    <td colspan="2" align="center">
	                    	<input type="submit" name="button" id="submit" value="" /> 
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" name="button2" id="reset" value=""/>
						</td>
	                </tr>
	          </table>
         </form>
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
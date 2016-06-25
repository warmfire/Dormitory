<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ page import="model.BaoxiuModel" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我要报修 - 校园宿舍管理系统</title>
<link href="CSS/index.css" rel="stylesheet" type="text/css">
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
            <p align="center">添加信息</p>
        </div>
        <div id="table">
        	<form action = "StudentServlet?method=8&tid=<%= request.getParameter("tid")%>" method = "post">
                <table  align = "center">
                <tr align = "center">
                    <td><p id="register_p1">姓&nbsp;&nbsp;&nbsp;&nbsp;名：</p></td>
                    <td><input type = "text" name = "name"></td>
                </tr>
                <tr align = "center">
                    <td><p id="register_p1">学&nbsp;&nbsp;&nbsp;&nbsp;号：</p></td>
                    <td><input type = "text" name = "sid"></td>
                </tr>
                <tr align = "center">
                    <td><p id="register_p1">性&nbsp;&nbsp;&nbsp;&nbsp;别：</p></td>
                    <td><input type = "text" name = "sex"></td>
                </tr>
                <tr align = "center">
                    <td><p id="register_p1">时&nbsp;&nbsp;&nbsp;&nbsp;间：</p></td>
                    <td><input type = "text" name = "date"></td>
                </tr>
                <tr align = "center">
                    <td><p id="register_p1">寝室号：</p></td>
                    <td><input type = "text" name = "dmt_id"></td>
                </tr>
                <tr align = "center">
                    <td><p id="register_p1">备&nbsp;&nbsp;&nbsp;&nbsp;注：</p></td>
                    <td><input type = "text" name = "beizhu"></td>
                </tr>
                <tr align = "center">
                    <td colspan="2">
                        <input type = "submit" id="submit" value="">
                        <input type = "reset" id="reset" value="">
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
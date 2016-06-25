<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录 - 校园宿舍管理系统</title>
<link href="CSS/index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="index_loginbg">
    	<div id="index_login">
    	<form action = "StudentServlet?method=1" method = "post">
            <table  align = "center">
            	<tr>
                    <td align = "center"><p id="index_p1">身&nbsp;&nbsp;&nbsp;&nbsp;份：</p></td>
                    <td>
                    <select name="shenfen" width="100">
                        <option value ="学生">学生</option>
                        <option value ="宿管">宿管</option>
                    </select>
                    </td>
                </tr>
                <tr align = "center">
                    <td><p id="index_p1">学工号：</p></td>
                    <td><input type = "text" name="sid"></td>
                </tr>
                <tr align = "center">
                    <td><p id="index_p1">密&nbsp;&nbsp;&nbsp;&nbsp;码：</p></td>
                    <td><input type = "password" name = "password"></td>
                </tr>
                <tr align = "center">
                    <td colspan="2">
                        <input type = "submit" id="login" value="">
                        <a href="register.jsp"><div id="register"></div></a>
                    </td>
                </tr>
            </table>
		</form>
        </div>
    </div>
</body>
</html>
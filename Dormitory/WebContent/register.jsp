<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册 - 校园宿舍管理系统</title>
<link href="CSS/index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="index_loginbg">
    	<div id="index_login">
    	<form action = "StudentServlet?method=3" method = "post">
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
                    <td><p id="register_p1">密&nbsp;&nbsp;&nbsp;&nbsp;码：</p></td>
                    <td><input type = "password" name = "password"></td>
                </tr>
                <tr align = "center">
                    <td colspan="2">
                        <input type = "submit" id="register" value="">
                        <input type = "reset" id="reset" value="">
                    </td>
                </tr>
            </table>
		</form>
        </div>
    </div>
</body>
</html>
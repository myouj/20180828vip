<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<strong>${message}</strong>
	<form action="updatepassword.do" method="post">
		<p>
			<label>旧密码:<input name="oldPassword"></label>
		</p>
		<p>
			<label>新密码:<input name="newPassword"></label>
		</p>
		<p>
			<label>新密码确认:<input name="newPasswordConfirm"></label>
		</p>
		<p>
			<button type="submit">修改</button>
			<a href="welcome.do">返回</a>
		</p>
	</form>
</body>
</html>
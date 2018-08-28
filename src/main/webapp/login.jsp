<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath() %>/">
<title>xxx</title>
<script type="text/javascript">
	if (window.top !== window) {
		window.top.location.href = window.location.href;
	}
</script>
</head>
<body>
	<strong>${message}</strong>
	
	<form action="login.do" method="post">
		<p>
			<label>Account:<input name="account"></label>
		</p>
		<p>
			<label>Password:<input name="password"></label>
		</p>
		<p>
			<button type="submit">Login</button>
		</p>
	</form>
	 <%session.removeAttribute("message"); %> 
</body>
</html>
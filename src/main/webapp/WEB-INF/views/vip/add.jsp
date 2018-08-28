<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath() %>/">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>VIP客户录入</h1>
	</header>
	<main>
		<p>
			<strong>${message }</strong>
		</p>
		<form action="vip/add.do" method="post">
			<p>
				<label>*手机号:<input name="phone" placeholder="将作为VIP编号" value="${param.phone }"></label>
			</p>
			<p>
				<label>*姓名:<input name="name" value="${param.name }"></label>
			</p>
			<p>
				<label>*性别:</label>
				<label><input type="radio" name="sex" value="1" checked="checked">男</label>
				<label><input type="radio" name="sex" value="0" ${param.sex=='0'?'checked':'' }>女</label>
			</p>
			<p>
				<label>年龄:<input name="age" type="number" value="${param.age }"></label>
			</p>
			<p>
				<label>QQ:<input name="qq" value="${param.qq }"></label>
			</p>
			<p>
				<label>Email:<input name="email" value="${param.email }"></label>
			</p>
			<p>
				<label>邮编:<input name="zip" value="${param.zip }"></label>
			</p>
			<p>
				<label>邮寄地址:<input name="address" value="${param.address }"></label>
			</p>
			<p>
				<label>备注:<textarea rows="2" cols="20" name="remark">${param.remark }</textarea></label>
			</p>
			<p>
				<button type="submit">确定</button>
				<input type="reset" value="重置" >
				<a href="welcome.jsp">返回</a>
			</p>
		</form>
	</main>
</body>
</html>
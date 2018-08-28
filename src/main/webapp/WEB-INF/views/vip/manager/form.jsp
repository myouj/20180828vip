<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath()%>/">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>VIP客户信息详细</h1>
	</header>
	<main>
		
		<form action="vip/update.do" method="post">
			<p>
				<label>编号:  ${vip.id }
				<input type="hidden" name="id" value="${vip.id }"></label>
			</p>
			<p>
				<label>手机号:<input name=code value="${vip.code }"></label>
			</p>
			<p>
				<label>姓名:<input name="name" value="${vip.name }"></label>
			</p>
			<p>
				<label>性别:</label>
				<label><input type="radio" name="sex" value="1" checked="checked">男</label>
				<label><input type="radio" name="sex" value="0" ${vip.sex=='0'?'checked="checked"':'' }>女</label>
			</p>
			<p>
				<label>VIP等级:<input name="age" value="${vip.rank }" disabled="disabled"></label>
			</p>
			<p>
				<label>消费金额:<input name="age" value="${vip.amount }" disabled="disabled"></label>
			</p>
			<p>
				<label>年龄:<input name="age" type="number" value="${vip.age }"></label>
			</p>
			<p>
				<label>QQ:<input name="qq" value="${vip.qq }"></label>
			</p>
			<p>
				<label>Email:<input name="email" value="${vip.email }"></label>
			</p>
			<p>
				<label>邮编:<input name="zip" value="${vip.zip }"></label>
			</p>
			<p>
				<label>邮寄地址:<input name="address" value="${vip.address }"></label>
			</p>
			<p>
				<label>备注:<textarea rows="2" cols="20" name="remark">${vip.remark }</textarea></label>
			</p>
			<p>
				<button type="submit">修改</button>
				<a href="javascript:history.go(-1)">返回</a>
			</p>
		</form>
	</main>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath()%>/">
<title>Insert title here</title>
</head>
<body>
	<header>
		<h1>VIP消费录入</h1>
	</header>
	<main>
		<p>
			<strong>${message }</strong>
		</p>
		<form action="vip/addconsume.do" method="post">
			<p>
				<label>VIP编号:<input name="code" value="${param.phone }"></label>
			</p>
			<p>
				<label>订单号:<input name="orderno"></label>
			</p>
			<p>
				<label>消费金额:<input name="amount" type="number"></label>
			</p>
			<p>
				<label>备注:<textarea rows="2" cols="20" name="remark"></textarea></label>
			</p>
			<p>
				<button type="submit">添加</button>
				<button type="reset">重置</button>
			</p>
		</form>
	</main>
</body>
</html>
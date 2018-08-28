<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath()%>/">
<title>Insert title here</title>
</head>
<body>
	<header>
		<form action="vip/consume.do" method="post">
			<p>
				<label> VIP:<input name="code" autofocus>
				</label>
				<button type="submit">GO</button>
				请输入VIP电话号码
			</p>
		</form>
	</header>
	<main>
	<p>
		<strong>${message }</strong>
	</p>
	<table>
		<tr>
			<td>编号</td>
			<td>时间</td>
			<td>金额</td>
			<td>订单</td>
			<td>备注</td>
			<td>录入人</td>
		</tr>
		<c:forEach items="${consumes }" var="consume">
			<tr>
				<td><p>${consume.id }</p></td>
				<td><p>${consume.whens }</p></td>
				<td><p>${consume.amount }</p></td>
				<td><p>${consume.orderno }</p></td>
				<td><p>${consume.remark }</p></td>
				<td><p>${consume.operator }</p></td>
			</tr>
		</c:forEach>
	</table>
	</main>
</body>
</html>
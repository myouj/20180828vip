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
		<form action="vip/manager.do" method="post">
			<p>
				<label> VIP:<input name="code" autofocus>
				</label>
				<button type="submit">查询</button>
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
			<td>订单号</td>
			<td>消费金额</td>
			<td>操作人</td>
			<td>备注</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${consumes }" var="consume">
			<tr>
				<td><p>${consume.id }</p></td>
				<td><p>${consume.whens }</p></td>
				<td><p>${consume.orderno }</p></td>
				<td><p>${consume.amount }</p></td>
				<td><p>${consume.operator }</p></td>
				<td><p>${consume.remark }</p></td>
				<c:if test="${consume.flag != '1' }">
					<td>
						<form action="vip/updateflag.do">
							<input type="hidden" name="id" value="${consume.id }">
							<input type="hidden" name="vipid" value="${consume.vipid }">
							<button type="submit">作废</button>
						</form>
					</td>
				</c:if>
				<c:if test="${consume.flag != '0' }">
					<td>已作废</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	</main>
</body>
</html>
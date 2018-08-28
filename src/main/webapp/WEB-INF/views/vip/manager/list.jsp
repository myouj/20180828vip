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
		<form action="vip/list.do" method="post">
			<p>
				<label> VIP:<input name="value" autofocus>
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
			<td>操作</td>
			<td>姓名</td>
			<td>VIP等级</td>
		</tr>
		<c:forEach items="${vips }" var="vip">
			<tr>
				<td><p>${vip.id }</p></td>
				<td>
					<p>
					<form action="vip/form.do" method="post">
						<input type="hidden" name="id" value="${vip.id }">
						<button type="submit">修改/查看</button>
					</form>
					</p>
				</td>
				<td><p>${vip.name }</p></td>
				<td><p>${vip.rank }</p></td>
			</tr>
		</c:forEach>
	</table>
	</main>
</body>
</html>
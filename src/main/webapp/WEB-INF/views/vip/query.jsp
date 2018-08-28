<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=request.getContextPath() %>/">
<title>Insert title here</title>
</head>
<body>
	<header>
		<strong>${message }</strong>
		<form action="vip/query.do" method="post">
			<p>
				<label>
					VIP:<input name="code" autofocus>
				</label>
				<button type="submit">GO</button>请输入VIP电话号码
			</p>
		</form>
	</header>
	
	<main>
		<c:if test="${vip != null }">
		<article>
			<p>
				<span>
					编号:<b>${vip.code }</b>
				</span>
				<span>
					VIP等级:<b>${vip.rank}</b>
				</span>
				<span>
					目前消费总金额:<b>￥${vip.amount}元</b>
				</span>
			</p>
			<p>
				<span>
					姓名:<b>${vip.name}</b>
				</span>
				<span>
					性别:<b>${vip.sex}</b>
				</span>
				<span>
					年龄:<b>${vip.age}</b>
				</span>
			</p>
			<p>
				<span>
					QQ:<b>${vip.qq}</b>
				</span>
				<span>
					Email:<b>${vip.email}</b>
				</span>
				<span>
					邮寄地址/邮编:<b>${vip.address}/${vip.zip}</b>
				</span>
			</p>
			<p>
				<span>
					备注:<b>${vip.remark }</b>
				</span>
			</p>
		</article>
		</c:if>
	</main>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>

	<style type="text/css">
		menu,h1,ul{
			margin: 0;
		}
		html,body{
			margin:0;
			height: 100%;
			font-size: 14px;
		}
		body>header{
			line-height: 80px;
			text-align: center;
			background: #999
		}
		body>header>h1{
			display: inline;
			text-align: center;
		}
		.body{
			position: absolute;
			top:80px;
			bottom: 0;
			width:100%;
		}
		.body>menu{
			position:absolute;
			left:0;
			width:200px;
			height: 100%;
			background: #eee;
			box-sizing: border-box;
		}
		.body>main{
			margin-left:200px;
			height: 100%;
			display: block;
		}
		main>iframe{
			height: 100%;
			width: 100%;
			border:0;
			display: block;
		}
		
		
		
	</style>

</head>
<body>

	<header>
		<h1>海大超市</h1>
		<span> <b>${sessionScope.currentUser.name }</b>
		
		<a href="logout.do">退出</a>
		</span>
	</header>
	<section class="body">
		<menu>
			<ul>
				<li><a href="vip/query.do" target="mainFrame">VIP客户查询</a></li>
				<li><a href="vip/add.do" target="mainFrame">VIP客户录入</a></li>
				<li><a href="vip/list.do" target="mainFrame">VIP客户管理</a></li>
				<li><a href="vip/consume.do" target="mainFrame">VIP消费记录</a></li>
				<li><a href="vip/addconsume.do" target="mainFrame">VIP消费录入</a></li>
				<li><a href="vip/manager.do" target="mainFrame">VIP消费管理</a></li>
				<li><a href="updatepassword.do" target="mainFrame">修改密码</a></li>
			</ul>
		</menu>
		<main> 
			<iframe src="welcome.do" name="mainFrame"></iframe>
		</main>
	</section>



</body>
</html>
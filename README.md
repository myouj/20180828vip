# 20180828vip
框架：SSM（Spring，SpringMVC，MyBaties）<br>
数据库：MySQL<br>
服务器：tomcat<br><br>
用springmvc的拦截器来查看用户session是否存在<br>
继承ContextLoadListener监听器，使用自定义的监听器启动，这样在IoC容器初始化的时候，可以添加一些内容，例如一些保存在数据库中，但不会改变的东西，在没有采用缓存工具的情况下，可以减少对数据库的访问<br>

需求分析：<br>
1.登陆<br>
2.修改密码<br>
3.客户信息查询<br>
4.客户信息录入<br>
5.客户信息管理<br>
6.消费记录录入<br>
7.消费记录查询<br>
8.消费记录管理<br>



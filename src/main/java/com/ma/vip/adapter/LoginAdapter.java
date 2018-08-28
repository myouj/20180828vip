package com.ma.vip.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ma.vip.entity.User;

/*
 * 检测用户session是否失效，用户是否登陆
 */
public class LoginAdapter extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		User user = (User) request.getSession().getAttribute("currentUser");
		/*
		 * 用户不存在，返回登陆界面
		 */
		if(user == null){
			response.sendRedirect("redirect:/login.jsp");
			request.setAttribute("message", "请先登陆!");
			return false;
		}
		
		return super.preHandle(request, response, handler);
	}

}

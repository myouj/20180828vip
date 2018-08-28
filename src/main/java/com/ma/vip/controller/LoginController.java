package com.ma.vip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ma.common.ThisSystemException;
import com.ma.vip.entity.User;
import com.ma.vip.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	/*
	 * 登陆
	 */
	@RequestMapping("/login.do")
	public String login(String account, String password, HttpServletRequest request){
		System.out.println(account + ", " + password);
		try {
			User user = userService.login(account, password);
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", user);
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			return "forward:login.jsp";
		}
		
		return "redirect:/index.do";
	}
	
	@RequestMapping("/welcome.do")
	public String welcome(){
		return "welcome";
	}
	
	@RequestMapping("/index.do")
	public String index(){
		return "index";
	}
	
	/*
	 * 退出登陆
	 */
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		//让session失效
		session.invalidate();
		return "redirect:/login.jsp";
	}
	
	/**
	 * @param oldPassword
	 * @param newPassword
	 * @param newPasswordConfirm
	 * @param request
	 * @return
	 * @throws Exception 
	 * TODO:修改密码
	 */
	@RequestMapping(path="/updatepassword.do", method=RequestMethod.POST)
	public String updatePassword(String oldPassword, String newPassword, 
			String newPasswordConfirm, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");
		try {
			userService.updatePassword(user.getId(), oldPassword, newPassword, newPasswordConfirm);
		} catch (ThisSystemException e) {
			request.setAttribute("message", e.getMessage());
			return "updatepassword";
		}
		session.setAttribute("message", "修改成功，请重新登陆");
		return "redirect:/login.jsp";
	}
	
	/**
	 * @return 
	 * TODO:修改密码页面跳转
	 */
	@RequestMapping(path="/updatepassword.do", method=RequestMethod.GET)
	public String updatePasswordView(){
		
		return "updatepassword";
	}
	
	
}

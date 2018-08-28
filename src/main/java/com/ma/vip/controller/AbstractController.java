package com.ma.vip.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ma.vip.entity.Rank;
import com.ma.vip.entity.User;

public abstract class AbstractController {
	
	/*
	 * 获取IOC容器启动时加载的Rank(VIP等级)信息
	 */
	@SuppressWarnings("unchecked")
	public Rank getRank(HttpServletRequest request, int no){
		Map<Integer, Rank> rankMap = 
				(Map<Integer, Rank>) request.getServletContext().getAttribute("RANKS-MAP");
		
		return rankMap.get(no);
	}
	
	/*
	 * 获取IOC容器启动时加载的User(用户)信息
	 */
	@SuppressWarnings("unchecked")
	public User getUser(HttpServletRequest request, String id){
		Map<String, User> userMap = 
				(Map<String, User>) request.getServletContext().getAttribute("USERS-MAP");
		return userMap.get(id);
	}

}

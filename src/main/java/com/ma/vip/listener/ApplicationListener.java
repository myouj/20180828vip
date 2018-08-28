package com.ma.vip.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ma.vip.dao.RankDao;
import com.ma.vip.dao.UserDao;
import com.ma.vip.entity.Rank;
import com.ma.vip.entity.User;

/** 
 * @ClassName: ApplicationListener 
 * @Description: TODO 继承ContextLoaderListener类的listener,用于加载IoC容器,添加用户和vip等级信息
 * @author: youj
 * @date: 2018年8月20日 下午8:21:30  
 */
public class ApplicationListener extends ContextLoaderListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		super.contextDestroyed(event);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ServletContext sc = event.getServletContext();
		//加载系统数据
		this.initVipRank(sc);
		this.initSystemUser(sc);
	}
	
	/**
	 * @param sc 
	 * TODO:获取vip等级信息
	 */
	private void initVipRank(ServletContext sc){
		//获取IoC容器
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		RankDao rankDao = ac.getBean(RankDao.class);
		List<Rank> ranks = rankDao.selectAll();
		
		Map<Integer, Rank> ranksMap = new HashMap<>();
		
		for (Rank rank : ranks) {
			ranksMap.put(rank.getNo(), rank);
		}
		
		sc.setAttribute("RANKS-MAP", ranksMap);
		
	}
	
	/**
	 * @param sc 
	 * TODO:获取用户信息
	 */
	private void initSystemUser(ServletContext sc){
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		UserDao userDao = ac.getBean(UserDao.class);
		List<User> users = userDao.selectAll();
		Map<String, User> usersMap = new HashMap<>();
		
		for (User user : users) {
			usersMap.put(user.getId(), user);
		}
		sc.setAttribute("USERS-MAP", usersMap);
		
	}

}

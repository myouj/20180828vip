package com.ma.vip.service;

import org.springframework.transaction.annotation.Transactional;

import com.ma.vip.entity.User;

public interface UserService {
	/*
	 * 登陆
	 */
	public User login(String account, String password) throws Exception;
	
	/*
	 * 修改密码
	 */
	@Transactional
	public User updatePassword(String id, String oldPassword, 
			String newPassword, String newPasswordConfirm) throws Exception;
	
	/**
	 * @param id
	 * @return
	 * @throws Exception 
	 * TODO:通过id信息获取用户信息
	 */
	public String findNameById(String id) throws Exception;

}

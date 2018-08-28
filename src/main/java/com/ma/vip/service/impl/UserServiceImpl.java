package com.ma.vip.service.impl;

import static com.ma.common.AssertThrowUtil.*;
import static com.ma.common.ToolsUtil.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.common.ThisSystemException;
import com.ma.vip.dao.UserDao;
import com.ma.vip.entity.User;
import com.ma.vip.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User login(String account, String password) throws Exception {
		
		$("账号不能为空!", account);
		$("密码不能为空!", password);
		User user = userDao.select("account", account);
		if(user == null){
			throw new ThisSystemException("帐户不存在!");
		}
		password = md5(password);
		if(!user.getPassword().equals(password)){
			throw new ThisSystemException("密码错误!");
		}
		
		return user;
	}

	@Override
	public User updatePassword(String id, String oldPassword, String newPassword,
			String newPasswordConfirm) throws Exception {
		//1.验证参数
		$("id不能为空", id);
		$("旧密码必须填写", oldPassword);
		$("新密码必须填写", newPassword);
		$("密码确认必须填写", newPasswordConfirm);
		assertNotEquals("新旧密码不能相等", oldPassword, newPassword);
		assertEquals("两次密码不一致", newPassword, newPasswordConfirm);
		//2.找到用户
		User user = userDao.select("id", id);
		/*if(user == null){
			throw new ThisSystemException("无法找到用户");
		}*/
		assertNotNull("无法找到用户", user);
		
		//3.验证旧密码
		oldPassword = md5(oldPassword);
		/*if(user.getPassword().equals(oldPassword)){
			throw new ThisSystemException("旧密码错误");
		}*/
		assertEquals("旧密码错误", user.getPassword(), oldPassword);
		
		
		//4.更新密码
		newPassword = md5(newPassword);
		user.setPassword(newPassword);
		userDao.update(user);
		return user;
	}

	
	@Override
	public String findNameById(String id) throws Exception {
		User user = userDao.select("id", id);
		return user.getId();
	}

	
	
	

}

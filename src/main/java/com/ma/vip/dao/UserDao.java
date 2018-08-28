package com.ma.vip.dao;

import java.util.List;

import com.ma.common.BaseDao;
import com.ma.vip.entity.User;

public interface UserDao extends BaseDao<User> {
	
	/**
	 * @return 
	 * TODO:查询所有用户信息
	 */
	public List<User> selectAll();

}

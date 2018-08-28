package com.ma.vip.dao;

import java.util.List;

import com.ma.vip.entity.Rank;

public interface RankDao {
	
	/**
	 * @return 
	 * TODO:查询所有rank信息
	 */
	public List<Rank> selectAll();
	
}

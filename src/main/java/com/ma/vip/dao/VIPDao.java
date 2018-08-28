package com.ma.vip.dao;

import org.apache.ibatis.annotations.Param;

import com.ma.common.BaseDao;
import com.ma.vip.entity.VIP;

public interface VIPDao extends BaseDao<VIP> {
	
	/**
	 * @param key
	 * @param value
	 * @param amount 
	 * TODO:更新消费金额amount
	 */
	public void updateAmount(@Param("key") String key, 
			@Param("value")String value, @Param("amount") int amount);
	
	/**
	 * @param key
	 * @param value
	 * @param rank 
	 * TODO:更新vip等级
	 */
	public void updateRank(@Param("key") String key, 
			@Param("value")String value, @Param("rank") int rank);

}

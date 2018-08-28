package com.ma.vip.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ma.common.BaseDao;
import com.ma.vip.entity.Consume;

public interface ConsumeDao extends BaseDao<Consume> {
	
	/**
	 * @param vipid
	 * @return 
	 * TODO:通过vipid找到consume(消费信息)
	 */
	public List<Consume> findConsumeByVipId(String vipid);
	
	/**
	 * @param code
	 * @param consume 
	 * TODO:通过vip code(vip编号)插入vip的消费记录
	 */
	public void insertConsumeWithVipCode(@Param("code")String code, @Param("consume") Consume consume);
	
	/**
	 * @param code
	 * @return 通过vip code查找vip消费信息
	 * TODO:
	 */
	public List<Consume> selectConsumeByVipCode(String code);
	
	/**
	 * @param id 
	 * TODO:作废消费信息，更新flag
	 */
	public void updateFlag(String id);
	
	
}

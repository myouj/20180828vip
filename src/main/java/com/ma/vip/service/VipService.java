package com.ma.vip.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ma.vip.controller.ao.VipAo;
import com.ma.vip.entity.VIP;

public interface VipService {
	
	/*
	 * 通过code查询
	 */
	public VIP queryVipByCode(String code) throws Exception;
	
	/*
	 * VIP录入
	 */
	@Transactional
	public VIP addVip(VipAo vipao)throws Exception;
	
	/*
	 * 模糊查询
	 */
	public List<VIP> findFaint(String value)throws Exception;
	
	/*
	 * 通过id查询
	 */
	public VIP findVipById(String id) throws Exception;
	
	/*
	 * 更新vip信息
	 */
	@Transactional
	public void updateVip(VIP vip )throws Exception;
	
	/*
	 * 增加消费金额
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateVipAmount(String key, String code, int amount)throws Exception;
	
	/*
	 * 更新VIP等级
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateRank(String key, String code)throws Exception;
	
	

}

package com.ma.vip.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ma.vip.entity.Consume;

public interface ConsumeService {
	
	/**
	 * @param code
	 * @return
	 * @throws Exception 
	 * TODO:通过vip code信息获取消费信息
	 */
	public List<Consume> findConsumeByVipCode(String code)throws Exception;
	
	/**
	 * @param code
	 * @param consume
	 * @throws Exception 
	 * TODO:插入消费信息
	 */
	@Transactional
	public void insertConsume(String code, Consume consume)throws Exception;
	
	/**
	 * @param code
	 * @return
	 * @throws Exception 
	 * TODO:通过vip code信息获取消费信息
	 */
	public List<Consume> selectConsumeByVipCode(String code)throws Exception;
	
	/*
	 * 作废消费数据
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public Consume updateFlag(String id)throws Exception;

}

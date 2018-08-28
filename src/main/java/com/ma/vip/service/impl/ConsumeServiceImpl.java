package com.ma.vip.service.impl;

import static com.ma.common.AssertThrowUtil.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.common.ThisSystemException;
import com.ma.vip.dao.ConsumeDao;
import com.ma.vip.dao.VIPDao;
import com.ma.vip.entity.Consume;
import com.ma.vip.entity.VIP;
import com.ma.vip.service.ConsumeService;

@Service
public class ConsumeServiceImpl implements ConsumeService {
	
	@Autowired
	private ConsumeDao consumeDao;
	
	@Autowired
	private VIPDao vipDao;
	

	
	@Override
	public List<Consume> findConsumeByVipCode(String code) throws Exception {
			$("必须输入手机号码!", code);
			assertMatchPattern("请输入正确的手机号码!", 
					"^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$", code);
			assertTrue("不存在该用户!", vipDao.isExists("code", code));
			VIP vip = vipDao.select("code", code);
			List<Consume> consumes = (List<Consume>) consumeDao.findConsumeByVipId(vip.getId());
		return consumes;
	}


	@Override
	public void insertConsume(String code, Consume consume) throws Exception {
		$("必须输入手机号码!", code);
		$("必须输入订单号!", consume.getOrderno());
		if(consume.getAmount() <= 0){
			throw new ThisSystemException("请输入正确的金额!");
		}
		assertTrue("不存在该用户!", vipDao.isExists("code", code));
		consumeDao.insertConsumeWithVipCode(code, consume);
	}


	@Override
	public List<Consume> selectConsumeByVipCode(String code) throws Exception {
		$("必须输入VIP编号!", code);
		assertTrue("不存在该用户!", vipDao.isExists("code", code));
		List<Consume> consumes = consumeDao.selectConsumeByVipCode(code);
		assertListNotNull("没有消费记录", consumes);
		return consumes;
	}


	@Override
	public Consume updateFlag(String id) throws Exception {
		consumeDao.updateFlag(id);
		Consume consume = consumeDao.select("id", id);
		return consume;
	}
	
	
	
	

}

package com.ma.vip.service.impl;

import static com.ma.common.AssertThrowUtil.$;
import static com.ma.common.AssertThrowUtil.assertFalse;
import static com.ma.common.AssertThrowUtil.assertMatchPattern;
import static com.ma.common.AssertThrowUtil.assertNotNull;
import static com.ma.common.ToolsUtil.parseInt;
import static com.ma.common.ToolsUtil.uuid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.common.AssertThrowUtil;
import com.ma.vip.controller.ao.VipAo;
import com.ma.vip.dao.VIPDao;
import com.ma.vip.entity.VIP;
import com.ma.vip.service.VipService;

@Service
public class VipServiceImpl implements VipService {
	
	@Autowired
	private VIPDao vipDao;
	
	/*
	 * 通过code查询vip信息
	 * (non-Javadoc)
	 * @see com.ma.vip.service.VipService#queryVipByCode(java.lang.String)
	 */
	@Override
	public VIP queryVipByCode(String code) throws Exception {
		//1.验证参数
		$("vip账号必须填写", code);
		
		//2.业务处理
		VIP vip = vipDao.select("code", code);
		assertNotNull("未找到" + code + "用户", vip);
		
		//3.封装结果
		return vip;
	}

	/*
	 * 添加vip信息
	 * (non-Javadoc)
	 * @see com.ma.vip.service.VipService#addVip(com.ma.vip.controller.ao.VipAo)
	 */
	@Override
	public VIP addVip(VipAo vipao) throws Exception {
		//1.验证参数
		if(vipao == null){
			throw new IllegalArgumentException("ao不能为空");
		}
		$("手机必须填写!", vipao.getPhone());
		$("名字必须填写!", vipao.getName());
		//验证手机号是否合法
		assertMatchPattern("手机号码不合法!", 
				"^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\\d{8}$", vipao.getPhone());
		//验证手机号码是否已存在
		assertFalse("手机号码已存在!", vipDao.isExists("code", vipao.getPhone()));
		//验证名字是否合法
		assertMatchPattern("姓名不合法!", 
				"[\u4e00-\u9fa5]{2,}", vipao.getName());
		//验证性别
		boolean male = "1".equals(vipao.getSex());
		
		int age = parseInt(vipao.getAge(), 0);
		
		//2.业务处理
		VIP vip = new VIP();
		
		
		vip.setId(uuid());
		vip.setAddress(vipao.getAddress());
		vip.setAge(age);
		vip.setCode(vipao.getPhone());
		vip.setEmail(vipao.getEmail());
		vip.setName(vipao.getName());
		vip.setQq(vipao.getQq());
		vip.setSex(male);
		vip.setZip(vipao.getZip());
		vip.setAmount(0);
		vip.setRank(0);
		vip.setRemark(vipao.getRemark());

		vipDao.insert(vip);
		//3.封装结果
		return vip;
	}

	@Override
	public List<VIP> findFaint(String value) throws Exception {
		value = "%" + value + "%";
		List<VIP> vips = vipDao.selectLike(value);
		AssertThrowUtil.assertListNotNull("找不到相关用户!", vips);
		return vips;
	}

	@Override
	public VIP findVipById(String id) throws Exception {
		VIP vip = vipDao.select("id", id);
		return vip;
	}

	@Override
	public void updateVip(VIP vip) throws Exception {
		try {
			vipDao.update(vip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateVipAmount(String key, String code, int amount) throws Exception {
		try {
			vipDao.updateAmount(key, code, amount);
			System.out.println("haha");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRank(String key, String value) throws Exception {
		VIP vip = vipDao.select(key, value);
		System.out.println(vip);
		int amount = vip.getAmount() / 100;
		int rank;
		if(amount >= 0 && amount < 100){ 
			rank = 0;
		}else if(amount >= 100 && amount < 1000){
			rank = 1;
		}else if(amount >= 1000 && amount < 5000){
			rank = 2;
		}else if(amount >= 5000 && amount < 10000){
			rank = 3;
		}else if(amount >= 10000 && amount < 20000){
			rank = 4;
		}else{
			rank = 5;
		}
		vipDao.updateRank("id", value, rank);
		
	}

	
	
	
	
}


package com.ma.vip.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ma.common.ThisSystemException;
import com.ma.common.ToolsUtil;
import com.ma.vip.controller.vo.ConsumeVo;
import com.ma.vip.entity.Consume;
import com.ma.vip.entity.User;
import com.ma.vip.service.ConsumeService;
import com.ma.vip.service.VipService;

@Controller
public class ConsumeController extends AbstractController {
	
	@Autowired
	private ConsumeService consumeService;
	
	@Autowired
	private VipService vipService;
	
	/*
	 * 处理页面跳转
	 */
	@RequestMapping(path="vip/consume.do", method=RequestMethod.GET)
	public String consumePage(){
		return "vip/manager/consume";
	}
	
	/*
	 * 查询消费信息
	 */
	@RequestMapping(path="vip/consume.do", method=RequestMethod.POST)
	public String consume(String code,HttpServletRequest request) throws Exception{
		try {
			//获取消费信息
			List<Consume> consumes = consumeService.findConsumeByVipCode(code);
			//包装消费信息
			List<ConsumeVo> consumevos = new ArrayList<>();
			for (Consume consume : consumes) {
				ConsumeVo consumevo = new ConsumeVo();
				//数据库是以分为单位存储的，需要转化成元为单位
				consumevo.setAmount(String.valueOf(consume.getAmount() / 100.0));
				consumevo.setId(consume.getId());
				//从IoC容器中获取对应的User信息
				consumevo.setOperator(this.getUser(request, consume.getOperatorId()).getName());
				consumevo.setOrderno(consume.getOrderno());
				consumevo.setRemark(consume.getRemark());
				consumevo.setWhens(consume.getWhens());
				consumevos.add(consumevo);
			}
			request.setAttribute("consumes", consumevos);
			
		} catch (ThisSystemException e) {
			request.setAttribute("message", e.getMessage());
		}
		
		return "vip/manager/consume";
	}
	
	/*
	 * 跳转消费信息添加页面
	 */
	@RequestMapping(path="vip/addconsume.do", method=RequestMethod.GET)
	public String addConsumePage(){
		return "vip/manager/addConsume";
	}
	
	
	/**
	 * @param code
	 * @param orderno
	 * @param amount
	 * @param remark
	 * @param request
	 * @return
	 * @throws Exception 
	 * TODO:添加消费信息
	 */
	@RequestMapping(path="vip/addconsume.do", method=RequestMethod.POST)
	@Transactional
	public String addConsume(@RequestParam("code")String code, @RequestParam("orderno")String orderno,
			@RequestParam(value="amount", defaultValue="0")String amount, @RequestParam("remark")String remark,
			HttpServletRequest request) throws Exception{
		try {
			Consume consume = new Consume();
			int count = (int)Double.parseDouble(amount)*100;
			consume.setAmount(count);
			consume.setFlag("0");
			consume.setId(ToolsUtil.uuid());
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("currentUser");
			consume.setOperatorId(user.getId());
			consume.setOrderno(orderno);
			consume.setRemark(remark);
			consumeService.insertConsume(code, consume);
			vipService.updateVipAmount("code", code, count);
			vipService.updateRank("code", code);
			
			request.setAttribute("message", "录入成功!");
			
		} catch (ThisSystemException e) {
			request.setAttribute("message", e.getMessage());
		}
		
		return "vip/manager/addConsume";
	}
	
	/**
	 * @return 
	 * TODO:用于manager页面的跳转
	 */
	@RequestMapping(path="vip/manager.do", method=RequestMethod.GET)
	public String managerPage(){
		return "vip/manager/manager";
	}
	
	/**
	 * @param code
	 * @param request
	 * @return
	 * @throws Exception 
	 * TODO:通过code(vip编号)获得消费信息
	 */
	@RequestMapping(path="vip/manager.do", method=RequestMethod.POST)
	public String manager(String code, HttpServletRequest request) throws Exception{
		try {
			List<Consume> consumes = consumeService.selectConsumeByVipCode(code);
			List<ConsumeVo> consumevos = new ArrayList<>();
			for (Consume consume : consumes) {
				ConsumeVo consumevo = new ConsumeVo();
				consumevo.setAmount(String.valueOf(consume.getAmount() / 100.0));
				consumevo.setFlag(consume.getFlag());
				consumevo.setId(consume.getId());
				consumevo.setOperator(this.getUser(request, consume.getOperatorId()).getName());
				consumevo.setOrderno(consume.getOrderno());
				consumevo.setRemark(consume.getRemark());
				consumevo.setWhens(consume.getWhens());
				consumevo.setVipid(code);
				consumevos.add(consumevo);
			}
			request.setAttribute("consumes", consumevos);
		} catch (ThisSystemException e) {
			request.setAttribute("message", e.getMessage());
		}
		return "vip/manager/manager";
	}
	
	/**
	 * @param id
	 * @param vipid
	 * @param request
	 * @return
	 * @throws Exception 
	 * TODO:作废消费信息，更新消费金额和vip等级
	 */
	@RequestMapping("vip/updateflag.do")
	@Transactional
	public String updateFlag(String id, String vipid, HttpServletRequest request) throws Exception{
		Consume consume = consumeService.updateFlag(id);
		vipService.updateVipAmount("id",consume.getVipId(), -consume.getAmount());
		vipService.updateRank("id", consume.getVipId());
		return manager(vipid, request);
	}

}

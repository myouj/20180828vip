package com.ma.vip.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ma.common.ThisSystemException;
import com.ma.vip.controller.ao.VipAo;
import com.ma.vip.controller.vo.VipVo;
import com.ma.vip.entity.VIP;
import com.ma.vip.service.VipService;

@Controller
public class VipController extends AbstractController {
	
	@Autowired
	private VipService vipService;
	
	/**
	 * @return
	 * @throws Exception 
	 * TODO:vip查询页面跳转
	 */
	@RequestMapping(path="vip/query.do", method=RequestMethod.GET)
	public String queryPage() throws Exception{
		return "vip/query";
	}
	
	/**
	 * @param code
	 * @param request
	 * @return
	 * @throws Exception 
	 * TODO:vip查询
	 */
	@RequestMapping(value="vip/query.do", method=RequestMethod.POST)
	public String query(String code, HttpServletRequest request) throws Exception{
		System.out.println(code);
		try {
			VIP vip = vipService.queryVipByCode(code);
			VipVo vipvo = new VipVo();
			vipvo.setCode(vip.getCode());
			vipvo.setName(vip.getName());
			vipvo.setAddress(vip.getAddress());
			vipvo.setAge(String.valueOf(vip.getAge()));
			vipvo.setAmount(String.valueOf(vip.getAmount() / 100.0));
			vipvo.setEmail(vip.getEmail());
			vipvo.setQq(vip.getQq());
			//通过rank的id获取rank的详细信息
			vipvo.setRank(this.getRank(request, vip.getRank()).getName());
			vipvo.setRemark(vip.getRemark());
			vipvo.setSex(vip.isSex() ? "男" : "女");
			vipvo.setZip(vip.getZip());
			request.setAttribute("vip", vipvo);
		} catch (ThisSystemException e) {
			request.setAttribute("message", e.getMessage());
		}
		return "vip/query";
	}
	
	/**
	 * @return 
	 * TODO:vip录入页面跳转
	 */
	@RequestMapping(path="vip/add.do", method=RequestMethod.GET)
	public String addPage(){
		return "vip/add";
	}
	
	/**
	 * @param vipao
	 * @param request
	 * @return
	 * @throws Exception 
	 * TODO:添加vip
	 */
	@SuppressWarnings("unused")
	@RequestMapping(path="vip/add.do", method=RequestMethod.POST)
	public String addVip(VipAo vipao, HttpServletRequest request) throws Exception{
		try {
			VIP vip = vipService.addVip(vipao);
			request.setAttribute("message", "录入成功!");
			return "vip/manager/addConsume";
		} catch (ThisSystemException e) {
			request.setAttribute("message", e.getMessage());
		}
		
		return "vip/add";
	}
	
	/**
	 * @return 
	 * TODO:vip列表页面跳转
	 */
	@RequestMapping(path="vip/list.do", method=RequestMethod.GET)
	public String listPage(){
		return "vip/manager/list";
	}
	
	/**
	 * @param value
	 * @param request
	 * @return
	 * @throws Exception 
	 * TODO:获取vip信息，模糊查询
	 */
	@RequestMapping(path="vip/list.do", method=RequestMethod.POST)
	public String list(String value, HttpServletRequest request) throws Exception{
		try {
			List<VIP> vips = vipService.findFaint(value);
			List<VipVo> vipvos = new ArrayList<>();
			
			for (VIP vip : vips) {
				VipVo vipvo = new VipVo();
				vipvo.setId(vip.getId());
				vipvo.setName(vip.getName());
				vipvo.setRank(this.getRank(request, vip.getRank()).getName());
				vipvos.add(vipvo);
			}
			
			request.setAttribute("vips", vipvos);
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
		}
		return "vip/manager/list";
	}
	
	/**
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception 
	 * TODO:获取vip的详细信息
	 */
	@RequestMapping(value="vip/form.do", method=RequestMethod.POST)
	public String form(String id, HttpServletRequest request) throws Exception{
		VIP vip = vipService.findVipById(id);
		
		request.setAttribute("vip", vip);
		return "vip/manager/form";
	}
	
	
	/**
	 * @param vip
	 * @param request
	 * @return
	 * @throws Exception 
	 * TODO:更新vip信息
	 */
	@RequestMapping(value="vip/update.do", method=RequestMethod.POST)
	public String update(VIP vip, HttpServletRequest request) throws Exception{
		vipService.updateVip(vip);
		request.setAttribute("message", "修改成功!");
		return "vip/manager/list";
	}
	
}

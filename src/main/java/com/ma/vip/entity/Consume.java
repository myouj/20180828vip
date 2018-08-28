package com.ma.vip.entity;

/** 
 * @ClassName: Consume 
 * @Description: TODO 消费账单的实体
 * @author: youj
 * @date: 2018年8月20日 下午8:20:27  
 */
public class Consume {

	private String id;
	private String vipId;
	private String whens;
	private String orderno;
	private int amount;
	private String operatorId;
	private String remark;
	private String flag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVipId() {
		return vipId;
	}

	public void setVipId(String vipId) {
		this.vipId = vipId;
	}

	public String getWhens() {
		return whens;
	}

	public void setWhens(String whens) {
		this.whens = whens;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}

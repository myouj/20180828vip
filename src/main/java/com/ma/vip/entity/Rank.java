package com.ma.vip.entity;

/** 
 * @ClassName: Rank 
 * @Description: TODO vip等级的实体
 * @author: youj
 * @date: 2018年8月20日 下午8:20:54  
 */
public class Rank {

	private int no;
	private String name;
	private int needAmount;
	private int discount;
	private String remark;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNeedAmount() {
		return needAmount;
	}

	public void setNeedAmount(int needAmount) {
		this.needAmount = needAmount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

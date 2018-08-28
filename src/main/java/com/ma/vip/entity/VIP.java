package com.ma.vip.entity;

/** 
 * @ClassName: VIP 
 * @Description: TODO vip实体类
 * @author: youj
 * @date: 2018年8月20日 下午8:21:19  
 */
public class VIP {

	private String id;
	private String code;
	private String name;
	private boolean sex;
	private int age;
	private String qq;
	private String email;
	private String address;
	private String zip;
	private String remark;
	private int rank;
	private int amount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "VIP [id=" + id + ", code=" + code + ", name=" + name + ", sex="
				+ sex + ", age=" + age + ", qq=" + qq + ", email=" + email
				+ ", address=" + address + ", zip=" + zip + ", remark="
				+ remark + ", rank=" + rank + ", amount=" + amount + "]";
	}

	

}

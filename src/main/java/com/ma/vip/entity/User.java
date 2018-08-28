package com.ma.vip.entity;

/** 
 * @ClassName: User 
 * @Description: TODO 用户实体类
 * @author: youj
 * @date: 2018年8月20日 下午8:21:08  
 */
public class User {
	private String id;
	private String account;
	private String password;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password="
				+ password + ", name=" + name + "]";
	}
	
	

}

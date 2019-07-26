package com.zhangchao.bean;

public class User {

	private Integer id;
	private String userName;
	private String loginAcct;
	private String userPswd;
	private String email;
	private String createTime;
	

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", loginAcct=" + loginAcct + ", userPswd=" + userPswd
				+ ", email=" + email + ", createTime=" + createTime + "]";
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginAcct() {
		return loginAcct;
	}
	public void setLoginAcct(String loginAcct) {
		this.loginAcct = loginAcct;
	}
	public String getUserPswd() {
		return userPswd;
	}
	public void setUserPswd(String userPswd) {
		this.userPswd = userPswd;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}

package com.xyh.wechat.web.model.pub;

import com.xyh.wechat.web.model.BaseModel;

public class LoginModel extends BaseModel {
	private String username = null;	
	private String password = null;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
			
}

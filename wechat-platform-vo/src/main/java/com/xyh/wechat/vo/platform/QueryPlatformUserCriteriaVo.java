package com.xyh.wechat.vo.platform;

import com.xyh.wechat.vo.QueryCriteriaBaseVo;

public class QueryPlatformUserCriteriaVo extends QueryCriteriaBaseVo {
	private String username;

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
}

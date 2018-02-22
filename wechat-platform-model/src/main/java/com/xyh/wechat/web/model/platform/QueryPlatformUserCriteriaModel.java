package com.xyh.wechat.web.model.platform;

import java.util.List;

import com.xyh.wechat.vo.platform.PlatformUserVo;
import com.xyh.wechat.web.model.QueryCriteriaBaseModel;

public class QueryPlatformUserCriteriaModel extends QueryCriteriaBaseModel {
	private String username = null;
	List<PlatformUserVo> userlist = null;

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
	
	public List<PlatformUserVo> getUserlist() {
		return userlist;
	}
	
	public void setUserlist(List<PlatformUserVo> userlist) {
		this.userlist = userlist;
	}
}

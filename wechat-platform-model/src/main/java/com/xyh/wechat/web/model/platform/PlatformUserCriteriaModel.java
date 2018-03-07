package com.xyh.wechat.web.model.platform;

import java.util.List;

import com.xyh.wechat.vo.platform.PlatformUserVo;
import com.xyh.wechat.web.model.CriteriaBaseModel;

public class PlatformUserCriteriaModel extends CriteriaBaseModel {
	private String username;
	private boolean disabledIncluded;
	private boolean deletedIncluded;
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

	/**
	 * @return the disabledIncluded
	 */
	public boolean isDisabledIncluded() {
		return disabledIncluded;
	}

	/**
	 * @param disabledIncluded the disabledIncluded to set
	 */
	public void setDisabledIncluded(boolean disabledIncluded) {
		this.disabledIncluded = disabledIncluded;
	}

	/**
	 * @return the deletedIncluded
	 */
	public boolean isDeletedIncluded() {
		return deletedIncluded;
	}

	/**
	 * @param deletedIncluded the deletedIncluded to set
	 */
	public void setDeletedIncluded(boolean deletedIncluded) {
		this.deletedIncluded = deletedIncluded;
	}
}

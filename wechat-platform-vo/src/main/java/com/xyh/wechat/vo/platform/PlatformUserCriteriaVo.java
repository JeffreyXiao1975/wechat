package com.xyh.wechat.vo.platform;

import com.xyh.wechat.vo.QueryCriteriaBaseVo;

public class PlatformUserCriteriaVo extends QueryCriteriaBaseVo {
	private String username;
	private boolean disabledIncluded;
	private boolean deletedIncluded;

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

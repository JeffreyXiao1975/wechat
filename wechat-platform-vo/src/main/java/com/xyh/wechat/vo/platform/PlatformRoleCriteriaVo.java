package com.xyh.wechat.vo.platform;

import com.xyh.wechat.vo.QueryCriteriaBaseVo;

public class PlatformRoleCriteriaVo extends QueryCriteriaBaseVo {
	private String rolename;
	private boolean disabledIncluded;
	private boolean deletedIncluded;

	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
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
}

package com.xyh.wechat.vo.platform;

import com.xyh.wechat.vo.BaseEntityVo;

public class PlatformRoleVo extends BaseEntityVo {
	private String rolename;
	private String roledesc;
	private boolean disabled;
	private boolean deleted;
	
	/**
	 * @return the disabled
	 */
	public boolean isDisabled() {
		return disabled;
	}
	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
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
	 * @return the roledesc
	 */
	public String getRoledesc() {
		return roledesc;
	}
	/**
	 * @param roledesc the roledesc to set
	 */
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}
}

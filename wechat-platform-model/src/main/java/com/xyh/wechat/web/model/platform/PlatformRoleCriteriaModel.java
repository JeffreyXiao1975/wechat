package com.xyh.wechat.web.model.platform;

import java.util.List;

import com.xyh.wechat.vo.platform.PlatformRoleVo;
import com.xyh.wechat.web.model.CriteriaBaseModel;

public class PlatformRoleCriteriaModel extends CriteriaBaseModel {
	private String rolename;
	private boolean disabledIncluded;
	private boolean deletedIncluded;
	List<PlatformRoleVo> rolelist = null;
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
		
	public List<PlatformRoleVo> getRolelist() {
		return rolelist;
	}
	
	public void setRolelist(List<PlatformRoleVo> rolelist) {
		this.rolelist = rolelist;
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

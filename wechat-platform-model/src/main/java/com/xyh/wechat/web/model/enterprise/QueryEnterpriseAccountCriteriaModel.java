package com.xyh.wechat.web.model.enterprise;

import java.util.List;

import com.xyh.wechat.vo.enterprise.EnterpriseAccountVo;

public class QueryEnterpriseAccountCriteriaModel {
	private boolean disabled;
	private boolean deleted;
	private List<EnterpriseAccountVo> enterpriseAccountList = null;
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
	 * @return the enterpriseAccountList
	 */
	public List<EnterpriseAccountVo> getEnterpriseAccountList() {
		return enterpriseAccountList;
	}
	/**
	 * @param enterpriseAccountList the enterpriseAccountList to set
	 */
	public void setEnterpriseAccountList(List<EnterpriseAccountVo> enterpriseAccountList) {
		this.enterpriseAccountList = enterpriseAccountList;
	}
}

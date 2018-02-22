package com.xyh.wechat.web.model.enterprise;

import java.util.List;

import com.xyh.wechat.vo.enterprise.EnterpriseSubaccountVo;

public class QueryEnterpriseSubaccountCriteriaModel {
	private boolean disabled;
	private boolean deleted;
	private List<EnterpriseSubaccountVo> enterpriseSubaccountList = null;
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
	 * @return the enterpriseSubaccountList
	 */
	public List<EnterpriseSubaccountVo> getEnterpriseSubaccountList() {
		return enterpriseSubaccountList;
	}
	/**
	 * @param enterpriseSubaccountList the enterpriseSubaccountList to set
	 */
	public void setEnterpriseSubaccountList(List<EnterpriseSubaccountVo> enterpriseSubaccountList) {
		this.enterpriseSubaccountList = enterpriseSubaccountList;
	}
}

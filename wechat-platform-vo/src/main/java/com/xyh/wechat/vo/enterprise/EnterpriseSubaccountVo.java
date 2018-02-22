package com.xyh.wechat.vo.enterprise;

import com.xyh.wechat.vo.BaseEntityVo;

public class EnterpriseSubaccountVo extends BaseEntityVo {
	private String subaccountName;
	private String subaccountDesc;
	private boolean disabled;
	private boolean deleted;
	private EnterpriseAccountVo parentAccount;
	/**
	 * @return the subaccountName
	 */
	public String getSubaccountName() {
		return subaccountName;
	}
	/**
	 * @param subaccountName the subaccountName to set
	 */
	public void setSubaccountName(String subaccountName) {
		this.subaccountName = subaccountName;
	}
	/**
	 * @return the subaccountDesc
	 */
	public String getSubaccountDesc() {
		return subaccountDesc;
	}
	/**
	 * @param subaccountDesc the subaccountDesc to set
	 */
	public void setSubaccountDesc(String subaccountDesc) {
		this.subaccountDesc = subaccountDesc;
	}
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
	 * @return the parentAccount
	 */
	public EnterpriseAccountVo getParentAccount() {
		return parentAccount;
	}
	/**
	 * @param parentAccount the parentAccount to set
	 */
	public void setParentAccount(EnterpriseAccountVo parentAccount) {
		this.parentAccount = parentAccount;
	}
}

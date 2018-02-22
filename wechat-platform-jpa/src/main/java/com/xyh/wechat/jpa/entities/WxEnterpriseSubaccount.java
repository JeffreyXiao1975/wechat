package com.xyh.wechat.jpa.entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="WX_ENTERPRISE_SUBACCOUNT")
public class WxEnterpriseSubaccount extends WxBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3065628471630481134L;

	@Id
	@Column(name="subaccount_id")
	private long subaccountId;
	
	//optional=false：可选，false表示必须存在，true表示此对象可以没有
    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = false)
    @JoinColumn(name = "enterprise_account_id")
    private WxEnterpriseAccount parentAccount;
	
	@Column(name="subaccount_name")
	private String subaccountName;
	
	@Column(name="subaccount_desc")
	private String subaccountDesc;
	
	@Column(name="is_disabled")
	private boolean disabled;
	
	@Column(name="is_deleted")
	private boolean deleted;
	
	@Column(name="created_time", insertable=false, updatable=false)
	private Timestamp createdTime;
	
	@Column(name="updated_time", insertable=false)
	private Timestamp updatedTime;
	
	public WxEnterpriseSubaccount() {}
	
	public long getSubaccountId() {
		return this.subaccountId;
	}
	
	public void setSubaccountId(long subaccountId) {
		this.subaccountId = subaccountId;
	}
	
	public WxEnterpriseAccount getParentAccount() {
		return this.parentAccount;
	}
	
	public void setParentAccount(WxEnterpriseAccount parentAccount) {
		this.parentAccount = parentAccount;
	}
	
	public String getSubaccountName () {
		return this.subaccountName;
	}
	
	public void setSubaccountName (String subaccountName) {
		this.subaccountName = subaccountName;
	}
	
	public boolean isDisabled() {
		return disabled;
	}
	
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getUpdatedTime() {
		return createdTime;
	}
	
	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
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
}

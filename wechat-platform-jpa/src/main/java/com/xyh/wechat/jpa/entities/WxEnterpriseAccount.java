package com.xyh.wechat.jpa.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="WX_ENTERPRISE_ACCOUNT")
public class WxEnterpriseAccount extends WxBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4660489448678187262L;

	@Id
	@Column(name="enterprise_account_id")
	private long accountId;
	
	//optional=false：可选，false表示必须存在，true表示此对象可以没有
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE }, optional = false)
    @JoinColumn(name = "legal_entity_id")
    private WxPlatformLegalEntity legalEntity;
	
	@Column(name="enterprise_account_name")
	private String accountName;
	
	@Column(name="enterprise_account_desc")
	private String accountDesc;
	
	@Column(name="is_disabled")
	private boolean disabled;
	
	@Column(name="is_deleted")
	private boolean deleted;
	
	@Column(name="created_time", insertable=false, updatable=false)
	private Timestamp createdTime;
	
	@Column(name="updated_time", insertable=false)
	private Timestamp updatedTime;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentAccount")
	private Set<WxEnterpriseSubaccount> subaccounts = new HashSet<WxEnterpriseSubaccount>();
	
	public WxEnterpriseAccount() {}
	
	public long getAccountId() {
		return this.accountId;
	}
	
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountName () {
		return this.accountName;
	}
	
	public void setAccountName (String accountName) {
		this.accountName = accountName;
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
	
	public Set<WxEnterpriseSubaccount> getSubaccounts() {
		return this.subaccounts;
	}
	
	public void setSubaccounts(Set<WxEnterpriseSubaccount> subaccounts) {
		this.subaccounts = subaccounts;
	}

	/**
	 * @return the accountDesc
	 */
	public String getAccountDesc() {
		return accountDesc;
	}

	/**
	 * @param accountDesc the accountDesc to set
	 */
	public void setAccountDesc(String accountDesc) {
		this.accountDesc = accountDesc;
	}

	/**
	 * @return the legalEntity
	 */
	public WxPlatformLegalEntity getLegalEntity() {
		return legalEntity;
	}

	/**
	 * @param legalEntity the legalEntity to set
	 */
	public void setLegalEntity(WxPlatformLegalEntity legalEntity) {
		this.legalEntity = legalEntity;
	}
}

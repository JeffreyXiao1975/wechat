package com.xyh.wechat.jpa.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="WX_PLATFORM_LEGAL_ENTITY")
public class WxPlatformLegalEntity extends WxBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8232386751278182349L;

	@Id
	@Column(name="legal_entity_id")
	private long legalEntityId;
	
	@Column(name="legal_entity_name_cn")
	private String legalEntityNameCN;
	
	@Column(name="legal_entity_name_en")
	private String legalEntityNameEN;
	
	@Column(name="is_disabled")
	private boolean disabled;
	
	@Column(name="is_deleted")
	private boolean deleted;
	
	@Column(name="created_time", insertable=false, updatable=false)
	private Timestamp createdTime;
	
	@Column(name="updated_time", insertable=false)
	private Timestamp updatedTime;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy ="legalEntity")
	private Set<WxEnterpriseAccount> enterpriseAccounts = new HashSet<WxEnterpriseAccount>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy ="legalEntity")
	private Set<WxServiceAccount> serviceAccounts = new HashSet<WxServiceAccount>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy ="legalEntity")
	private Set<WxSubscriptionAccount> subscriptionAccounts = new HashSet<WxSubscriptionAccount>();

	/**
	 * @return the legalEntityId
	 */
	public long getLegalEntityId() {
		return legalEntityId;
	}

	/**
	 * @param legalEntityId the legalEntityId to set
	 */
	public void setLegalEntityId(long legalEntityId) {
		this.legalEntityId = legalEntityId;
	}

	/**
	 * @return the legalEntityNameCN
	 */
	public String getLegalEntityNameCN() {
		return legalEntityNameCN;
	}

	/**
	 * @param legalEntityNameCN the legalEntityNameCN to set
	 */
	public void setLegalEntityNameCN(String legalEntityNameCN) {
		this.legalEntityNameCN = legalEntityNameCN;
	}

	/**
	 * @return the legalEntityNameEN
	 */
	public String getLegalEntityNameEN() {
		return legalEntityNameEN;
	}

	/**
	 * @param legalEntityNameEN the legalEntityNameEN to set
	 */
	public void setLegalEntityNameEN(String legalEntityNameEN) {
		this.legalEntityNameEN = legalEntityNameEN;
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
	 * @return the createdTime
	 */
	public Timestamp getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the updatedTime
	 */
	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	/**
	 * @param updatedTime the updatedTime to set
	 */
	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}

	/**
	 * @return the enterpriseAccounts
	 */
	public Set<WxEnterpriseAccount> getEnterpriseAccounts() {
		return enterpriseAccounts;
	}

	/**
	 * @param enterpriseAccounts the enterpriseAccounts to set
	 */
	public void setEnterpriseAccounts(Set<WxEnterpriseAccount> enterpriseAccounts) {
		this.enterpriseAccounts = enterpriseAccounts;
	}

	/**
	 * @return the serviceAccounts
	 */
	public Set<WxServiceAccount> getServiceAccounts() {
		return serviceAccounts;
	}

	/**
	 * @param serviceAccounts the serviceAccounts to set
	 */
	public void setServiceAccounts(Set<WxServiceAccount> serviceAccounts) {
		this.serviceAccounts = serviceAccounts;
	}

	/**
	 * @return the subscriptionAccounts
	 */
	public Set<WxSubscriptionAccount> getSubscriptionAccounts() {
		return subscriptionAccounts;
	}

	/**
	 * @param subscriptionAccounts the subscriptionAccounts to set
	 */
	public void setSubscriptionAccounts(Set<WxSubscriptionAccount> subscriptionAccounts) {
		this.subscriptionAccounts = subscriptionAccounts;
	}
}

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="WX_PLATFORM_ADGROUP")
public class WxPlatformADGroup extends WxBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3644030748293604347L;

	@Id
	@Column(name="adgroup_id")
	private long adgroupId;
	
	@Column(name="adgroup_name")
	private String adgroupname;
	
	@Column(name="created_time", insertable=false, updatable=false)
	private Timestamp createdTime;
	
	@Column(name="updated_time", insertable=false)
	private Timestamp updatedTime;
	
	@JoinTable(name="WX_ADGROUP_ROLE_MAPPING", //ָ���м��ı���
			joinColumns={@JoinColumn(name="adgroup_id", //ָ��������������м���������ֶ�����
				referencedColumnName="adgroup_id")},  //ָ�������������ʲô
			inverseJoinColumns={@JoinColumn(name="role_id",//��������һ���ĺ��壬ָ������һ�����������м�������
				referencedColumnName="role_id")} //ָ������һ�����������ʲô
			)
	@ManyToMany(fetch=FetchType.LAZY)
	private Set<WxPlatformRole> roles = new HashSet<WxPlatformRole>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "adgroup")
	private Set<WxPlatformADGroupUser> adgroupUsers = new HashSet<WxPlatformADGroupUser>();
	
	public WxPlatformADGroup() {}
	
	/**
	 * @return the userId
	 */
	public long getAdgroupId() {
		return adgroupId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setAdgroupId(long adgroupId) {
		this.adgroupId = adgroupId;
	}
	/**
	 * @return the username
	 */
	public String getAdgroupname() {
		return adgroupname;
	}
	/**
	 * @param username the username to set
	 */
	public void setAdgroupname(String adgroupname) {
		this.adgroupname = adgroupname;
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
	 * @return the roles
	 */	
	public Set<WxPlatformRole> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<WxPlatformRole> roles) {
		this.roles = roles;
	}
}

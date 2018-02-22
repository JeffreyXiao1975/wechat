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
@Table(name="WX_PLATFORM_ADGROUP_USER")
public class WxPlatformADGroupUser extends WxBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5507223435851333003L;

	@Id
	@Column(name="adgroup_user_id")
	private long adgroupUserId;
	
	@Column(name="user_name")
	private String username;
	
	@Column(name="created_time", insertable=false, updatable=false)
	private Timestamp createdTime;
	
	@Column(name="updated_time", insertable=false)
	private Timestamp updatedTime;
	
	//optional=false：可选，false表示必须存在，true表示此对象可以没有
    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = false)
    @JoinColumn(name = "adgroup_id")
	private WxPlatformADGroup adgroup;
    
    public long getAdgroupUserId() {
		return adgroupUserId;
	}
	
	public void setAdgroupUserId(long adgroupUserId) {
		this.adgroupUserId = adgroupUserId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the adgroup
	 */
	public WxPlatformADGroup getAdgroup() {
		return adgroup;
	}

	/**
	 * @param adgroups the adgroups to set
	 */
	public void setAdgroups(WxPlatformADGroup adgroup) {
		this.adgroup = adgroup;
	}
}

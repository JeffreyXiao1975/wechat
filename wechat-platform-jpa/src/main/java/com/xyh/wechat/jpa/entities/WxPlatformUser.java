package com.xyh.wechat.jpa.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="WX_PLATFORM_USER")
public class WxPlatformUser extends WxBaseEntity {
	private static final long serialVersionUID = -2147758006210822579L;
	
	@Id
	@Column(name="user_id")
	private long userId;
	
	@Column(name="user_name")
	private String username;
	
	@Column(name="user_password")
	private String password;
	
	@Column(name="is_disabled")
	private boolean disabled;
	
	@Column(name="is_deleted")
	private boolean deleted;
	
	@Column(name="created_time", insertable=false, updatable=false)
	private Timestamp createdTime;
	
	@Column(name="updated_time", insertable=false)
	private Timestamp updatedTime;
	
	@JoinTable(name="WX_USER_ROLE_MAPPING", //指定中间表的表名
			joinColumns={@JoinColumn(name="user_id", //指定本类的主键在中间表的外键的字段名称
				referencedColumnName="user_id")},  //指定本类的主键是什么
			inverseJoinColumns={@JoinColumn(name="role_id",//和上面是一样的含义，指明另外一个类主键在中间表的名称
				referencedColumnName="role_id")} //指定另外一个类的主键是什么
			)
	@ManyToMany(fetch=FetchType.LAZY)
	private Set<WxPlatformRole> roles = new HashSet<WxPlatformRole>();

	
	public WxPlatformUser() {}
	
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	
	public Set<WxPlatformRole> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<WxPlatformRole> roles) {
        this.roles = roles;
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

}

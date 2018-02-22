package com.xyh.wechat.jpa.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.xyh.wechat.jpa.entities.WxPlatformUser;

@Entity
@Table(name="WX_PLATFORM_ROLE")
public class WxPlatformRole extends WxBaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8388355732592310313L;

	@Id
	@Column(name="role_id")
	private long roleId;
	
	@Column(name="role_name")
	private String rolename;
	
	@Column(name="created_time", insertable=false, updatable=false)
	private Timestamp createdTime;
	
	@Column(name="updated_time", insertable=false)
	private Timestamp updatedTime;
	
	@ManyToMany(mappedBy="roles", fetch=FetchType.LAZY)//指定维护的一方，注意这里的名称是另外一个类的属性名
	private Set<WxPlatformUser> users = new HashSet<WxPlatformUser>();
	
	@ManyToMany(mappedBy="roles", fetch=FetchType.LAZY)//指定维护的一方，注意这里的名称是另外一个类的属性名
	private Set<WxPlatformADGroup> adgroups = new HashSet<WxPlatformADGroup>();
	
	public WxPlatformRole() {}
	
	public long getRoleId() {
		return roleId;
	}
	
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	public String getRolename() {
		return rolename;
	}
	
	public void setRoleName(String rolename) {
		this.rolename = rolename;
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
	
	public Set<WxPlatformUser> getUsers() {
        return users;
    }
	
    public void setUsers(Set<WxPlatformUser> users) {
        this.users = users;
    }

	/**
	 * @return the adgroups
	 */    
	public Set<WxPlatformADGroup> getAdgroups() {
		return adgroups;
	}

	/**
	 * @param adgroups the adgroups to set
	 */
	public void setAdgroups(Set<WxPlatformADGroup> adgroups) {
		this.adgroups = adgroups;
	}
}

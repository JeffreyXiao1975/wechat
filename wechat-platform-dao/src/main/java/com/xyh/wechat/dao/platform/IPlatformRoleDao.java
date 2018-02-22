package com.xyh.wechat.dao.platform;

import java.util.List;

import com.xyh.wechat.jpa.entities.WxPlatformRole;

public interface IPlatformRoleDao {
	public List<WxPlatformRole> GetPlatformRoles();	
}

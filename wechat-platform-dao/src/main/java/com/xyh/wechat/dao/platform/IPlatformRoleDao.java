package com.xyh.wechat.dao.platform;

import java.util.List;

import com.xyh.wechat.jpa.entities.WxPlatformRole;
import com.xyh.wechat.vo.platform.PlatformRoleCriteriaVo;

public interface IPlatformRoleDao {
	public long queryPlatformRoleCount(PlatformRoleCriteriaVo platformRoleCriteriaVo);	
	public List<WxPlatformRole> queryPlatformRoles(PlatformRoleCriteriaVo platformRoleCriteriaVo);
	public WxPlatformRole getPlatformRoleById(long platformRoleId);
	public void createPlatformRole(WxPlatformRole wxPlatformRole);
	public void updatePlatformRole(WxPlatformRole wxPlatformRole);
}

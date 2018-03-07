package com.xyh.wechat.service.platform;

import java.util.List;

import com.xyh.wechat.vo.platform.PlatformRoleVo;
import com.xyh.wechat.web.model.platform.PlatformRoleCriteriaModel;

public interface IPlatformRoleService {
	public long queryPlatformRoleCount(PlatformRoleCriteriaModel platformRoleCriteriaModel);
	public List<PlatformRoleVo> queryPlatformRoles(PlatformRoleCriteriaModel platformRoleCriteriaModel);
	public PlatformRoleVo getPlatformRoleById(long platformRoleId);
	public void createPlatformRole(PlatformRoleVo platformRoleVo);
	public void updatePlatformRole(PlatformRoleVo platformRoleVo);
	public void deletePlatformRole(PlatformRoleVo platformRoleVo);
	public void disablePlatformRole(PlatformRoleVo platformRoleVo);
	public void enablePlatformRole(PlatformRoleVo platformRoleVo);
}

package com.xyh.wechat.service.platform;

import java.util.List;

import com.xyh.wechat.vo.platform.PlatformUserVo;
import com.xyh.wechat.web.model.platform.PlatformUserCriteriaModel;

public interface IPlatformUserService {
	public boolean authenticateUser(String username, String password);
	public long queryPlatformUserCount(PlatformUserCriteriaModel queryPlatformUserCriteriaModel);
	public List<PlatformUserVo> queryPlatformUsers(PlatformUserCriteriaModel queryPlatformUserCriteriaModel);
	public void createPlatformUser(PlatformUserVo platformUserVo);
	public void updatePlatformUser(PlatformUserVo platformUserVo);
	public void deletePlatformUser(PlatformUserVo platformUserVo);
	public void disablePlatformUser(PlatformUserVo platformUserVo);
	public void enablePlatformUser(PlatformUserVo platformUserVo);
}

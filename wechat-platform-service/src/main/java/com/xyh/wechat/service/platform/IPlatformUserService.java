package com.xyh.wechat.service.platform;

import java.util.List;

import com.xyh.wechat.vo.platform.PlatformUserVo;
import com.xyh.wechat.web.model.platform.QueryPlatformUserCriteriaModel;

public interface IPlatformUserService {
	public boolean authenticateUser(String username, String password);
	public long queryPlatformUserCount(QueryPlatformUserCriteriaModel queryPlatformUserCriteriaModel);
	public List<PlatformUserVo> queryPlatformUsers(QueryPlatformUserCriteriaModel queryPlatformUserCriteriaModel);
}

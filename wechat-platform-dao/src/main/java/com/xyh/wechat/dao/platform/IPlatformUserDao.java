package com.xyh.wechat.dao.platform;

import java.util.List;

import com.xyh.wechat.jpa.entities.WxPlatformUser;
import com.xyh.wechat.vo.platform.QueryPlatformUserCriteriaVo;

public interface IPlatformUserDao {
	public WxPlatformUser getPlatformUser(String username, String password);
	public long queryPlatformUserCount(QueryPlatformUserCriteriaVo queryPlatformUserCriteriaVo);
	public List<WxPlatformUser> queryPlatformUsers(QueryPlatformUserCriteriaVo queryPlatformUserCriteriaVo);
	public boolean isUserInRole(String username, String rolename);
}

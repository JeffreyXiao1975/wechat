package com.xyh.wechat.dao.platform;

import java.util.List;

import com.xyh.wechat.jpa.entities.WxPlatformUser;
import com.xyh.wechat.vo.platform.PlatformUserCriteriaVo;

public interface IPlatformUserDao {
	public WxPlatformUser getPlatformUser(String username, String password);
	public long queryPlatformUserCount(PlatformUserCriteriaVo platformUserCriteriaVo);
	public List<WxPlatformUser> queryPlatformUsers(PlatformUserCriteriaVo platformUserCriteriaVo);
	public boolean isUserInRole(String username, String rolename);
	public WxPlatformUser getPlatformUserById(long platformUserId);
	public void createPlatformUser(WxPlatformUser wxPlatformUser);
	public void updatePlatformUser(WxPlatformUser wxPlatformUser);
}

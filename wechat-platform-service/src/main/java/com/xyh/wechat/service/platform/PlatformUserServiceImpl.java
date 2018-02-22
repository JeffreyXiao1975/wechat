/**
 * 
 */
package com.xyh.wechat.service.platform;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.dao.platform.IPlatformUserDao;
import com.xyh.wechat.jpa.entities.WxPlatformUser;
import com.xyh.wechat.service.BaseService;
import com.xyh.wechat.service.platform.IPlatformUserService;
import com.xyh.wechat.convertor.platform.PlatformUserConvertor;
import com.xyh.wechat.vo.platform.PlatformUserVo;
import com.xyh.wechat.web.model.platform.QueryPlatformUserCriteriaModel;

/**
 * 
 * @author yhu_x
 *
 */
@Service("platformUserService")
public class PlatformUserServiceImpl extends BaseService implements IPlatformUserService {
	@Autowired  
	private IPlatformUserDao platformUserDao;

	/**
	 * 
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public boolean authenticateUser(String username, String password) {
		return (platformUserDao.getPlatformUser(username, password) != null);
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public long queryPlatformUserCount(QueryPlatformUserCriteriaModel queryPlatformUserCriteriaModel) {
		long userCount = 0;
		userCount = platformUserDao.queryPlatformUserCount(PlatformUserConvertor.convertToVo(queryPlatformUserCriteriaModel));
		return userCount;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<PlatformUserVo> queryPlatformUsers(QueryPlatformUserCriteriaModel queryPlatformUserCriteriaModel) {
		List<PlatformUserVo> lUserVos = null;
		List<WxPlatformUser> lWxPlatformUsers = null;
		
		lWxPlatformUsers = platformUserDao.queryPlatformUsers(PlatformUserConvertor.convertToVo(queryPlatformUserCriteriaModel));
		if (lWxPlatformUsers != null && lWxPlatformUsers.size() > 0) {
			lUserVos = new ArrayList<PlatformUserVo>();
			Iterator<WxPlatformUser> iterator = lWxPlatformUsers.iterator();
			while (iterator.hasNext()) {
				WxPlatformUser wxPlatformUser = iterator.next();
				lUserVos.add(PlatformUserConvertor.convertToVo(wxPlatformUser));
			}
		}
		
		return lUserVos;
	}
}

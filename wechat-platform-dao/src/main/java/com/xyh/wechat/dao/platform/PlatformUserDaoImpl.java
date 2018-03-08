package com.xyh.wechat.dao.platform;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.dao.BaseDao;
import com.xyh.wechat.dao.platform.IPlatformUserDao;
import com.xyh.wechat.jpa.entities.WxPlatformUser;
import com.xyh.wechat.vo.platform.PlatformUserCriteriaVo;

@Component("platformUserDao")
@Scope("singleton")
@Transactional
public class PlatformUserDaoImpl extends BaseDao implements IPlatformUserDao{
	public WxPlatformUser getPlatformUser(String username, String password) {
		WxPlatformUser wxPlatformUser = null;
		
		try {
			Query query = this.entityManager.createQuery("select wxPlatformUser from WxPlatformUser as wxPlatformUser where wxPlatformUser.username = :username and wxPlatformUser.password = :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			wxPlatformUser = (WxPlatformUser) query.getSingleResult();
		} catch (Exception ex) {
			logger.error(ex);
			wxPlatformUser = null;
		}
		return wxPlatformUser;
	}
	
	public long queryPlatformUserCount(PlatformUserCriteriaVo platformUserCriteriaVo) {
		long userCount = 0;
		String strSQL = "";
		
		try {
			strSQL = "select count(wxPlatformUser) from WxPlatformUser as wxPlatformUser where wxPlatformUser.username like :username";
			if (platformUserCriteriaVo.isDisabledIncluded()) {
				if (!platformUserCriteriaVo.isDeletedIncluded()) {
					strSQL = strSQL + "wxPlatformUser.deleted = 0 ";
				}
			} else {
				if (platformUserCriteriaVo.isDeletedIncluded()) {
					strSQL = strSQL + " and wxPlatformUser.disabled = 0 ";
				} else {
					strSQL = strSQL + " and wxPlatformUser.disabled = 0 and wxPlatformUser.deleted = 0 ";
				}
			}
			
			Query query = this.entityManager.createQuery(strSQL);
			if (platformUserCriteriaVo.getUsername() != null) {
				query.setParameter("username", "%" + platformUserCriteriaVo.getUsername() + "%");
			} else {
				query.setParameter("username", "%%");
			}
			userCount = ((Long) query.getSingleResult()).longValue();
		} catch (Exception ex) {
			logger.error(ex);
		}
		
		return userCount;
	}
	
	@SuppressWarnings("unchecked")
	public List<WxPlatformUser> queryPlatformUsers(PlatformUserCriteriaVo platformUserCriteriaVo) {
		String strSQL = "";
		int pageNumber, pageSize;
		List<WxPlatformUser> lWxPlatformUsers =  null;
		
		try {
			strSQL = "select wxPlatformUser from WxPlatformUser as wxPlatformUser where wxPlatformUser.username like :username";
			if (platformUserCriteriaVo.isDisabledIncluded()) {
				if (!platformUserCriteriaVo.isDeletedIncluded()) {
					strSQL = strSQL + "wxPlatformUser.deleted = 0 ";
				}
			} else {
				if (platformUserCriteriaVo.isDeletedIncluded()) {
					strSQL = strSQL + " and wxPlatformUser.disabled = 0 ";
				} else {
					strSQL = strSQL + " and wxPlatformUser.disabled = 0 and wxPlatformUser.deleted = 0 ";
				}
			}
			
			Query query = this.entityManager.createQuery(strSQL);
			if (platformUserCriteriaVo.getUsername() != null) {
				query.setParameter("username", "%" + platformUserCriteriaVo.getUsername() + "%");
			} else {
				query.setParameter("username", "%%");
			}
			pageSize = platformUserCriteriaVo.getPageSize();
			pageNumber = (new Long(platformUserCriteriaVo.getPageNumber())).intValue();
			if (pageNumber > 1) {
				if (query.getMaxResults() > (pageNumber -1) * pageSize) {
					query.setFirstResult((pageNumber -1) * pageSize + 1);
					query.setMaxResults(pageSize);
				}
			} else {
				query.setFirstResult(0);
				query.setMaxResults(pageSize);
			}
			lWxPlatformUsers = (List<WxPlatformUser>) query.getResultList();
		} catch (Exception ex) {
			logger.error(ex);
			lWxPlatformUsers = null;
		}
		return lWxPlatformUsers;
	}
	
	public boolean isUserInRole(String username, String rolename) {
		boolean result = false;		
		
		try {
			String strSQL = "select user.user_name, mapping.role_id, role.role_name from wx_user_role_mapping as mapping "
					+ "left join wx_platform_role role on mapping.role_id = role.role_id "
					+ "left join wx_platform_user user on mapping.user_id = user.user_id "
					+ "where role.role_name = ? and user.user_name = ? "
					+ "union " 
					+ "select adgroupuser.user_name, adgrouprolemapping.role_id, adgrouprolemapping.role_name "
					+ "from wx_platform_adgroup_user as adgroupuser " 
					+ "left join (select adgrouprolemapping.adgroup_id, adgroup.adgroup_name, adgrouprolemapping.role_id, role.role_name "
					+ "from wx_adgroup_role_mapping adgrouprolemapping "
					+ "left join wx_platform_role role on adgrouprolemapping.role_id = role.role_id "
					+ "left join wx_platform_adgroup adgroup on adgrouprolemapping.adgroup_id = adgroup.adgroup_id "
					+ "where role.role_name = ?) as adgrouprolemapping on adgroupuser.adgroup_id = adgrouprolemapping.adgroup_id "
					+ "where adgroupuser.user_name = ?";
			
			Query query = this.entityManager.createNativeQuery(strSQL);
			query.setParameter(1, rolename);
			query.setParameter(2, username);
			query.setParameter(3, rolename);
			query.setParameter(4, username);
			@SuppressWarnings("rawtypes")
			List list = query.getResultList();
			if (list != null && list.size() > 0) {
				result = true;
			}
		} catch (Exception ex) {
			logger.error(ex);
			return result;
		}
		return result;
	}
	
	public WxPlatformUser getPlatformUserById(long platformUserId) {
		WxPlatformUser wxPlatformUser = null;
		
		try {
			wxPlatformUser = this.entityManager.find(WxPlatformUser.class, platformUserId);
		} catch (Exception ex) {
			logger.error(ex);
		}
		
		return wxPlatformUser;
	}
	
	public void createPlatformUser(WxPlatformUser wxPlatformUser) {
		try {
			this.entityManager.persist(wxPlatformUser);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}
	
	public void updatePlatformUser(WxPlatformUser wxPlatformUser) {
		try {
			this.entityManager.merge(wxPlatformUser);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}
}

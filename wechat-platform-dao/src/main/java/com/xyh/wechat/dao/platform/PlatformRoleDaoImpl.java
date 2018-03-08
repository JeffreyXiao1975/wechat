package com.xyh.wechat.dao.platform;

import java.util.List;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.dao.BaseDao;
import com.xyh.wechat.jpa.entities.WxPlatformRole;
import com.xyh.wechat.vo.platform.PlatformRoleCriteriaVo;

@Component("platformRoleDao")
@Scope("singleton")
@Transactional
public class PlatformRoleDaoImpl extends BaseDao implements IPlatformRoleDao {
	
	public long queryPlatformRoleCount(PlatformRoleCriteriaVo platformRoleCriteriaVo) {
		long userCount = 0;
		String strSQL = "";
		try {
			strSQL = "select count(wxPlatformRole) from WxPlatformRole as wxPlatformRole where wxPlatformRole.rolename like :rolename ";
			if (platformRoleCriteriaVo.isDisabledIncluded()) {
				if (!platformRoleCriteriaVo.isDeletedIncluded()) {
					strSQL = strSQL + " wxPlatformRole.deleted = 0 ";
				}
			} else {
				if (platformRoleCriteriaVo.isDeletedIncluded()) {
					strSQL = strSQL + " and wxPlatformRole.disabled = 0 ";
				} else {
					strSQL = strSQL + " and wxPlatformRole.disabled = 0 and wxPlatformRole.deleted = 0 ";
				}
			}
			Query query = this.entityManager.createQuery(strSQL);
			if (platformRoleCriteriaVo.getRolename() != null) {
				query.setParameter("rolename", "%" + platformRoleCriteriaVo.getRolename() + "%");
			} else {
				query.setParameter("rolename", "%%");
			}
			userCount = ((Long) query.getSingleResult()).longValue();
		} catch (Exception ex) {
			logger.error(ex);
		}
		
		return userCount;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<WxPlatformRole> queryPlatformRoles(PlatformRoleCriteriaVo platformRoleCriteriaVo) {
		String strSQL = "";
		int pageNumber, pageSize;
		List<WxPlatformRole> lWxPlatformRoles =  null;
		
		try {
			strSQL = "select wxPlatformRole from WxPlatformRole as wxPlatformRole where wxPlatformRole.rolename like :rolename";
			if (platformRoleCriteriaVo.isDisabledIncluded()) {
				if (!platformRoleCriteriaVo.isDeletedIncluded()) {
					strSQL = strSQL + " wxPlatformRole.deleted = 0 ";
				}
			} else {
				if (platformRoleCriteriaVo.isDeletedIncluded()) {
					strSQL = strSQL + " and wxPlatformRole.disabled = 0 ";
				} else {
					strSQL = strSQL + " and wxPlatformRole.disabled = 0 and wxPlatformRole.deleted = 0 ";
				}
			}
			
			Query query = this.entityManager.createQuery(strSQL);
			if (platformRoleCriteriaVo.getRolename() != null) {
				query.setParameter("rolename", "%" + platformRoleCriteriaVo.getRolename() + "%");
			} else {
				query.setParameter("rolename", "%%");
			}
			pageSize = platformRoleCriteriaVo.getPageSize();
			pageNumber = (new Long(platformRoleCriteriaVo.getPageNumber())).intValue();
			if (pageNumber > 1) {
				if (query.getMaxResults() > (pageNumber -1) * pageSize) {
					query.setFirstResult((pageNumber -1) * pageSize + 1);
					query.setMaxResults(pageSize);
				}
			} else {
				query.setFirstResult(0);
				query.setMaxResults(pageSize);
			}
			lWxPlatformRoles = (List<WxPlatformRole>) query.getResultList();
		} catch (Exception ex) {
			logger.error(ex);
			lWxPlatformRoles = null;
		}
		return lWxPlatformRoles;
	}
	
	public WxPlatformRole getPlatformRoleById(long platformRoleId) {
		WxPlatformRole wxPlatformRole = null;
		
		try {
			wxPlatformRole = this.entityManager.find(WxPlatformRole.class, platformRoleId);
		} catch (Exception ex) {
			logger.error(ex);
		}
		
		return wxPlatformRole;
	}
	public void createPlatformRole(WxPlatformRole wxPlatformRole) {
		try {
			this.entityManager.persist(wxPlatformRole);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}
	
	public void updatePlatformRole(WxPlatformRole wxPlatformRole) {
		try {
			this.entityManager.merge(wxPlatformRole);
		} catch (Exception ex) {
			logger.error(ex);
		}
	}
	
}

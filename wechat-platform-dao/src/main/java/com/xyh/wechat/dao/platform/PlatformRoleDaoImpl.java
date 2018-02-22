package com.xyh.wechat.dao.platform;

import java.util.List;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.dao.BaseDao;
import com.xyh.wechat.jpa.entities.WxPlatformRole;

@Component("platformRoleDao")
@Scope("singleton")
@Transactional
public class PlatformRoleDaoImpl extends BaseDao implements IPlatformRoleDao {
	@SuppressWarnings("unchecked")
	public List<WxPlatformRole> GetPlatformRoles() {
		List<WxPlatformRole> lWxPlatformRoles = null;
		
		try {
			Query query = this.entityManager.createQuery("select wxPlatformRole from WxPlatformRole as wxPlatformRole order by wxPlatformRole.roleId asc");
			lWxPlatformRoles = (List<WxPlatformRole>) query.getResultList();
		} catch (Exception ex) {
			logger.error(ex);
			lWxPlatformRoles = null;
		}
		return lWxPlatformRoles;
	}
}

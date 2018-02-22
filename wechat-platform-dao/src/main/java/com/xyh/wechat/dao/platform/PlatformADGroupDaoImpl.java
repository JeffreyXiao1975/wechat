package com.xyh.wechat.dao.platform;

import java.util.List;

import javax.persistence.Query;

import com.xyh.wechat.dao.BaseDao;
import com.xyh.wechat.jpa.entities.WxPlatformADGroup;

public class PlatformADGroupDaoImpl extends BaseDao implements IPlatformADGroupDao {
	@SuppressWarnings("unchecked")
	public WxPlatformADGroup createADGroup (WxPlatformADGroup wxPlatformADGroup) {
		
		try {
			Query query = this.entityManager.createQuery("select wxPlatformADGroup from WxPlatformADGroup as wxPlatformADGroup where wxPlatformADGroup.adgroupname = :adgroupname");
			query.setParameter("adgroupname", wxPlatformADGroup.getAdgroupname());
			List<WxPlatformADGroup> list = (List<WxPlatformADGroup>)query.getResultList();
			if (list == null || list.size() == 0) {
				this.entityManager.persist(wxPlatformADGroup);
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		return null;
	}
}

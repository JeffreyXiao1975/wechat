package com.xyh.wechat.dao.platform;

import java.util.List;

import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.dao.BaseDao;
import com.xyh.wechat.jpa.entities.WxPlatformLegalEntity;

@Component("platformLegalEntityDao")
@Scope("singleton")
@Transactional
public class PlatformLegalEntityDaoImpl extends BaseDao implements IPlatformLegalEntityDao {

	@SuppressWarnings("unchecked")
	public List<WxPlatformLegalEntity> getAllLegalEntities(boolean includeDisabled, boolean includeDeleted) {
		String strSQL = "";
		List<WxPlatformLegalEntity> lwxPlatformLegalEntities =  null;
		
		try {
			strSQL = "select wxPlatformLegalEntity from WxPlatformLegalEntity as wxPlatformLegalEntity where 1 = 1 ";
			if (includeDisabled) {
				if (!includeDeleted) {
					strSQL = strSQL + " and wxPlatformLegalEntity.deleted = 0 ";
				}
			} else {
				if (includeDeleted) {
					strSQL = strSQL + " and wxPlatformLegalEntity.disabled = 0 ";
				} else {
					strSQL = strSQL + " and wxPlatformLegalEntity.disabled = 0 and wxPlatformLegalEntity.deleted = 0 ";
				}
			}
			Query query = this.entityManager.createQuery(strSQL);
			lwxPlatformLegalEntities = (List<WxPlatformLegalEntity>) query.getResultList();
		} catch (Exception ex) {
			logger.error(ex);
			lwxPlatformLegalEntities = null;
		}
		return lwxPlatformLegalEntities;
	}

	public WxPlatformLegalEntity getLegalEntitybyId(long legalEntityId) {
		WxPlatformLegalEntity wxPlatformLegalEntity = null;
		try {
			wxPlatformLegalEntity = this.entityManager.find(WxPlatformLegalEntity.class, legalEntityId);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return wxPlatformLegalEntity;
	}

	public WxPlatformLegalEntity createLegalEntity(WxPlatformLegalEntity wxPlatformLegalEntity) {
		try {
			this.entityManager.persist(wxPlatformLegalEntity);
		} catch (Exception ex) {
			logger.error(ex);
		}
		return wxPlatformLegalEntity;
	}

	public WxPlatformLegalEntity updateLegalEntity(WxPlatformLegalEntity wxPlatformLegalEntity) {
		return this.entityManager.merge(wxPlatformLegalEntity);
	}

}

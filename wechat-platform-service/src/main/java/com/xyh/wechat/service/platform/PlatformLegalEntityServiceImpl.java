package com.xyh.wechat.service.platform;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.convertor.platform.PlatformLegalEntityConvertor;
import com.xyh.wechat.dao.platform.IPlatformLegalEntityDao;
import com.xyh.wechat.jpa.entities.WxPlatformLegalEntity;
import com.xyh.wechat.service.BaseService;
import com.xyh.wechat.vo.platform.PlatformLegalEntityVo;

@Service("platformLegalEntityService")
public class PlatformLegalEntityServiceImpl extends BaseService implements IPlatformLegalEntityService {
	@Autowired 
	IPlatformLegalEntityDao platformLegalEntityDao;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<PlatformLegalEntityVo> getAllLegalEntities(boolean includeDisabled, boolean includeDeleted) {
		List<WxPlatformLegalEntity> wxPlatformLegalEntities = null;
		List<PlatformLegalEntityVo> platformLegalEntityVos = null;
		
		wxPlatformLegalEntities = platformLegalEntityDao.getAllLegalEntities(includeDisabled, includeDeleted);
		if (wxPlatformLegalEntities != null && wxPlatformLegalEntities.size() > 0) {
			platformLegalEntityVos = new ArrayList<PlatformLegalEntityVo>();
			Iterator<WxPlatformLegalEntity> iterator = wxPlatformLegalEntities.iterator();
			while (iterator.hasNext()) {
				WxPlatformLegalEntity wxPlatformLegalEntity = iterator.next();
				platformLegalEntityVos.add(PlatformLegalEntityConvertor.convertToVo(wxPlatformLegalEntity));
			}
		}
		return platformLegalEntityVos;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public PlatformLegalEntityVo getLegalEntitybyId(long legalEntityId) {
		WxPlatformLegalEntity wxPlatformLegalEntity = null;
		PlatformLegalEntityVo platformLegalEntityVo = null;
		
		wxPlatformLegalEntity = platformLegalEntityDao.getLegalEntitybyId(legalEntityId);
		platformLegalEntityVo = PlatformLegalEntityConvertor.convertToVo(wxPlatformLegalEntity);
		return platformLegalEntityVo;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public PlatformLegalEntityVo createLegalEntity(PlatformLegalEntityVo platformLegalEntityVo) {
		WxPlatformLegalEntity wxPlatformLegalEntity = null;
		
		wxPlatformLegalEntity = PlatformLegalEntityConvertor.convertToEntity(platformLegalEntityVo);
		wxPlatformLegalEntity = platformLegalEntityDao.createLegalEntity(wxPlatformLegalEntity);
		return PlatformLegalEntityConvertor.convertToVo(wxPlatformLegalEntity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public PlatformLegalEntityVo updateLegalEntity(PlatformLegalEntityVo platformLegalEntityVo) {
		WxPlatformLegalEntity wxPlatformLegalEntity = null;
		
		wxPlatformLegalEntity = platformLegalEntityDao.getLegalEntitybyId(platformLegalEntityVo.getId());
		if (wxPlatformLegalEntity != null) {
			wxPlatformLegalEntity.setLegalEntityNameCN(platformLegalEntityVo.getNameCN());
			wxPlatformLegalEntity.setLegalEntityNameEN(platformLegalEntityVo.getNameEN());
			wxPlatformLegalEntity.setDeleted(platformLegalEntityVo.isDeleted());
			wxPlatformLegalEntity.setDisabled(platformLegalEntityVo.isDisabled());
			wxPlatformLegalEntity = platformLegalEntityDao.updateLegalEntity(wxPlatformLegalEntity);
		}
		
		return PlatformLegalEntityConvertor.convertToVo(wxPlatformLegalEntity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public PlatformLegalEntityVo deleteLegalEntity(PlatformLegalEntityVo platformLegalEntityVo) {
		WxPlatformLegalEntity wxPlatformLegalEntity = null;
		
		wxPlatformLegalEntity = platformLegalEntityDao.getLegalEntitybyId(platformLegalEntityVo.getId());
		if (wxPlatformLegalEntity != null) {
			wxPlatformLegalEntity.setDeleted(true);
			wxPlatformLegalEntity = platformLegalEntityDao.updateLegalEntity(wxPlatformLegalEntity);
		}
		
		return PlatformLegalEntityConvertor.convertToVo(wxPlatformLegalEntity);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public PlatformLegalEntityVo disableLegalEntity(PlatformLegalEntityVo platformLegalEntityVo) {
		WxPlatformLegalEntity wxPlatformLegalEntity = null;
		
		wxPlatformLegalEntity = platformLegalEntityDao.getLegalEntitybyId(platformLegalEntityVo.getId());
		if (wxPlatformLegalEntity != null) {
			wxPlatformLegalEntity.setDisabled(true);
			wxPlatformLegalEntity = platformLegalEntityDao.updateLegalEntity(wxPlatformLegalEntity);
		}
		
		return PlatformLegalEntityConvertor.convertToVo(wxPlatformLegalEntity);
	}

}

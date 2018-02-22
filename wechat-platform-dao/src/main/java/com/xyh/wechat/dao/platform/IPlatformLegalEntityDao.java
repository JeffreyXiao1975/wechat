package com.xyh.wechat.dao.platform;

import java.util.List;

import com.xyh.wechat.jpa.entities.WxPlatformLegalEntity;

public interface IPlatformLegalEntityDao {
	public List<WxPlatformLegalEntity> getAllLegalEntities(boolean includeDisabled, boolean includeDeleted);
	public WxPlatformLegalEntity getLegalEntitybyId(long legalEntityId);
	public WxPlatformLegalEntity createLegalEntity(WxPlatformLegalEntity wxPlatformLegalEntity);
	public WxPlatformLegalEntity updateLegalEntity(WxPlatformLegalEntity wxPlatformLegalEntity);
}

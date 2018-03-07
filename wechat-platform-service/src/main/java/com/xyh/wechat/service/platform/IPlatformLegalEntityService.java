package com.xyh.wechat.service.platform;

import java.util.List;

import com.xyh.wechat.vo.platform.PlatformLegalEntityVo;

public interface IPlatformLegalEntityService {
	public List<PlatformLegalEntityVo> getAllLegalEntities(boolean includeDisabled, boolean includeDeleted);
	public PlatformLegalEntityVo getLegalEntitybyId(long legalEntityId);
	public PlatformLegalEntityVo createLegalEntity(PlatformLegalEntityVo platformLegalEntityVo);
	public PlatformLegalEntityVo updateLegalEntity(PlatformLegalEntityVo platformLegalEntityVo);
	public PlatformLegalEntityVo deleteLegalEntity(PlatformLegalEntityVo platformLegalEntityVo);
	public PlatformLegalEntityVo disableLegalEntity(PlatformLegalEntityVo platformLegalEntityVo);
}

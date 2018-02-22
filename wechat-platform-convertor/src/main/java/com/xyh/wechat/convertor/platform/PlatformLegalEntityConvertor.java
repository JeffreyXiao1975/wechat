package com.xyh.wechat.convertor.platform;

import com.xyh.wechat.jpa.entities.WxPlatformLegalEntity;
import com.xyh.wechat.vo.platform.PlatformLegalEntityVo;

public class PlatformLegalEntityConvertor {
	public static PlatformLegalEntityVo convertToVo(WxPlatformLegalEntity wxPlatformLegalEntity) {
		PlatformLegalEntityVo platformLegalEntityVo = null;
		
		if (wxPlatformLegalEntity != null) {
			platformLegalEntityVo = new PlatformLegalEntityVo();
			platformLegalEntityVo.setId(wxPlatformLegalEntity.getLegalEntityId());
			platformLegalEntityVo.setNameCN(wxPlatformLegalEntity.getLegalEntityNameCN());
			platformLegalEntityVo.setNameEN(wxPlatformLegalEntity.getLegalEntityNameEN());
			platformLegalEntityVo.setDeleted(wxPlatformLegalEntity.isDeleted());
			platformLegalEntityVo.setDisabled(wxPlatformLegalEntity.isDisabled());
			platformLegalEntityVo.setCreatedTime(wxPlatformLegalEntity.getCreatedTime().toString());
			platformLegalEntityVo.setUpdatedTime(wxPlatformLegalEntity.getUpdatedTime().toString());
		}
		return platformLegalEntityVo;
	}
	
	public static WxPlatformLegalEntity convertToEntity(PlatformLegalEntityVo platformLegalEntityVo) {
		WxPlatformLegalEntity wxPlatformLegalEntity = null;
		
		if (platformLegalEntityVo != null) {
			wxPlatformLegalEntity = new WxPlatformLegalEntity();
			wxPlatformLegalEntity.setLegalEntityId(platformLegalEntityVo.getId());
			wxPlatformLegalEntity.setLegalEntityNameCN(platformLegalEntityVo.getNameCN());
			wxPlatformLegalEntity.setLegalEntityNameEN(platformLegalEntityVo.getNameEN());
			wxPlatformLegalEntity.setDisabled(platformLegalEntityVo.isDisabled());
			wxPlatformLegalEntity.setDeleted(platformLegalEntityVo.isDeleted());
		}
		return wxPlatformLegalEntity;
	}
}

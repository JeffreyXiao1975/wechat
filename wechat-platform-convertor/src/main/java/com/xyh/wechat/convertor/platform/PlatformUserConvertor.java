package com.xyh.wechat.convertor.platform;

import com.xyh.wechat.convertor.BaseConvertor;
import com.xyh.wechat.web.model.platform.PlatformUserCriteriaModel;
import com.xyh.wechat.jpa.entities.WxPlatformUser;
import com.xyh.wechat.vo.platform.PlatformUserVo;
import com.xyh.wechat.vo.platform.PlatformUserCriteriaVo;

public class PlatformUserConvertor extends BaseConvertor {
	public static PlatformUserVo convertToVo(WxPlatformUser wxPlatformUser) {
		PlatformUserVo userVo = null;
		
		if (wxPlatformUser != null) {
			userVo = new PlatformUserVo();
			userVo.setId(wxPlatformUser.getUserId());
			userVo.setUsername(wxPlatformUser.getUsername());
			userVo.setPassword(wxPlatformUser.getPassword());
			userVo.setDisabled(wxPlatformUser.isDisabled());
			userVo.setDeleted(wxPlatformUser.isDeleted());
			userVo.setCreatedTime(wxPlatformUser.getCreatedTime().toString());
			userVo.setUpdatedTime(wxPlatformUser.getUpdatedTime().toString());
		}
		return userVo;
	}
	
	public static PlatformUserCriteriaVo convertToVo(PlatformUserCriteriaModel platformUserCriteriaModel) {
		PlatformUserCriteriaVo platformUserCriteriaVo = null;
		
		if (platformUserCriteriaModel != null) {
			platformUserCriteriaVo = new PlatformUserCriteriaVo();
			platformUserCriteriaVo.setUsername(platformUserCriteriaModel.getUsername());
			platformUserCriteriaVo.setDeletedIncluded(platformUserCriteriaModel.isDeletedIncluded());
			platformUserCriteriaVo.setDisabledIncluded(platformUserCriteriaModel.isDisabledIncluded());
			platformUserCriteriaVo.setPageSize(platformUserCriteriaModel.getPageSize());
			platformUserCriteriaVo.setPageNumber(platformUserCriteriaModel.getCurrentPageNumber());
		}
		return platformUserCriteriaVo;
	}
	
	public static WxPlatformUser convertToEntity(PlatformUserVo platformUserVo) {
		WxPlatformUser wxPlatformUser = null;
		
		if (platformUserVo != null) {
			wxPlatformUser = new WxPlatformUser();
			wxPlatformUser.setUserId(platformUserVo.getId());
			wxPlatformUser.setUsername(platformUserVo.getUsername());
			wxPlatformUser.setPassword(platformUserVo.getPassword());
			wxPlatformUser.setDisabled(platformUserVo.isDisabled());
			wxPlatformUser.setDeleted(platformUserVo.isDeleted());
		}
		
		return wxPlatformUser;
	}
}

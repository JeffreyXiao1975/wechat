package com.xyh.wechat.convertor.platform;

import com.xyh.wechat.convertor.BaseConvertor;
import com.xyh.wechat.web.model.platform.QueryPlatformUserCriteriaModel;
import com.xyh.wechat.jpa.entities.WxPlatformUser;
import com.xyh.wechat.vo.platform.PlatformUserVo;
import com.xyh.wechat.vo.platform.QueryPlatformUserCriteriaVo;

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
	
	public static QueryPlatformUserCriteriaVo convertToVo(QueryPlatformUserCriteriaModel queryPlatformUserCriteriaModel) {
		QueryPlatformUserCriteriaVo queryPlatformUserCriteriaVo = null;
		
		if (queryPlatformUserCriteriaModel != null) {
			queryPlatformUserCriteriaVo = new QueryPlatformUserCriteriaVo();
			queryPlatformUserCriteriaVo.setUsername(queryPlatformUserCriteriaModel.getUsername());
			queryPlatformUserCriteriaVo.setPageSize(queryPlatformUserCriteriaModel.getPageSize());
			queryPlatformUserCriteriaVo.setPageNumber(queryPlatformUserCriteriaModel.getCurrentPageNumber());
		}
		return queryPlatformUserCriteriaVo;
	}
	
	public static WxPlatformUser convertToEntity(PlatformUserVo userVo) {
		WxPlatformUser wxPlatformUser = null;
		
		if (userVo != null) {
			wxPlatformUser = new WxPlatformUser();
			wxPlatformUser.setUserId(userVo.getId());
			wxPlatformUser.setUsername(userVo.getUsername());
			wxPlatformUser.setPassword(userVo.getPassword());
			wxPlatformUser.setDisabled(userVo.isDisabled());
			wxPlatformUser.setDeleted(userVo.isDeleted());
		}
		
		return wxPlatformUser;
	}
}

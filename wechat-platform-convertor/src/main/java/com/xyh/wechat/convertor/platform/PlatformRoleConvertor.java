package com.xyh.wechat.convertor.platform;

import com.xyh.wechat.jpa.entities.WxPlatformRole;
import com.xyh.wechat.vo.platform.PlatformRoleCriteriaVo;
import com.xyh.wechat.vo.platform.PlatformRoleVo;
import com.xyh.wechat.web.model.platform.PlatformRoleCriteriaModel;
import com.xyh.wechat.web.model.platform.PlatformRoleModel;

public class PlatformRoleConvertor {
	public static PlatformRoleCriteriaVo convertToVo(PlatformRoleCriteriaModel platformRoleCriteriaModel) {
		PlatformRoleCriteriaVo platformRoleCriteriaVo = null;
		
		if (platformRoleCriteriaModel != null) {
			platformRoleCriteriaVo = new PlatformRoleCriteriaVo();
			platformRoleCriteriaVo.setRolename(platformRoleCriteriaModel.getRolename());
			platformRoleCriteriaVo.setDeletedIncluded(platformRoleCriteriaModel.isDeletedIncluded());
			platformRoleCriteriaVo.setDisabledIncluded(platformRoleCriteriaModel.isDisabledIncluded());
			platformRoleCriteriaVo.setPageNumber(platformRoleCriteriaModel.getCurrentPageNumber());
			platformRoleCriteriaVo.setPageSize(platformRoleCriteriaModel.getPageSize());
		}
		
		return platformRoleCriteriaVo;
	}
	
	public static PlatformRoleVo convertToVo(WxPlatformRole wxPlatformRole) {
		PlatformRoleVo platformRoleVo = null;
		
		if (wxPlatformRole != null) {
			
		}
		
		return platformRoleVo;
	}
	
	public static PlatformRoleVo convertToVo(PlatformRoleModel platformRoleModel) {
		PlatformRoleVo platformRoleVo = null;
		
		if (platformRoleModel != null) {
			
		}
		
		return platformRoleVo;
	}
	
	public static WxPlatformRole convertToEntity(PlatformRoleVo platformRoleVo) {
		WxPlatformRole wxPlatformRole = null;
		
		if (platformRoleVo != null) {
			
		}
		
		return wxPlatformRole;
	}
	
	public static PlatformRoleModel convertToModel(PlatformRoleVo platformRoleVo) {
		PlatformRoleModel platformRoleModel = null;
		
		if (platformRoleVo != null) {
			
		}
		
		return platformRoleModel;
	}
}

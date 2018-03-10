package com.xyh.wechat.convertor.platform;

import com.xyh.wechat.jpa.entities.WxPlatformRole;
import com.xyh.wechat.vo.platform.PlatformRoleCriteriaVo;
import com.xyh.wechat.vo.platform.PlatformRoleVo;
import com.xyh.wechat.web.model.platform.PlatformRoleCriteriaModel;
import com.xyh.wechat.web.model.platform.PlatformRoleModel;

public class PlatformRoleConvertor {
	/**
	 * 
	 * @param platformRoleCriteriaModel
	 * @return
	 */
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
	
	/**
	 * 
	 * @param wxPlatformRole
	 * @return
	 */
	public static PlatformRoleVo convertToVo(WxPlatformRole wxPlatformRole) {
		PlatformRoleVo platformRoleVo = null;
		
		if (wxPlatformRole != null) {
			platformRoleVo = new PlatformRoleVo();
			platformRoleVo.setId(wxPlatformRole.getRoleId());
			platformRoleVo.setRolename(wxPlatformRole.getRolename());
			platformRoleVo.setRoledesc(wxPlatformRole.getRoledesc());
			platformRoleVo.setDisabled(wxPlatformRole.isDisabled());
			platformRoleVo.setDeleted(wxPlatformRole.isDeleted());
			platformRoleVo.setUpdatedTime(wxPlatformRole.getUpdatedTime().toString());
			platformRoleVo.setCreatedTime(wxPlatformRole.getCreatedTime().toString());
		}
		
		return platformRoleVo;
	}
	
	/**
	 * 
	 * @param platformRoleModel
	 * @return
	 */
	public static PlatformRoleVo convertToVo(PlatformRoleModel platformRoleModel) {
		PlatformRoleVo platformRoleVo = null;
		
		if (platformRoleModel != null) {
			platformRoleVo = new PlatformRoleVo();
			platformRoleVo.setId(platformRoleModel.getId());
			platformRoleVo.setRolename(platformRoleModel.getRolename());
			platformRoleVo.setRoledesc(platformRoleModel.getRoledesc());
			platformRoleVo.setDisabled(platformRoleModel.isDisabled());
			platformRoleVo.setDeleted(platformRoleModel.isDeleted());
			platformRoleVo.setUpdatedTime(platformRoleModel.getUpdatedTime());
			platformRoleVo.setCreatedTime(platformRoleModel.getCreatedTime());
		}
		
		return platformRoleVo;
	}
	
	/**
	 * 
	 * @param platformRoleVo
	 * @return
	 */
	public static WxPlatformRole convertToEntity(PlatformRoleVo platformRoleVo) {
		WxPlatformRole wxPlatformRole = null;
		
		if (platformRoleVo != null) {
			wxPlatformRole = new WxPlatformRole();
			wxPlatformRole.setRoleId(platformRoleVo.getId());
			wxPlatformRole.setRoleName(platformRoleVo.getRolename());
			wxPlatformRole.setRoledesc(platformRoleVo.getRoledesc());
			wxPlatformRole.setDisabled(platformRoleVo.isDisabled());
			wxPlatformRole.setDeleted(platformRoleVo.isDeleted());
			//wxPlatformRole.setAdgroups(adgroups);
		}
		
		return wxPlatformRole;
	}
	
	/**
	 * Convert platform role value object to platform role mvc data model
	 * @param platformRoleVo Platform role value object
	 * @return Platform role mvc data model
	 */
	public static PlatformRoleModel convertToModel(PlatformRoleVo platformRoleVo) {
		PlatformRoleModel platformRoleModel = null;
		
		if (platformRoleVo != null) {
			platformRoleModel = new PlatformRoleModel();
			platformRoleModel.setId(platformRoleVo.getId());
			platformRoleModel.setRolename(platformRoleVo.getRolename());
			platformRoleModel.setRoledesc(platformRoleVo.getRoledesc());
			platformRoleModel.setDisabled(platformRoleVo.isDisabled());
			platformRoleModel.setDeleted(platformRoleVo.isDeleted());
			platformRoleModel.setCreatedTime(platformRoleVo.getCreatedTime());
			platformRoleModel.setUpdatedTime(platformRoleVo.getUpdatedTime());
		}
		
		return platformRoleModel;
	}
}

package com.xyh.wechat.convertor.service;

import com.xyh.wechat.convertor.BaseConvertor;
import com.xyh.wechat.jpa.entities.WxPlatformLegalEntity;
import com.xyh.wechat.jpa.entities.WxServiceAccount;
import com.xyh.wechat.vo.service.ServiceAccountVo;
import com.xyh.wechat.web.model.service.ServiceAccountModel;

public class ServiceAccountConvertor extends BaseConvertor {
	public static ServiceAccountVo convertToVo(WxServiceAccount wxServiceAccount) {
		ServiceAccountVo serviceAccountVo = null;
		
		if (wxServiceAccount != null) {
			serviceAccountVo = new ServiceAccountVo();
			serviceAccountVo.setId(wxServiceAccount.getAccountId());
			serviceAccountVo.setLegalEntityId(wxServiceAccount.getLegalEntity().getLegalEntityId());
			serviceAccountVo.setAccountName(wxServiceAccount.getAccountName());
			serviceAccountVo.setAccountDesc(wxServiceAccount.getAccountDesc());
			serviceAccountVo.setDisabled(wxServiceAccount.isDisabled());
			serviceAccountVo.setDeleted(wxServiceAccount.isDeleted());
			//serviceAccountVo.setCreatedTime(wxServiceAccount.getCreatedTime().toString());
			//serviceAccountVo.setUpdatedTime(wxServiceAccount.getUpdatedTime().toString());
		}
		return serviceAccountVo;
	}
	
	public static WxServiceAccount convertToEntity(ServiceAccountVo serviceAccountVo) {
		WxServiceAccount wxServiceAccount = null;
		WxPlatformLegalEntity wxPlatformLegalEntity = null;
		
		if (serviceAccountVo != null) {
			wxServiceAccount = new WxServiceAccount();
			if (serviceAccountVo.getId() > 0) wxServiceAccount.setAccountId(serviceAccountVo.getId());
			wxServiceAccount.setAccountName(serviceAccountVo.getAccountName());
			wxServiceAccount.setAccountDesc(serviceAccountVo.getAccountDesc());
			wxServiceAccount.setDisabled(serviceAccountVo.isDisabled());
			wxServiceAccount.setDeleted(serviceAccountVo.isDeleted());
			wxPlatformLegalEntity = new WxPlatformLegalEntity();
			wxPlatformLegalEntity.setLegalEntityId(serviceAccountVo.getLegalEntityId());
			wxServiceAccount.setLegalEntity(wxPlatformLegalEntity);
		}		
		return wxServiceAccount;
	}
	
	public static ServiceAccountModel convertToModel(ServiceAccountVo serviceAccountVo) {
		ServiceAccountModel serviceAccountModel = null;
		
		if (serviceAccountVo != null) {
			serviceAccountModel = new ServiceAccountModel();
			serviceAccountModel.setId(serviceAccountVo.getId());
			serviceAccountModel.setLegalEntityId(serviceAccountVo.getLegalEntityId());
			serviceAccountModel.setAccountName(serviceAccountVo.getAccountName());
			serviceAccountModel.setAccountDesc(serviceAccountVo.getAccountDesc());
			serviceAccountModel.setDeleted(serviceAccountVo.isDeleted());
			serviceAccountModel.setDisabled(serviceAccountVo.isDisabled());
			serviceAccountModel.setCreatedTime(serviceAccountVo.getCreatedTime());
			serviceAccountModel.setUpdatedTime(serviceAccountVo.getUpdatedTime());
		}
		
		return serviceAccountModel;
	}
	
	public static ServiceAccountVo convertToVo(ServiceAccountModel serviceAccountModel) {
		ServiceAccountVo serviceAccountVo = null;
		
		if (serviceAccountModel != null) {
			serviceAccountVo = new ServiceAccountVo();
			serviceAccountVo.setId(serviceAccountModel.getId());
			serviceAccountVo.setLegalEntityId(serviceAccountModel.getLegalEntityId());
			serviceAccountVo.setAccountName(serviceAccountModel.getAccountName());
			serviceAccountVo.setAccountDesc(serviceAccountModel.getAccountDesc());
			serviceAccountVo.setDisabled(serviceAccountModel.isDeleted());
			serviceAccountVo.setDeleted(serviceAccountModel.isDisabled());
			serviceAccountVo.setCreatedTime(serviceAccountModel.getCreatedTime());
			serviceAccountVo.setUpdatedTime(serviceAccountModel.getUpdatedTime());
		}
		
		return serviceAccountVo;
	}
}

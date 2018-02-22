package com.xyh.wechat.convertor.subscription;

import com.xyh.wechat.convertor.BaseConvertor;
import com.xyh.wechat.jpa.entities.WxPlatformLegalEntity;
import com.xyh.wechat.jpa.entities.WxSubscriptionAccount;
import com.xyh.wechat.vo.subscription.SubscriptionAccountVo;

public class SubscriptionAccountConvertor extends BaseConvertor {
	public static SubscriptionAccountVo convertToVo(WxSubscriptionAccount wxSubscriptionAccount) {
		SubscriptionAccountVo subscriptionAccountVo = null;
		
		if (wxSubscriptionAccount != null) {
			subscriptionAccountVo = new SubscriptionAccountVo();
			subscriptionAccountVo.setId(wxSubscriptionAccount.getAccountId());
			subscriptionAccountVo.setLegalEntityId(wxSubscriptionAccount.getLegalEntity().getLegalEntityId());
			subscriptionAccountVo.setAccountName(wxSubscriptionAccount.getAccountName());
			subscriptionAccountVo.setAccountDesc(wxSubscriptionAccount.getAccountDesc());
			subscriptionAccountVo.setDisabled(wxSubscriptionAccount.isDisabled());
			subscriptionAccountVo.setDeleted(wxSubscriptionAccount.isDeleted());
			subscriptionAccountVo.setCreatedTime(wxSubscriptionAccount.getCreatedTime().toString());
			subscriptionAccountVo.setUpdatedTime(wxSubscriptionAccount.getUpdatedTime().toString());
		}
		return subscriptionAccountVo;
	}
	
	public static WxSubscriptionAccount convertToEntity(SubscriptionAccountVo subscriptionAccountVo) {
		WxSubscriptionAccount wxSubscriptionAccount = null;
		WxPlatformLegalEntity wxPlatformLegalEntity = null;
		
		if (subscriptionAccountVo != null) {
			wxSubscriptionAccount = new WxSubscriptionAccount();
			wxSubscriptionAccount.setAccountId(subscriptionAccountVo.getId());
			wxSubscriptionAccount.setAccountName(subscriptionAccountVo.getAccountName());
			wxSubscriptionAccount.setAccountDesc(subscriptionAccountVo.getAccountDesc());
			wxSubscriptionAccount.setDisabled(subscriptionAccountVo.isDisabled());
			wxSubscriptionAccount.setDeleted(subscriptionAccountVo.isDeleted());
			wxPlatformLegalEntity = new WxPlatformLegalEntity();
			wxPlatformLegalEntity.setLegalEntityId(subscriptionAccountVo.getLegalEntityId());
			wxSubscriptionAccount.setLegalEntity(wxPlatformLegalEntity);
		}
		
		return wxSubscriptionAccount;
	}
}

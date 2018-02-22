package com.xyh.wechat.convertor.enterprise;

import com.xyh.wechat.convertor.BaseConvertor;
import com.xyh.wechat.jpa.entities.WxEnterpriseAccount;
import com.xyh.wechat.jpa.entities.WxEnterpriseSubaccount;
import com.xyh.wechat.jpa.entities.WxPlatformLegalEntity;
import com.xyh.wechat.vo.enterprise.EnterpriseAccountVo;
import com.xyh.wechat.vo.enterprise.EnterpriseSubaccountVo;

public class EnterpriseAccountConvertor extends BaseConvertor {
	public static EnterpriseAccountVo convertToVo(WxEnterpriseAccount wxEnterpriseAccount) {
		EnterpriseAccountVo enterpriseAccountVo = null;
		
		if (wxEnterpriseAccount != null) {
			enterpriseAccountVo = new EnterpriseAccountVo();
			enterpriseAccountVo.setId(wxEnterpriseAccount.getAccountId());
			enterpriseAccountVo.setLegalEntityId(wxEnterpriseAccount.getLegalEntity().getLegalEntityId());
			enterpriseAccountVo.setAccountName(wxEnterpriseAccount.getAccountName());
			enterpriseAccountVo.setAccountDesc(wxEnterpriseAccount.getAccountDesc());
			enterpriseAccountVo.setDisabled(wxEnterpriseAccount.isDisabled());
			enterpriseAccountVo.setDeleted(wxEnterpriseAccount.isDeleted());
			enterpriseAccountVo.setCreatedTime(wxEnterpriseAccount.getCreatedTime().toString());
			enterpriseAccountVo.setUpdatedTime(wxEnterpriseAccount.getUpdatedTime().toString());
		}
		return enterpriseAccountVo;
	}
	
	public static WxEnterpriseAccount convertToEntity(EnterpriseAccountVo enterpriseAccountVo) {
		WxEnterpriseAccount wxEnterpriseAccount  = null;
		WxPlatformLegalEntity wxPlatformLegalEntity = null;
		
		if (enterpriseAccountVo != null) {
			wxEnterpriseAccount = new WxEnterpriseAccount();
			wxEnterpriseAccount.setAccountId(enterpriseAccountVo.getId());
			wxEnterpriseAccount.setAccountName(enterpriseAccountVo.getAccountName());
			wxEnterpriseAccount.setAccountDesc(enterpriseAccountVo.getAccountDesc());
			wxEnterpriseAccount.setDisabled(enterpriseAccountVo.isDisabled());
			wxEnterpriseAccount.setDeleted(enterpriseAccountVo.isDeleted());
			wxPlatformLegalEntity = new WxPlatformLegalEntity();
			wxPlatformLegalEntity.setLegalEntityId(enterpriseAccountVo.getLegalEntityId());
			wxEnterpriseAccount.setLegalEntity(wxPlatformLegalEntity);
		}
		return wxEnterpriseAccount;
	}
	
	public static EnterpriseSubaccountVo convertToVo(WxEnterpriseSubaccount wxEnterpriseSubaccount) {
		EnterpriseSubaccountVo enterpriseSubaccountVo = null;
		
		if (wxEnterpriseSubaccount != null) {
			enterpriseSubaccountVo = new EnterpriseSubaccountVo();
			enterpriseSubaccountVo.setId(wxEnterpriseSubaccount.getSubaccountId());
			enterpriseSubaccountVo.setSubaccountName(wxEnterpriseSubaccount.getSubaccountName());
			enterpriseSubaccountVo.setSubaccountDesc(wxEnterpriseSubaccount.getSubaccountDesc());
			enterpriseSubaccountVo.setDisabled(wxEnterpriseSubaccount.isDisabled());
			enterpriseSubaccountVo.setDeleted(wxEnterpriseSubaccount.isDeleted());
			enterpriseSubaccountVo.setCreatedTime(wxEnterpriseSubaccount.getCreatedTime().toString());
			enterpriseSubaccountVo.setUpdatedTime(wxEnterpriseSubaccount.getUpdatedTime().toString());
			enterpriseSubaccountVo.setParentAccount(convertToVo(wxEnterpriseSubaccount.getParentAccount()));
		}
		return enterpriseSubaccountVo;
	}
	
	public static WxEnterpriseSubaccount convertToEntity(EnterpriseSubaccountVo enterpriseSubaccountVo) {
		WxEnterpriseSubaccount wxEnterpriseSubaccount  = null;
		
		if (enterpriseSubaccountVo != null) {
			wxEnterpriseSubaccount = new WxEnterpriseSubaccount();
			wxEnterpriseSubaccount.setSubaccountId(enterpriseSubaccountVo.getId());
			wxEnterpriseSubaccount.setSubaccountName(enterpriseSubaccountVo.getSubaccountName());
			wxEnterpriseSubaccount.setSubaccountDesc(enterpriseSubaccountVo.getSubaccountDesc());
			wxEnterpriseSubaccount.setDisabled(enterpriseSubaccountVo.isDisabled());
			wxEnterpriseSubaccount.setDeleted(enterpriseSubaccountVo.isDeleted());
			wxEnterpriseSubaccount.setParentAccount(convertToEntity(enterpriseSubaccountVo.getParentAccount()));
		}
		return wxEnterpriseSubaccount;
	}
}

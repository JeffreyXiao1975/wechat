package com.xyh.wechat.dao.enterprise;

import java.util.List;

import com.xyh.wechat.jpa.entities.WxEnterpriseAccount;
import com.xyh.wechat.jpa.entities.WxEnterpriseSubaccount;

public interface IEnterpriseAccountDao {
	public List<WxEnterpriseAccount> getAllEnterpriseAccounts(boolean includeDisabled, boolean includeDeleted);
	public WxEnterpriseAccount getEnterpriseAccountbyId(long accountId);
	public WxEnterpriseAccount getEnterpriseAccountbyName(String accountName);
	public WxEnterpriseAccount createEnterpriseAccount(WxEnterpriseAccount wxEnterpriseAccount);
	public WxEnterpriseAccount updateEnterpriseAccount(WxEnterpriseAccount wxEnterpriseAccount);
	
	public List<WxEnterpriseSubaccount> getAllEnterpriseSubaccounts(long parentAccountId, boolean includeDisabled, boolean includeDeleted);
	public WxEnterpriseSubaccount getEnterpriseSubaccountbyId(long subaccountId);
	public WxEnterpriseSubaccount createEnterpriseSubAccount(WxEnterpriseSubaccount wxEnterpriseSubaccount);
	public WxEnterpriseSubaccount updateEnterpriseSubaccount(WxEnterpriseSubaccount wxEnterpriseSubaccount);
}

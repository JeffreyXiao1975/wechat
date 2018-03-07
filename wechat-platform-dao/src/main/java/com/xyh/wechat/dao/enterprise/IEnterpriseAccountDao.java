package com.xyh.wechat.dao.enterprise;

import java.util.List;

import com.xyh.wechat.jpa.entities.WxEnterpriseAccount;
import com.xyh.wechat.jpa.entities.WxEnterpriseSubaccount;

public interface IEnterpriseAccountDao {
	public List<WxEnterpriseAccount> getAllEnterpriseAccounts(boolean includeDisabled, boolean includeDeleted);
	public WxEnterpriseAccount getEnterpriseAccountbyId(long accountId);
	public WxEnterpriseAccount getEnterpriseAccountbyName(String accountName);
	public void createEnterpriseAccount(WxEnterpriseAccount wxEnterpriseAccount);
	public void updateEnterpriseAccount(WxEnterpriseAccount wxEnterpriseAccount);
	
	public List<WxEnterpriseSubaccount> getAllEnterpriseSubaccounts(long parentAccountId, boolean includeDisabled, boolean includeDeleted);
	public WxEnterpriseSubaccount getEnterpriseSubaccountbyId(long subaccountId);
	public void createEnterpriseSubAccount(WxEnterpriseSubaccount wxEnterpriseSubaccount);
	public void updateEnterpriseSubaccount(WxEnterpriseSubaccount wxEnterpriseSubaccount);
}

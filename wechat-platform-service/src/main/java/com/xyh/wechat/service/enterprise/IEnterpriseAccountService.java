package com.xyh.wechat.service.enterprise;

import java.util.List;

import com.xyh.wechat.vo.enterprise.EnterpriseAccountVo;
import com.xyh.wechat.vo.enterprise.EnterpriseSubaccountVo;

public interface IEnterpriseAccountService {
	public List<EnterpriseAccountVo> getAllEnterpriseAccounts(boolean includeDisabled, boolean includeDeleted);
	public EnterpriseAccountVo getEnterpriseAccountbyId(long accountId);
	public EnterpriseAccountVo getEnterpriseAccountbyName(String accountName);
	public void createEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo);
	public void updateEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo);
	public void deleteEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo);
	public void disableEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo);
	public void enableEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo);
	
	public List<EnterpriseSubaccountVo> getAllEnterpriseSubaccounts(long parentAccountId, boolean includeDisabled, boolean includeDeleted);
	public EnterpriseSubaccountVo getEnterpriseSubaccountbyId(long subaccountId);
	public void createEnterpriseSubAccount(EnterpriseSubaccountVo enterpriseSubaccountVo);
	public void updateEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo);
	public void deleteEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo);
	public void disableEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo);
	public void enableEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo);
}

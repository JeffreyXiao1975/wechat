package com.xyh.wechat.service.enterprise;

import java.util.List;

import com.xyh.wechat.vo.enterprise.EnterpriseAccountVo;
import com.xyh.wechat.vo.enterprise.EnterpriseSubaccountVo;

public interface IEnterpriseAccountService {
	public List<EnterpriseAccountVo> getAllEnterpriseAccounts(boolean includeDisabled, boolean includeDeleted);
	public EnterpriseAccountVo getEnterpriseAccountbyId(long accountId);
	public EnterpriseAccountVo getEnterpriseAccountbyName(String accountName);
	public EnterpriseAccountVo createEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo);
	public EnterpriseAccountVo updateEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo);
	public EnterpriseAccountVo deleteEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo);
	public EnterpriseAccountVo disableEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo);
	public EnterpriseAccountVo enableEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo);
	
	public List<EnterpriseSubaccountVo> getAllEnterpriseSubaccounts(long parentAccountId, boolean includeDisabled, boolean includeDeleted);
	public EnterpriseSubaccountVo getEnterpriseSubaccountbyId(long subaccountId);
	public EnterpriseSubaccountVo createEnterpriseSubAccount(EnterpriseSubaccountVo enterpriseSubaccountVo);
	public EnterpriseSubaccountVo updateEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo);
	public EnterpriseSubaccountVo deleteEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo);
	public EnterpriseSubaccountVo disableEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo);
	public EnterpriseSubaccountVo enableEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo);
}

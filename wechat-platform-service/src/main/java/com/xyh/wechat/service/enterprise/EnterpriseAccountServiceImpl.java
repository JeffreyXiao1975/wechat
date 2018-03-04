/**
 * 
 */
package com.xyh.wechat.service.enterprise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.convertor.enterprise.EnterpriseAccountConvertor;
import com.xyh.wechat.dao.enterprise.IEnterpriseAccountDao;
import com.xyh.wechat.jpa.entities.WxEnterpriseAccount;
import com.xyh.wechat.jpa.entities.WxEnterpriseSubaccount;
import com.xyh.wechat.service.BaseService;
import com.xyh.wechat.vo.enterprise.EnterpriseAccountVo;
import com.xyh.wechat.vo.enterprise.EnterpriseSubaccountVo;

@Service("enterpriseAccountService")
public class EnterpriseAccountServiceImpl extends BaseService implements IEnterpriseAccountService {
	@Autowired 
	private IEnterpriseAccountDao enterpriseAccountDao;

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<EnterpriseAccountVo> getAllEnterpriseAccounts(boolean includeDisabled, boolean includeDeleted) {
		List<WxEnterpriseAccount> wxEnterpriseAccounts = null;
		List<EnterpriseAccountVo> enterpriseAccountVos = null;
		
		wxEnterpriseAccounts = enterpriseAccountDao.getAllEnterpriseAccounts(includeDisabled, includeDeleted);
		if (wxEnterpriseAccounts != null && wxEnterpriseAccounts.size() > 0) {
			enterpriseAccountVos = new ArrayList<EnterpriseAccountVo>();
			Iterator<WxEnterpriseAccount> iterator = wxEnterpriseAccounts.iterator();
			while (iterator.hasNext()) {
				WxEnterpriseAccount wxEnterpriseAccount = iterator.next();
				enterpriseAccountVos.add(EnterpriseAccountConvertor.convertToVo(wxEnterpriseAccount));
			}
		}
		return enterpriseAccountVos;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public EnterpriseAccountVo getEnterpriseAccountbyId(long accountId) {
		WxEnterpriseAccount wxEnterpriseAccount = null;
		EnterpriseAccountVo enterpriseAccountVo = null;
		
		wxEnterpriseAccount = enterpriseAccountDao.getEnterpriseAccountbyId(accountId);
		enterpriseAccountVo = EnterpriseAccountConvertor.convertToVo(wxEnterpriseAccount);
		return enterpriseAccountVo;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public EnterpriseAccountVo getEnterpriseAccountbyName(String accountName) {
		WxEnterpriseAccount wxEnterpriseAccount = null;
		
		wxEnterpriseAccount = enterpriseAccountDao.getEnterpriseAccountbyName(accountName);
		return EnterpriseAccountConvertor.convertToVo(wxEnterpriseAccount);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public EnterpriseAccountVo createEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo) {
		WxEnterpriseAccount wxEnterpriseAccount = null;
		
		wxEnterpriseAccount = EnterpriseAccountConvertor.convertToEntity(enterpriseAccountVo);
		wxEnterpriseAccount = enterpriseAccountDao.createEnterpriseAccount(wxEnterpriseAccount);
		return EnterpriseAccountConvertor.convertToVo(wxEnterpriseAccount);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public EnterpriseAccountVo updateEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo) {
		WxEnterpriseAccount wxEnterpriseAccount = null;
		
		wxEnterpriseAccount = enterpriseAccountDao.getEnterpriseAccountbyId(enterpriseAccountVo.getId());
		if (wxEnterpriseAccount != null) {
			wxEnterpriseAccount.setAccountName(enterpriseAccountVo.getAccountName());
			wxEnterpriseAccount.setAccountDesc(enterpriseAccountVo.getAccountDesc());
			wxEnterpriseAccount.setDisabled(enterpriseAccountVo.isDisabled());
			wxEnterpriseAccount.setDeleted(enterpriseAccountVo.isDeleted());
			wxEnterpriseAccount = enterpriseAccountDao.updateEnterpriseAccount(wxEnterpriseAccount);
		}
		
		return EnterpriseAccountConvertor.convertToVo(wxEnterpriseAccount);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public EnterpriseAccountVo deleteEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo) {
		WxEnterpriseAccount wxEnterpriseAccount = null;
		List<WxEnterpriseSubaccount> wxEnterpriseSubaccounts = null;
		
		wxEnterpriseAccount = enterpriseAccountDao.getEnterpriseAccountbyId(enterpriseAccountVo.getId());
		wxEnterpriseSubaccounts = enterpriseAccountDao.getAllEnterpriseSubaccounts(enterpriseAccountVo.getId(), true, false);
		if (wxEnterpriseSubaccounts != null && wxEnterpriseSubaccounts.size() > 0) {
			Iterator<WxEnterpriseSubaccount> iterator = wxEnterpriseSubaccounts.iterator();
			while (iterator.hasNext()) {
				WxEnterpriseSubaccount wxEnterpriseSubaccount = iterator.next();
				wxEnterpriseSubaccount.setDeleted(true);
				enterpriseAccountDao.updateEnterpriseSubaccount(wxEnterpriseSubaccount);
			}
		}
		wxEnterpriseAccount.setDeleted(true);
		wxEnterpriseAccount = enterpriseAccountDao.updateEnterpriseAccount(wxEnterpriseAccount);
		return EnterpriseAccountConvertor.convertToVo(wxEnterpriseAccount);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public EnterpriseAccountVo disableEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo) {
		WxEnterpriseAccount wxEnterpriseAccount = null;
		List<WxEnterpriseSubaccount> wxEnterpriseSubaccounts = null;
		
		wxEnterpriseAccount = enterpriseAccountDao.getEnterpriseAccountbyId(enterpriseAccountVo.getId());
		wxEnterpriseSubaccounts = enterpriseAccountDao.getAllEnterpriseSubaccounts(enterpriseAccountVo.getId(), false, true);
		if (wxEnterpriseSubaccounts != null && wxEnterpriseSubaccounts.size() > 0) {
			Iterator<WxEnterpriseSubaccount> iterator = wxEnterpriseSubaccounts.iterator();
			while (iterator.hasNext()) {
				WxEnterpriseSubaccount wxEnterpriseSubaccount = iterator.next();
				wxEnterpriseSubaccount.setDisabled(true);
				enterpriseAccountDao.updateEnterpriseSubaccount(wxEnterpriseSubaccount);
			}
		}
		wxEnterpriseAccount.setDisabled(true);
		wxEnterpriseAccount = enterpriseAccountDao.updateEnterpriseAccount(wxEnterpriseAccount);
		return EnterpriseAccountConvertor.convertToVo(wxEnterpriseAccount);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public EnterpriseAccountVo enableEnterpriseAccount(EnterpriseAccountVo enterpriseAccountVo) {
		WxEnterpriseAccount wxEnterpriseAccount = null;
		
		wxEnterpriseAccount = enterpriseAccountDao.getEnterpriseAccountbyId(enterpriseAccountVo.getId());
		wxEnterpriseAccount.setDisabled(false);
		wxEnterpriseAccount = enterpriseAccountDao.updateEnterpriseAccount(wxEnterpriseAccount);
		return EnterpriseAccountConvertor.convertToVo(wxEnterpriseAccount);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<EnterpriseSubaccountVo> getAllEnterpriseSubaccounts(long parentAccountId, boolean includeDisabled,
			boolean includeDeleted) {
		List<EnterpriseSubaccountVo> enterpriseSubaccountVos = null;
		List<WxEnterpriseSubaccount> wxEnterpriseSubaccounts = null;
		
		wxEnterpriseSubaccounts = enterpriseAccountDao.getAllEnterpriseSubaccounts(parentAccountId, includeDisabled, includeDeleted);
		if (wxEnterpriseSubaccounts != null && wxEnterpriseSubaccounts.size() > 0) {
			enterpriseSubaccountVos = new ArrayList<EnterpriseSubaccountVo>();
			Iterator<WxEnterpriseSubaccount> iterator = wxEnterpriseSubaccounts.iterator();
			while (iterator.hasNext()) {
				WxEnterpriseSubaccount wxEnterpriseSubaccount = iterator.next();
				enterpriseSubaccountVos.add(EnterpriseAccountConvertor.convertToVo(wxEnterpriseSubaccount));
			}
		}
		return enterpriseSubaccountVos;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public EnterpriseSubaccountVo getEnterpriseSubaccountbyId(long subaccountId) {
		EnterpriseSubaccountVo enterpriseSubaccountVo = null;
		WxEnterpriseSubaccount wxEnterpriseSubaccount = null;
		
		wxEnterpriseSubaccount = enterpriseAccountDao.getEnterpriseSubaccountbyId(subaccountId);
		enterpriseSubaccountVo = EnterpriseAccountConvertor.convertToVo(wxEnterpriseSubaccount);
		return enterpriseSubaccountVo;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public EnterpriseSubaccountVo createEnterpriseSubAccount(EnterpriseSubaccountVo enterpriseSubaccountVo) {
		WxEnterpriseAccount wxEnterpriseAccount = null;
		WxEnterpriseSubaccount wxEnterpriseSubaccount = null;

		wxEnterpriseAccount = enterpriseAccountDao.getEnterpriseAccountbyId(enterpriseSubaccountVo.getParentAccount().getId());
		if (wxEnterpriseAccount != null) {
			wxEnterpriseSubaccount = EnterpriseAccountConvertor.convertToEntity(enterpriseSubaccountVo);
			wxEnterpriseSubaccount.setParentAccount(wxEnterpriseAccount);
			wxEnterpriseSubaccount = enterpriseAccountDao.createEnterpriseSubAccount(wxEnterpriseSubaccount);
		}
		return EnterpriseAccountConvertor.convertToVo(wxEnterpriseSubaccount);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public EnterpriseSubaccountVo updateEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo) {
		WxEnterpriseAccount wxEnterpriseAccount = null;
		WxEnterpriseSubaccount wxEnterpriseSubaccount = null;

		wxEnterpriseAccount = enterpriseAccountDao.getEnterpriseAccountbyId(enterpriseSubaccountVo.getParentAccount().getId());
		if (wxEnterpriseAccount != null) {
			wxEnterpriseSubaccount = enterpriseAccountDao.getEnterpriseSubaccountbyId(enterpriseSubaccountVo.getId());
			if (wxEnterpriseSubaccount != null) {
				wxEnterpriseSubaccount.setParentAccount(wxEnterpriseAccount);
				wxEnterpriseSubaccount.setSubaccountName(enterpriseSubaccountVo.getSubaccountName());
				wxEnterpriseSubaccount.setSubaccountDesc(enterpriseSubaccountVo.getSubaccountDesc());
				wxEnterpriseSubaccount.setDisabled(enterpriseSubaccountVo.isDisabled());
				wxEnterpriseSubaccount.setDeleted(enterpriseSubaccountVo.isDeleted());
				wxEnterpriseSubaccount = enterpriseAccountDao.createEnterpriseSubAccount(wxEnterpriseSubaccount);
			}
		}
		return EnterpriseAccountConvertor.convertToVo(wxEnterpriseSubaccount);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public EnterpriseSubaccountVo deleteEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo) {
		WxEnterpriseSubaccount wxEnterpriseSubaccount = null;		
		
		wxEnterpriseSubaccount = enterpriseAccountDao.getEnterpriseSubaccountbyId(enterpriseSubaccountVo.getId());
		wxEnterpriseSubaccount.setDeleted(true);
		wxEnterpriseSubaccount = enterpriseAccountDao.updateEnterpriseSubaccount(wxEnterpriseSubaccount);
		return EnterpriseAccountConvertor.convertToVo(wxEnterpriseSubaccount);
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public EnterpriseSubaccountVo disableEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo) {
		WxEnterpriseSubaccount wxEnterpriseSubaccount = null;		
		
		wxEnterpriseSubaccount = enterpriseAccountDao.getEnterpriseSubaccountbyId(enterpriseSubaccountVo.getId());
		wxEnterpriseSubaccount.setDisabled(true);
		wxEnterpriseSubaccount = enterpriseAccountDao.updateEnterpriseSubaccount(wxEnterpriseSubaccount);
		return EnterpriseAccountConvertor.convertToVo(wxEnterpriseSubaccount);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public EnterpriseSubaccountVo enableEnterpriseSubaccount(EnterpriseSubaccountVo enterpriseSubaccountVo) {
		WxEnterpriseSubaccount wxEnterpriseSubaccount = null;		
		
		wxEnterpriseSubaccount = enterpriseAccountDao.getEnterpriseSubaccountbyId(enterpriseSubaccountVo.getId());
		wxEnterpriseSubaccount.setDisabled(false);
		wxEnterpriseSubaccount = enterpriseAccountDao.updateEnterpriseSubaccount(wxEnterpriseSubaccount);
		return EnterpriseAccountConvertor.convertToVo(wxEnterpriseSubaccount);
	}
}

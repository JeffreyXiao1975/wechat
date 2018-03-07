package com.xyh.wechat.service.subscription;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.convertor.subscription.SubscriptionAccountConvertor;
import com.xyh.wechat.dao.subscription.ISubscriptionAccountDao;
import com.xyh.wechat.jpa.entities.WxSubscriptionAccount;
import com.xyh.wechat.service.BaseService;
import com.xyh.wechat.vo.subscription.SubscriptionAccountVo;

@Service("subscriptionAccountService")
public class SubscriptionAccountServiceImpl extends BaseService implements ISubscriptionAccountService {
	@Autowired 
	private ISubscriptionAccountDao subscriptionAccountDao;

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SubscriptionAccountVo> getAllSubscriptionAccounts(boolean includeDisabled, boolean includeDeleted) {
		List<WxSubscriptionAccount> wxSubscriptionAccounts = null;
		List<SubscriptionAccountVo> subscriptionAccountVos = null;
		
		wxSubscriptionAccounts = subscriptionAccountDao.getAllSubscriptionAccounts(includeDisabled, includeDeleted);
		if (wxSubscriptionAccounts != null && wxSubscriptionAccounts.size() > 0) {
			subscriptionAccountVos = new ArrayList<SubscriptionAccountVo> ();
			Iterator<WxSubscriptionAccount> iterator = wxSubscriptionAccounts.iterator();
			while (iterator.hasNext()) {
				WxSubscriptionAccount wxSubscriptionAccount = iterator.next();
				subscriptionAccountVos.add(SubscriptionAccountConvertor.convertToVo(wxSubscriptionAccount));
			}
		}
		return subscriptionAccountVos;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public SubscriptionAccountVo getSubscriptionAccountbyId(long accountId) {
		WxSubscriptionAccount wxSubscriptionAccount = null;
		
		wxSubscriptionAccount = subscriptionAccountDao.getSubscriptionAccountbyId(accountId);
		return SubscriptionAccountConvertor.convertToVo(wxSubscriptionAccount);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public SubscriptionAccountVo getSubscriptionAccountbyName(String accountName) {
		WxSubscriptionAccount wxSubscriptionAccount = null;
		
		wxSubscriptionAccount = subscriptionAccountDao.getSubscriptionAccountbyName(accountName);
		return SubscriptionAccountConvertor.convertToVo(wxSubscriptionAccount);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void createSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo) {
		WxSubscriptionAccount wxSubscriptionAccount = null;
		
		wxSubscriptionAccount = SubscriptionAccountConvertor.convertToEntity(subscriptionAccountVo);
		subscriptionAccountDao.createSubscriptionAccount(wxSubscriptionAccount);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo) {
		WxSubscriptionAccount wxSubscriptionAccount = null;
		
		wxSubscriptionAccount = subscriptionAccountDao.getSubscriptionAccountbyId(subscriptionAccountVo.getId());
		if (wxSubscriptionAccount != null) {
			wxSubscriptionAccount.setAccountName(subscriptionAccountVo.getAccountName());
			wxSubscriptionAccount.setAccountDesc(subscriptionAccountVo.getAccountDesc());
			wxSubscriptionAccount.setDisabled(subscriptionAccountVo.isDisabled());
			wxSubscriptionAccount.setDeleted(subscriptionAccountVo.isDeleted());
			subscriptionAccountDao.updateSubscriptionAccount(wxSubscriptionAccount);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo) {
		WxSubscriptionAccount wxSubscriptionAccount = null;
		
		wxSubscriptionAccount = subscriptionAccountDao.getSubscriptionAccountbyId(subscriptionAccountVo.getId());
		wxSubscriptionAccount.setDeleted(true);
		subscriptionAccountDao.updateSubscriptionAccount(wxSubscriptionAccount);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void disableSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo) {
		WxSubscriptionAccount wxSubscriptionAccount = null;
		
		wxSubscriptionAccount = subscriptionAccountDao.getSubscriptionAccountbyId(subscriptionAccountVo.getId());
		wxSubscriptionAccount.setDisabled(true);
		subscriptionAccountDao.updateSubscriptionAccount(wxSubscriptionAccount);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void enableSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo) {
		WxSubscriptionAccount wxSubscriptionAccount = null;
		
		wxSubscriptionAccount = subscriptionAccountDao.getSubscriptionAccountbyId(subscriptionAccountVo.getId());
		wxSubscriptionAccount.setDisabled(false);
		subscriptionAccountDao.updateSubscriptionAccount(wxSubscriptionAccount);
	}
}

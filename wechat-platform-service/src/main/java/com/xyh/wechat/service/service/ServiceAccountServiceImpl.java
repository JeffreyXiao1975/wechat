package com.xyh.wechat.service.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xyh.wechat.convertor.service.ServiceAccountConvertor;
import com.xyh.wechat.dao.service.IServiceAccountDao;
import com.xyh.wechat.jpa.entities.WxServiceAccount;
import com.xyh.wechat.service.BaseService;
import com.xyh.wechat.vo.service.ServiceAccountVo;

@Service("serviceAccountService")
public class ServiceAccountServiceImpl extends BaseService implements IServiceAccountService {
	@Autowired
	private IServiceAccountDao serviceAccountDao;
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<ServiceAccountVo> getAllServiceAccounts(boolean includeDisabled, boolean includeDeleted) {
		List<ServiceAccountVo> serviceAccountVos = null;
		List<WxServiceAccount> wxServiceAccounts = null;
		
		wxServiceAccounts = serviceAccountDao.getAllServiceAccounts(includeDisabled, includeDeleted);
		if (wxServiceAccounts != null && wxServiceAccounts.size() > 0) {
			serviceAccountVos = new ArrayList<ServiceAccountVo>();
			Iterator<WxServiceAccount> iterator = wxServiceAccounts.iterator();
			while (iterator.hasNext()) {
				WxServiceAccount wxServiceAccount = iterator.next();
				serviceAccountVos.add(ServiceAccountConvertor.convertToVo(wxServiceAccount));
			}
		}
		return serviceAccountVos;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public ServiceAccountVo getServiceAccountbyId(long accountId) {
		WxServiceAccount wxServiceAccount = null;
		
		wxServiceAccount = serviceAccountDao.getServiceAccountbyId(accountId);
		return ServiceAccountConvertor.convertToVo(wxServiceAccount);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public ServiceAccountVo getServiceAccountbyName(String accountName) {
		WxServiceAccount wxServiceAccount = null;
		
		wxServiceAccount = serviceAccountDao.getServiceAccountbyName(accountName);
		return ServiceAccountConvertor.convertToVo(wxServiceAccount);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void createServiceAccount(ServiceAccountVo serviceAccountVo) {
		WxServiceAccount wxServiceAccount = null;
		
		wxServiceAccount = ServiceAccountConvertor.convertToEntity(serviceAccountVo);		
		serviceAccountDao.createServiceAccount(wxServiceAccount);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void updateServiceAccount(ServiceAccountVo serviceAccountVo) {
		WxServiceAccount wxServiceAccount = null;
		
		wxServiceAccount = serviceAccountDao.getServiceAccountbyId(serviceAccountVo.getId());
		if (wxServiceAccount != null) {
			wxServiceAccount.setAccountName(serviceAccountVo.getAccountName());
			wxServiceAccount.setAccountDesc(serviceAccountVo.getAccountDesc());
			wxServiceAccount.setDisabled(serviceAccountVo.isDisabled());
			wxServiceAccount.setDeleted(serviceAccountVo.isDeleted());
			serviceAccountDao.updateServiceAccount(wxServiceAccount);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteServiceAccount(ServiceAccountVo serviceAccountVo) {
		WxServiceAccount wxServiceAccount = null;
		
		wxServiceAccount = serviceAccountDao.getServiceAccountbyId(serviceAccountVo.getId());
		wxServiceAccount.setDeleted(true);
		serviceAccountDao.updateServiceAccount(wxServiceAccount);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void disableServiceAccount(ServiceAccountVo serviceAccountVo) {
		WxServiceAccount wxServiceAccount = null;
		
		wxServiceAccount = serviceAccountDao.getServiceAccountbyId(serviceAccountVo.getId());
		wxServiceAccount.setDisabled(true);
		serviceAccountDao.updateServiceAccount(wxServiceAccount);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void enableServiceAccount(ServiceAccountVo serviceAccountVo) {
		WxServiceAccount wxServiceAccount = null;
		
		wxServiceAccount = serviceAccountDao.getServiceAccountbyId(serviceAccountVo.getId());
		wxServiceAccount.setDisabled(false);
		serviceAccountDao.updateServiceAccount(wxServiceAccount);
	}
}

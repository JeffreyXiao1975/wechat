package com.xyh.wechat.service.service;

import java.util.List;

import com.xyh.wechat.vo.service.ServiceAccountVo;

public interface IServiceAccountService {
	public List<ServiceAccountVo> getAllServiceAccounts(boolean includeDisabled, boolean includeDeleted);
	public ServiceAccountVo getServiceAccountbyId(long accountId);
	public ServiceAccountVo getServiceAccountbyName(String accountName);
	public void createServiceAccount(ServiceAccountVo serviceAccountVo);
	public void updateServiceAccount(ServiceAccountVo serviceAccountVo);
	public void deleteServiceAccount(ServiceAccountVo serviceAccountVo);
	public void disableServiceAccount(ServiceAccountVo serviceAccountVo);
	public void enableServiceAccount(ServiceAccountVo serviceAccountVo);
}

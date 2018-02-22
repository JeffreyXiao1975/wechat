package com.xyh.wechat.dao.service;

import java.util.List;

import com.xyh.wechat.jpa.entities.WxServiceAccount;

public interface IServiceAccountDao {
	public List<WxServiceAccount> getAllServiceAccounts(boolean includeDisabled, boolean includeDeleted);
	public WxServiceAccount getServiceAccountbyId(long accountId);
	public WxServiceAccount getServiceAccountbyName(String accountName);
	public void createServiceAccount(WxServiceAccount wxServiceAccount);
	public void updateServiceAccount(WxServiceAccount wxServiceAccount);
}

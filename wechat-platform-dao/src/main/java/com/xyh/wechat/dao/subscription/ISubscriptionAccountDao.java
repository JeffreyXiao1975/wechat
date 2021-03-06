package com.xyh.wechat.dao.subscription;

import java.util.List;

import com.xyh.wechat.jpa.entities.WxSubscriptionAccount;

public interface ISubscriptionAccountDao {
	public List<WxSubscriptionAccount> getAllSubscriptionAccounts(boolean includeDisabled, boolean includeDeleted);
	public WxSubscriptionAccount getSubscriptionAccountbyId(long accountId);
	public WxSubscriptionAccount getSubscriptionAccountbyName(String accountName);
	public void createSubscriptionAccount(WxSubscriptionAccount wxSubscriptionAccount);
	public void updateSubscriptionAccount(WxSubscriptionAccount wxSubscriptionAccount);
}

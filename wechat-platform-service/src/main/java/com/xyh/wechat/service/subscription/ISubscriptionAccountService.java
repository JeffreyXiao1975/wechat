package com.xyh.wechat.service.subscription;

import java.util.List;

import com.xyh.wechat.vo.subscription.SubscriptionAccountVo;

public interface ISubscriptionAccountService {
	public List<SubscriptionAccountVo> getAllSubscriptionAccounts(boolean includeDisabled, boolean includeDeleted);
	public SubscriptionAccountVo getSubscriptionAccountbyId(long accountId);
	public SubscriptionAccountVo getSubscriptionAccountbyName(String accountName);
	public void createSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo);
	public void updateSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo);
	public void deleteSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo);
	public void disableSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo);
	public void enableSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo);
}

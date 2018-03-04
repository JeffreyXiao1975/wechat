package com.xyh.wechat.service.subscription;

import java.util.List;

import com.xyh.wechat.vo.subscription.SubscriptionAccountVo;

public interface ISubscriptionAccountService {
	public List<SubscriptionAccountVo> getAllSubscriptionAccounts(boolean includeDisabled, boolean includeDeleted);
	public SubscriptionAccountVo getSubscriptionAccountbyId(long accountId);
	public SubscriptionAccountVo getSubscriptionAccountbyName(String accountName);
	public SubscriptionAccountVo createSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo);
	public SubscriptionAccountVo updateSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo);
	public SubscriptionAccountVo deleteSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo);
	public SubscriptionAccountVo disableSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo);
	public SubscriptionAccountVo enableSubscriptionAccount(SubscriptionAccountVo subscriptionAccountVo);
}

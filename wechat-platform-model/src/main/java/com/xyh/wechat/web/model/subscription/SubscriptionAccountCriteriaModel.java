package com.xyh.wechat.web.model.subscription;

import java.util.List;

import com.xyh.wechat.vo.subscription.SubscriptionAccountVo;

public class SubscriptionAccountCriteriaModel {
	private boolean disabled;
	private boolean deleted;
	private List<SubscriptionAccountVo> subscriptionAccountList = null;
	/**
	 * @return the disabled
	 */
	public boolean isDisabled() {
		return disabled;
	}
	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	/**
	 * @return the subscriptionAccountList
	 */
	public List<SubscriptionAccountVo> getSubscriptionAccountList() {
		return subscriptionAccountList;
	}
	/**
	 * @param subscriptionAccountList the subscriptionAccountList to set
	 */
	public void setSubscriptionAccountList(List<SubscriptionAccountVo> subscriptionAccountList) {
		this.subscriptionAccountList = subscriptionAccountList;
	}
}

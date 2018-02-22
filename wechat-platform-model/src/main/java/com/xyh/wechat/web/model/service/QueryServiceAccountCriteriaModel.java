package com.xyh.wechat.web.model.service;

import java.util.List;

import com.xyh.wechat.vo.service.ServiceAccountVo;

public class QueryServiceAccountCriteriaModel {
	private boolean disabled;
	private boolean deleted;
	private List<ServiceAccountVo> serviceAccountList = null;
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
	 * @return the serviceAccountList
	 */
	public List<ServiceAccountVo> getServiceAccountList() {
		return serviceAccountList;
	}
	/**
	 * @param serviceAccountList the serviceAccountList to set
	 */
	public void setServiceAccountList(List<ServiceAccountVo> serviceAccountList) {
		this.serviceAccountList = serviceAccountList;
	}
}

package com.xyh.wechat.vo.platform;

import com.xyh.wechat.vo.BaseEntityVo;

public class PlatformLegalEntityVo extends BaseEntityVo {
	private String nameCN;
	private String nameEN;
	private boolean disabled;
	private boolean deleted;
	/**
	 * @return the nameCN
	 */
	public String getNameCN() {
		return nameCN;
	}
	/**
	 * @param nameCN the nameCN to set
	 */
	public void setNameCN(String nameCN) {
		this.nameCN = nameCN;
	}
	/**
	 * @return the nameEN
	 */
	public String getNameEN() {
		return nameEN;
	}
	/**
	 * @param nameEN the nameEN to set
	 */
	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}
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
}

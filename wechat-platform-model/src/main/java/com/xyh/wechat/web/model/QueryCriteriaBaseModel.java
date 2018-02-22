package com.xyh.wechat.web.model;

public class QueryCriteriaBaseModel extends BaseModel {
	private long totalPageNumber;
	private long currentPageNumber;
	private boolean firstPage;
	private boolean lastPage;
	private int pageSize;
	/**
	 * @return the totalPageNumber
	 */
	public long getTotalPageNumber() {
		return totalPageNumber;
	}
	/**
	 * @param totalPageNumber the totalPageNumber to set
	 */
	public void setTotalPageNumber(long totalPageNumber) {
		this.totalPageNumber = totalPageNumber;
	}
	/**
	 * @return the currentPageNumber
	 */
	public long getCurrentPageNumber() {
		return currentPageNumber;
	}
	/**
	 * @param currentPageNumber the currentPageNumber to set
	 */
	public void setCurrentPageNumber(long currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	/**
	 * @return the firstPage
	 */
	public boolean isFirstPage() {
		return firstPage;
	}
	/**
	 * @param firstPage the firstPage to set
	 */
	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}
	/**
	 * @return the lastPage
	 */
	public boolean isLastPage() {
		return lastPage;
	}
	/**
	 * @param lastPage the lastPage to set
	 */
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}

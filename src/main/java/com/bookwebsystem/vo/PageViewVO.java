package com.bookwebsystem.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

public class PageViewVO<T> {
	/**
	 * 当前页索引
	 */
	private int currentPageIndex;
	/**
	 * 当前页大小
	 */
	private int pageRecordSize;
	
	/**
	 * 共多少条记录
	 */
	private int totalRecordCount;
	
	/**
	 * 共多少页
	 */
	private int totalPageCount;
	
	/**
	 * 数据
	 */
	private List<T> datas;
	
	/**
	 * 附加参数
	 */
	@XmlTransient
	private Object additionalPara;

	@XmlTransient
	public Object getAdditionalPara() {
		return additionalPara;
	}

	public void setAdditionalPara(Object additionalPara) {
		this.additionalPara = additionalPara;
	}

	/**
	 * @return the currentPageIndex
	 */
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	/**
	 * @param currentPageIndex the currentPageIndex to set
	 */
	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	/**
	 * @return the pageRecordSize
	 */
	public int getPageRecordSize() {
		return pageRecordSize;
	}

	/**
	 * @param pageRecordSize the pageRecordSize to set
	 */
	public void setPageRecordSize(int pageRecordSize) {
		this.pageRecordSize = pageRecordSize;
	}

	/**
	 * @return the totalRecordCount
	 */
	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	/**
	 * @param totalRecordCount the totalRecordCount to set
	 */
	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	/**
	 * @return the totalPageCount
	 */
	public int getTotalPageCount() {
		return totalPageCount;
	}

	/**
	 * @param totalPageCount the totalPageCount to set
	 */
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	/**
	 * @return the datas
	 */
	public List<T> getDatas() {
		return datas;
	}

	/**
	 * @param datas the datas to set
	 */
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
}

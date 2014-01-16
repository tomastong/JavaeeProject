package cn.itjava.util;

import java.util.List;

import cn.itjava.domain.News;

public class PageModel {
	
	
	public PageModel() {}
	
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * 获得总页数
	 */
	public int getTotalPages(){
		return (totalRecords + pageSize -1 ) / pageSize;
	}    
	/**
	 * 取得首页
	 */
	public int getTopPageNo(){
		return 1;
	}
	/**
	 * 取得上一页
	 */
	public int getPreviousPageNo(){
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo-1;
	}
	/**
	 * 取得下一页
	 */
	public int getNextPageNo(){
		if(pageNo >= getTotalPages()){
			return getTotalPages()==0 ? 1:getTotalPages();
		}
		return pageNo+1;
	}
	/**
	 * 取得尾页
	 */
	public int getBottomPageNo(){
		return getTotalPages()==0 ? 1:getTotalPages();
	}
	
	/**
	 * 总记录数
	 */
	private int totalRecords; 
	/**
	 * 每页存放数据结合,这里无法表明是News还是User
	 */
	private List list;
	/**
	 * 当前页号，默认为1
	 */
	private int pageNo = 1;
	/**
	 * 页面尺寸，默认为5
	 */
	private int pageSize = 5;
	
}

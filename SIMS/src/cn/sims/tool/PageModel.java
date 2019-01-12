package cn.sims.tool;

import java.util.List;


public class PageModel {

	public int getTotalPages() {
		return (totalRecords + pageSize - 1) / pageSize;
	}

	public int getTotalRecords(){
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
	 * 获取首页
	 * 
	 * @return
	 */
	public int getTopPageNo() {
		return 1;
	}

	/**
	 * 获取前一页
	 */
	public int getPreviousPageNo() {
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo - 1;
	}

	/**
	 * 获取下一页
	 */
	public int getNextPageNo() {
		if (pageNo >= getTotalPages()) {
			return getTotalPages() == 0 ? 1 : getTotalPages();
		}
		return pageNo + 1;
	}

	/**
	 * 获取最后一页
	 */
	public int getBottomPageNo() {
		return getTotalPages() == 0 ? 1 : getTotalPages();
	}

	/**
	 * 查询总记录数
	 */
	private int totalRecords;
	/**
	 * 结果集
	 */
	private List list;
	/**
	 * 当前页
	 */
	private int pageNo = 1;
	/**
	 * 每页显示多少条
	 */
	private int pageSize = 5;

}

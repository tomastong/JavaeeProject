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
	 * ��ȡ��ҳ
	 * 
	 * @return
	 */
	public int getTopPageNo() {
		return 1;
	}

	/**
	 * ��ȡǰһҳ
	 */
	public int getPreviousPageNo() {
		if (pageNo <= 1) {
			return 1;
		}
		return pageNo - 1;
	}

	/**
	 * ��ȡ��һҳ
	 */
	public int getNextPageNo() {
		if (pageNo >= getTotalPages()) {
			return getTotalPages() == 0 ? 1 : getTotalPages();
		}
		return pageNo + 1;
	}

	/**
	 * ��ȡ���һҳ
	 */
	public int getBottomPageNo() {
		return getTotalPages() == 0 ? 1 : getTotalPages();
	}

	/**
	 * ��ѯ�ܼ�¼��
	 */
	private int totalRecords;
	/**
	 * �����
	 */
	private List list;
	/**
	 * ��ǰҳ
	 */
	private int pageNo = 1;
	/**
	 * ÿҳ��ʾ������
	 */
	private int pageSize = 5;

}

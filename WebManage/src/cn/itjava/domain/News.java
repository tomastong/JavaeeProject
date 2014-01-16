package cn.itjava.domain;

public class News {
	
	public News() {}
	
	public News(int id, String title, String author, String content) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	/**
	 * 新闻编号
	 */
	private int id;
	/**
	 * 新闻标题
	 */
	private String title;
	/**
	 * 新闻作者
	 */
	private String author;
	/**
	 * 新闻内容
	 */
	private String content;
}

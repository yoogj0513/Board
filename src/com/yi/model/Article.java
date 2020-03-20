package com.yi.model;

import java.util.Date;

public class Article {
	private int articleNo;// primary key, 게시글 번호
	private String writerId; // 작성자 아이디
	private String writerName; // 작성자 이름
	private String title; // 제목
	private Date reqdate; // 게시글 생성 날짜
	private Date moddate; // 게시글 수정 날짜
	private int readCnt; // 읽은 획수 count
	private String content; // 내용

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(int articleNo, String writerId, String writerName, String title, Date reqdate, Date moddate,
			int readCnt) {
		super();
		this.articleNo = articleNo;
		this.writerId = writerId;
		this.writerName = writerName;
		this.title = title;
		this.reqdate = reqdate;
		this.moddate = moddate;
		this.readCnt = readCnt;
	}

	public Article(int articleNo, String writerId, String writerName, String title, Date reqdate, Date moddate,
			int readCnt, String content) {
		super();
		this.articleNo = articleNo;
		this.writerId = writerId;
		this.writerName = writerName;
		this.title = title;
		this.reqdate = reqdate;
		this.moddate = moddate;
		this.readCnt = readCnt;
		this.content = content;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReqdate() {
		return reqdate;
	}

	public void setReqdate(Date reqdate) {
		this.reqdate = reqdate;
	}

	public Date getModdate() {
		return moddate;
	}

	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format(
				"Article [articleNo=%s, writerId=%s, writerName=%s, title=%s, reqdate=%s, moddate=%s, readCnt=%s, content=%s]",
				articleNo, writerId, writerName, title, reqdate, moddate, readCnt, content);
	}

}

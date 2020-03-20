package com.yi.model;

import java.util.Date;

public class Member {
	private String memberId;
	private String name;
	private String password;
	private Date reqdate;

	public Member() {
		super();
	}

	public Member(String memberId, String password) {
		super();
		this.memberId = memberId;
		this.password = password;
	}

	public Member(String memberId, String name, String password, Date reqdate) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.password = password;
		this.reqdate = reqdate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getReqdate() {
		return reqdate;
	}

	public void setReqdate(Date reqdate) {
		this.reqdate = reqdate;
	}

	@Override
	public String toString() {
		return String.format("MemberDto [memberId=%s, name=%s, password=%s, reqdate=%s]", memberId, name, password,
				reqdate);
	}

}

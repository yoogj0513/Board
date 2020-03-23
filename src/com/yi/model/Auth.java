package com.yi.model;

public class Auth { // Session 영역에 저장될 data, db와 연관 없음
	private String id;
	private String name;

	public Auth() {
		super();
	}

	public Auth(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Auth [id=%s, name=%s]", id, name);
	}

}

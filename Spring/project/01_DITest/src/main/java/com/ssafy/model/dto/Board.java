package com.ssafy.model.dto;

import java.io.Serializable;
import java.util.List;

public class Board implements Serializable {
	private int no;
	private String id;
	private String title;
	private String regdate;
	private String contents;
	private List<FileBean> files;

	public Board() {
		System.out.println("Board 클래스 기본 생성자 생성");
	}

	public Board(String id, String title, String contents) {
		System.out.println("Board 클래스 id, title, contents 생성자 생성");
		this.id = id;
		this.title = title;
		this.contents = contents;
	}

	public Board(int no, String id, String title, String regdate, String contents) {
		System.out.println("Board 클래스 id, title, contents, regdate, contents 생성자 생성");
		this.no = no;
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.contents = contents;
	}

	public Board(int no, String id, String title, String regdate, String contents, List<FileBean> files) {
		System.out.println("Board 클래스 full parameter 생성자 생성");
		this.no = no;
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.contents = contents;
		this.files = files;
	}

	public List<FileBean> getFiles() {
		return files;
	}

	public void setFiles(List<FileBean> files) {
		this.files = files;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [no=").append(no).append(", id=").append(id).append(", title=").append(title)
				.append(", regdate=").append(regdate).append(", contents=").append(contents).append(", files=")
				.append(files).append("]");
		return builder.toString();
	}
}

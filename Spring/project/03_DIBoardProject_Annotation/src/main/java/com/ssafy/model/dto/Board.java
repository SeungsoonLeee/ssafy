package com.ssafy.model.dto;

import java.io.Serializable;
import java.util.List;
public class Board implements Serializable {
	private int no        	 ;
	private String id        ;
	private String title     ;
	private String regdate   ;
	private String contents  ;
	private List<BoardFile> files;
	public Board(String id, String title, String contents) {
		this.id = id;
		this.title = title;
		this.contents = contents;
	}
	public Board(int no, String id, String title, String regdate) {
		this.no = no;
		this.id = id;
		this.title = title;
		this.regdate = regdate;
	}
	public Board(int no, String id, String title, String regdate, String contents, List<BoardFile> files) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.contents = contents;
		this.files = files;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [no=").append(no).append(", id=").append(id).append(", title=").append(title)
				.append(", regdate=").append(regdate).append(", contents=").append(contents).append(", files=")
				.append(files).append("]");
		return builder.toString();
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
	public List<BoardFile> getFiles() {
		return files;
	}
	public void setFiles(List<BoardFile> files) {
		this.files = files;
	}
	
	
}

package com.ssafy.model.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
public class FAQ implements Serializable {
	private int no        	 ;
	private String id        ;
	private String title     ;
	private String regdate   ;
	private String contents  ;
	private String reply    ;
	public FAQ() {};
	public FAQ(String id, String title, String contents) {
		this.id = id;
		this.title = title;
		this.contents = contents;
	}
	
	public FAQ(int no, String id, String title, String regdate, String contents, String reply) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.contents = contents;
		this.reply = reply;
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
}

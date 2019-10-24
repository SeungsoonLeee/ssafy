package com.ssafy.model.dto;
import java.io.Serializable;
public class BoardFile implements Serializable {
	private int no       	;
	private String rfilename;
	private String sfilename;
	private int bno         ;
	public BoardFile() {}
	public BoardFile(String rfilename, String sfilename) {
		this.rfilename = rfilename;
		this.sfilename = sfilename;
	}
	public BoardFile(int no, String rfilename, String sfilename) {
		this.no = no;
		this.rfilename = rfilename;
		this.sfilename = sfilename;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BoardFile [no=").append(no).append(", rfilename=").append(rfilename).append(", sfilename=")
				.append(sfilename).append(", bno=").append(bno).append("]");
		return builder.toString();
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRfilename() {
		return rfilename;
	}
	public void setRfilename(String rfilename) {
		this.rfilename = rfilename;
	}
	public String getSfilename() {
		return sfilename;
	}
	public void setSfilename(String sfilename) {
		this.sfilename = sfilename;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
}

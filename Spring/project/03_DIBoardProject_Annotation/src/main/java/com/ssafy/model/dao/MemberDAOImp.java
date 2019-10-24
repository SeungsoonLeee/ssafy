package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Member;
import com.ssafy.util.DBUtil;

//@Component : bean으로 등록하는 Annotation
//클래스 이름의 첫글자를 소문자로 하는 bean 이름으로 등록 됨, byName으로는 구분될 수 없으니 주의
//@Component('name')
//지정한 이름오르 bean이 등록 됨(동일한 타입이 여러 개 있을 때 name으로 구별하기 위함)

//@Component("memberDao")
@Repository("memberDao")
public class MemberDAOImp implements MemberDAO {
	public Member search(String id) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from member where id = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				return new Member(rs.getString("id")
						        , rs.getString("password")
						        , rs.getString("name")
						        , rs.getString("email")
						        , rs.getString("phone")
						        , rs.getString("address")
						        );
			}
		} finally {
		  DBUtil.close(rs);
		  DBUtil.close(stmt);
		  DBUtil.close(con);
		}
		return null;
	}

	public List<Member> searchAll() throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from member  ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Member> members = new LinkedList<Member>();
			while(rs.next()) {
				members.add(new Member(rs.getString("id")
						        , rs.getString("name")
						        , rs.getString("email")
						        , rs.getString("phone")));
			}
			return members;
		} finally {
		  DBUtil.close(rs);
		  DBUtil.close(stmt);
		  DBUtil.close(con);
		}
	}
	public void add(Member member) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into member(id,password,name,email,phone,address) "
					   + " values(?,?,?,?,?,?) ";
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, member.getId());		
			stmt.setString(idx++, member.getPassword());		
			stmt.setString(idx++, member.getName());		
			stmt.setString(idx++, member.getEmail());		
			stmt.setString(idx++, member.getPhone());		
			stmt.setString(idx++, member.getAddress());
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	public void update(Member member) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update member set password=?, name=?, email=?, phone=? "
						+"                  , address=?  where id=? " ;
			
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, member.getPassword());		
			stmt.setString(idx++, member.getName());		
			stmt.setString(idx++, member.getEmail());		
			stmt.setString(idx++, member.getPhone());		
			stmt.setString(idx++, member.getAddress());
			stmt.setString(idx++, member.getId());		
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	public void remove(String id) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " delete from member where id=? " ;
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);		
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}








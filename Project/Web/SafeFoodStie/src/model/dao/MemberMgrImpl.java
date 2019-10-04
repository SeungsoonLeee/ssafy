package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dto.DuplicateException;
import model.dto.Food;
import model.dto.InfoNotFoundException;
import model.dto.Member;
import model.util.DBUtil;

public class MemberMgrImpl implements IMemberMgr {
	private static IMemberMgr manager = new MemberMgrImpl();

	private MemberMgrImpl() {};
	public static MemberMgrImpl getInstance() {
		return (MemberMgrImpl) manager;
	}
	public static boolean kmp(String origin, String allergy) {
		char[] T = origin.toCharArray();
		char[] P = allergy.toCharArray();
		int tLength = T.length, pLength= P.length;
		int[] fail  = new int[pLength];
		
		for (int i = 1,j=0; i < pLength; ++i) {
			while(j>0 && P[i] != P[j]) j = fail[j-1];
			
			if(P[i]==P[j]) fail[i] = ++j;
		}
		int cnt = 0;
		for (int i = 0, j=0; i < tLength; ++i) {
			while(j>0 && T[i] != P[j]) j = fail[j-1];
			if(T[i] == P[j]) {
				if(j == pLength-1) {
					return true;
				}else {
					++j;
				}
			}
		}
		return false;
	}
	public static String getAllergyIngredients(Food food, String allergies) {
		String[] ingredients = allergies.split(",");
		int size = ingredients.length;
		String answer = "";
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			if(kmp(food.getName(), ingredients[i]) || kmp(food.getMaterial(), ingredients[i])) {
				cnt++;
				if(cnt != 1) {
					answer += ",";
				}
				answer += ingredients[i];
			}
		}
		return answer;
	}
	@Override
	public void add(Member member) throws Exception {
		Member find = search(member.getId());
		if(find != null) {
			throw new DuplicateException();
		} else {
			Connection con = null;
			PreparedStatement stmt = null;
			try {
				con = DBUtil.getConnection();
				String sql = " insert into member(id, password, name"
						+ ", email, phone, address, allergy)"
						+ " values(?, ?, ?, ?, ?, ?, ?) ";
				stmt = con.prepareStatement(sql);
				int idx = 1;
				stmt.setString(idx++, member.getId());
				stmt.setString(idx++, member.getPassword());
				stmt.setString(idx++, member.getName());
				stmt.setString(idx++, member.getEmail());
				stmt.setString(idx++, member.getPhone());
				stmt.setString(idx++, member.getAddress());
				stmt.setString(idx++, member.getAllergy());
				stmt.executeUpdate();
			} catch(SQLException e){
				e.printStackTrace();
				throw new SQLException();
			} finally {
				DBUtil.close(stmt);
				DBUtil.close(con);
			}
		}
	}
	@Override
	public Member search(String id) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from member where id = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				return new Member(rs.getString("id")
						, rs.getString("password"), rs.getString("name")
						, rs.getString("email"), rs.getString("phone")
						, rs.getString("address"), rs.getString("allergy"));
			}
		} catch(SQLException e){
			e.printStackTrace();
			throw new SQLException();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}
	public Member update(Member member) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " update member set password=?, name=?, email=?, phone=?"
						+", address=?, allergy=? where id = ? ";
			
			stmt = con.prepareStatement(sql);
			int idx = 1;
			stmt.setString(idx++, member.getPassword());		
			stmt.setString(idx++, member.getName());		
			stmt.setString(idx++, member.getEmail());		
			stmt.setString(idx++, member.getPhone());		
			stmt.setString(idx++, member.getAddress());
			stmt.setString(idx++, member.getAllergy());
			stmt.setString(idx++, member.getId());	
			stmt.executeUpdate();
		}  catch(SQLException e){
			e.printStackTrace();
			throw new SQLException();
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return member;
	}
	public Member remove(String id) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " delete from member where id = ? " ;
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);		
			stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
			throw new SQLException();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}


}

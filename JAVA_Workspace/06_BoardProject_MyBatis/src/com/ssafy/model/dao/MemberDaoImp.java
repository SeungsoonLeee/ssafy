package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ssafy.config.MyBatis;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;

public class MemberDaoImp implements MemberDao {
	private SqlSession session = MyBatis.getSqlSession();
	public void insertMember(Member member)  {
		/*session.insert(String id, Object parameter)
		 * id  : 수행할 query id(namespace.id), 
		 * parameter : 수행할 query에 설정할 데이타
		 * */
		session.insert("member.insert", member);
		session.commit();
	}
	public void deleteMember(String id){
		session.delete("member.delete", id);
		session.commit();
	}
	public void updateMember(Member member){
		session.update("member.update", member);
		session.commit();
	}
	public Member search(String id) {
		/*selectOne(String id, Object param)
		 * id  : 수행할 query id(namespace.id) 
		 * parameter : 수행할 query에 설정할 데이타
		 * 
		 * - primary key로 select문에 의해 추출한 데이타가 한개일 때 사용
		 * - select문에 의해 추출한 데이타가 2개 이상일 때나 하나도 추출이 안되면 
		 *   오류  발생  
		 * */
		return session.selectOne																							("member.search", id);
	}
	public List<Member> searchAll(PageBean bean) {
		/* selectList(String id, Object parameter, RowBounds rows)
		 * - 0개 이상을 추출할 때 사용
		 * id   : 수행할 query id(namespace.id) 
		 * parameter : 수행할 query에 설정할 데이타
		 * rows : 시작번호 부터 몇개 추출할지 
		 * */
		RowBounds rows = new RowBounds(bean.getStart()-1, bean.getInterval());
		return session.selectList("member.searchAll", bean, rows);
	}
	public int count(PageBean bean) {
		return session.selectOne("member.count", bean);
	}
}






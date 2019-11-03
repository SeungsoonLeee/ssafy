package com.ssafy;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.pms.Phone;
import com.ssafy.pms.dao.PhoneDAOImpl;

//단위 테스트를 동작시킬 대상 지정
@RunWith(SpringRunner.class) // SpringRunner는 Spring 컨테이너를 동작 시킬 클래스
//Spring을 위한 bean configuration 설정
@ContextConfiguration("classpath:/spring/application-config.xml")
public class PhoneDaoTest {
	@Autowired
	PhoneDAOImpl dao;

	@Test
	public void testBean() {
//		fail("Not yet implemented");
		
		
		/**
		 *  assertThat(actual, matcher)
		 *  단위 테스트한 결과를 확인하기 위한 메서드
		 *   - actual : 결과
		 *   - matcher : 확인 => 확인이 원하는 값이 아니면 fail이 되고 해당 메세지를 출력
		 */
		assertThat(dao, is(notNullValue())); // dao를 autowired 했는데 dao가 null이 아니면 통과, null이면 에러메세지 출력
	}

	@Test
	public void insertPhone() {
		Phone p = new Phone("s123", "test", 1000, "10");
		dao.insert(p);

		Phone find = dao.search("s123");
		assertThat(find, is(notNullValue()));
	}

	@Test
	public void deletePhone() {
		List<String> list = Arrays.asList("s123");
		dao.delete2(list);

		Phone find = dao.search("s123");
		assertThat(find, is(nullValue()));
	}
	
}

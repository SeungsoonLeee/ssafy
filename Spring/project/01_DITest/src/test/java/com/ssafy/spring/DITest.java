package com.ssafy.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.model.dto.Board;

public class DITest {
	public static void main(String[] args) {

		/**
		 * Spring container 생성
		 */
		BeanFactory container = new ClassPathXmlApplicationContext("com/ssafy/config/beans1.xml");
		System.out.println("스프링 콘테이너 로딩 완료!");

		/**
		 * getBeans(String name)
		 *  - name 이나 id에 해당하는 객체를 container에서 추출
		 *  - object로 반환하므로 형변환을 해야 한다.
		 *  
		 * getBeans(Class)
		 *  - 지정한 클래스 타입과 동일한 객체를 container에서 추출
		 *  - 지정한 클래스 타입으로 반환하므로 형변환이 필요하지 않다.
		 *  - 같은 타입의 객체가 2개 이상 등록되어 있으면 에러가 나는 것에 주의한다.
		 */
		
//		Board board = (Board) container.getBean("board");
//		Board board = container.getBean("board", Board.class);
//		Board board = container.getBean(Board.class);
		
		Board board1 = container.getBean("board", Board.class);
		System.out.println(board1.hashCode());
		Board board2 = container.getBean("board", Board.class);
		System.out.println(board2.hashCode());
		Board board3 = container.getBean("board2", Board.class);
		System.out.println(board3.hashCode());
		Board board4 = container.getBean("board2", Board.class);
		System.out.println(board4.hashCode());
		
	}
}

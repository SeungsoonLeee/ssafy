package com.ssafy.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.model.dto.Board;

public class DITest4 {
	public static void main(String[] args) {

		/**
		 * Spring container 생성
		 */
		BeanFactory container = new ClassPathXmlApplicationContext("com/ssafy/config/beans4.xml");
		System.out.println("스프링 콘테이너 로딩 완료!");

		Board board = container.getBean("board", Board.class);
		System.out.println(board);
		
	}
}

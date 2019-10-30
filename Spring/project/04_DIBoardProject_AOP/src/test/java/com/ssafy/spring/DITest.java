package com.ssafy.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.service.BoardService;

public class DITest {
	public static void main(String[] args) {
		BeanFactory container = new ClassPathXmlApplicationContext("com/ssafy/config/beans1.xml");
		BoardService bService = container.getBean("boardService", BoardService.class);
		System.out.println(bService.search("1"));
		
		
	}
}

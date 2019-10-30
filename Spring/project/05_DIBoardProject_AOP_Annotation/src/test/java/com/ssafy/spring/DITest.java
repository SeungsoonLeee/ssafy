package com.ssafy.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.service.BoardService;
import com.ssafy.service.MemberService;

public class DITest {
	public static void main(String[] args) {
		BeanFactory container = new ClassPathXmlApplicationContext("com/ssafy/config/beans1.xml");
		BoardService bService = container.getBean("boardServiceImpl", BoardService.class);
		System.out.println(bService.search("1"));
		MemberService mService = container.getBean("memberServiceImp", MemberService.class);
		System.out.println(mService.search("ssafy"));
		
	}
}

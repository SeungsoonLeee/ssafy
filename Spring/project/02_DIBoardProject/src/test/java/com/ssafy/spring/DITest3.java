package com.ssafy.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.service.BoardService;
import com.ssafy.service.MemberService;

public class DITest3 {
	public static void main(String[] args) {
		BeanFactory container = new ClassPathXmlApplicationContext("com/ssafy/config/beans3.xml");
		BoardService bService = container.getBean("boardService", BoardService.class);
		System.out.println(bService.search("1"));
		MemberService mService = container.getBean("memberService", MemberService.class);
		System.out.println(mService.search("ssafy"));
		
	}
}

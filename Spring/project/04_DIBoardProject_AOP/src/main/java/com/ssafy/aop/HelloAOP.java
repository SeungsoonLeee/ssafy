package com.ssafy.aop;

import org.aspectj.lang.JoinPoint;

public class HelloAOP {
	/**
	 * JoinPoint 핵심 모듈의 이름, 인자정보를 추출
	 */
	
	public void hello(JoinPoint jp) {
		System.out.println("Hello JoinPoint!");
	}
}

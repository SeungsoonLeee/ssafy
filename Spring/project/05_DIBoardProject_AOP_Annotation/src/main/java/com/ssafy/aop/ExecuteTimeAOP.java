package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component //bean으로 등록
@Aspect // aspect 설정  : <aop:aspect ref="~" / > 와 같은 역할
public class ExecuteTimeAOP {
	/**
	 * ProceedingJoinPoint : 핵심 모듈의 이름, 인자를 추출할 수 있고 핵심 모듈을 수행시킬 수 있다.
	 */

	// <apo:around method="" pointcut=""> 와 같은 역할
	@Around("execution( * com.ssafy.service.*ServiceImp*.search*(..))")
	public Object time(ProceedingJoinPoint jp) throws Throwable {
		long startTime = System.currentTimeMillis();

		try {
			/**
			 *  proceed(~) : 핵심 모듈을 호출하는 함수
			 *  	- proceed() : 핵심 모듈ㅇ르 호출한 곳에서 전달한 인자로 핵심 모듈을 구행시킴
			 *  	- proceed(Object[] args) : 지정한 인자로 핵심 모듈을 호출
			 */
			
			return jp.proceed(); // 핵심 모듈을 수행한 결과를 호출한 곳으로 전달. 리턴하지 않으면 null이 넘어가므로 반드시 결과를 리턴해주어야 한다.
		} catch (Throwable e) {
			e.printStackTrace();
			throw e; //핵심 모듈에서 발생한 오류로 호출한 곳으로 오류 전달, 오류를 전달하지 않으면 예외를 처리함
		} finally {
			long endTime = System.currentTimeMillis();
			System.out.println("----------------------------------------------------");
			System.out.println("메서드 이름 : " + jp.getSignature());
			Object[] args = jp.getArgs();
			if (args != null && args.length > 0) {
				System.out.println("<인자 정보>");
				for (Object a : args) {
					System.out.println("인자 : " + a);
				}
			}
			System.out.println("함수 수행 시간 : " + (endTime - startTime) + "ms");
			System.out.println("----------------------------------------------------");
		}
	}
}

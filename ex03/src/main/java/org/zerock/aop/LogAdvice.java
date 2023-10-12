package org.zerock.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect //Aspect를 구현한클래스다.
@Component //스프링에서 관리되는 객체다.
@Log4j
public class LogAdvice {
	
	@Before( "execution(* org.zerock.controller.Home*.*(..))")               
	public void logBefore1() {
		log.info("=======Home웹페이지요청 / aop를 이용한 로그 출력====");
	}
	
	@Before( "execution(* org.zerock.controller.Board*.*(..))")               
	public void logBefore2() {
		log.info("=======Board웹페이지요청 / aop를 이용한 로그 출력====");
	}
	
	@Before( "execution(* org.zerock.controller.MyAPI*.*(..))")               
	public void logBefore3() {
		log.info("=======MyAPI데이터요청 / aop를 이용한 로그 출력====");
	}
	
	@Before( "execution(* org.zerock.controller.Reply*.*(..))")               
	public void logBefore4() {
		log.info("=======Reply데이터요청 / aop를 이용한 로그 출력====");
	}
	
	@Before( "execution(* org.zerock.controller.Sample*.*(..))")               
	public void logBefore5() {
		log.info("=======Sample데이터요청 / aop를 이용한 로그 출력====");
	}

}

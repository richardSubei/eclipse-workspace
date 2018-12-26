package com.xingyu.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aop {

	@Pointcut("execution(* com.xingyu.demo.service.*.*(..))")
	public void pointCut_() {
	}
	@Before("pointCut_()")
	public void before() {
		System.out.println("begin");
	}
	@After("pointCut_()")
	public void after() {
		System.out.println("after");
	}
	
//	@AfterReturning
//	public void afterReturning() {
//		System.out.println("afterReturning");
//	}
//	@AfterThrowing
//	public void afterThrowing() {
//		System.out.println("afterThrowing");
//	}
//	
//	@Around("pointCut_()")
//	public void around() {
//		System.out.println("around");
//	}
	
}

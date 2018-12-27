package com.xingyu.demo.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.xingyu.demo.context.DBContextHolder;
import com.xingyu.demo.context.RoutingDataSource;

@Component
@Aspect
public class Aop {

	@Pointcut("execution(* com.xingyu.demo.service.*.*(..))")
	public void pointCut_() {
	}
	@Before("pointCut_()")
	public void before(JoinPoint joinPoint) {
		System.out.println("begin");
		Class<?> className = joinPoint.getTarget().getClass();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		String methodName = signature.getName();
		Class<?>[] args = signature.getMethod().getParameterTypes();
		try {
			Method method = className.getMethod(methodName, args);
			if (method.isAnnotationPresent(RoutingDataSource.class)) {
				RoutingDataSource routingDataSource = method.getAnnotation(RoutingDataSource.class);
				String dbType = routingDataSource.value();
				DBContextHolder.setDBType(dbType);
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO: handle exception
		}
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

package com.hardik.Spring_Boot_rest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);
	
	
	// return type,class-name.Method-name(args)
	
	@Before("execution(* com.hardik.Spring_Boot_rest.service.JobService.getJob(..)) || execution(* com.hardik.Spring_Boot_rest.service.JobService.updateJob(..)) ")
	public void logMethodCall(JoinPoint jp){
		
		LOGGER.info("method called " + jp.getSignature().getName());
	}
	
	@After("execution(* com.hardik.Spring_Boot_rest.service.JobService.getJob(..)) || execution(* com.hardik.Spring_Boot_rest.service.JobService.updateJob(..)) ")
	public void logMethodExecuted(JoinPoint jp){
		
		LOGGER.info("method Executed " + jp.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.hardik.Spring_Boot_rest.service.JobService.getJob(..)) || execution(* com.hardik.Spring_Boot_rest.service.JobService.updateJob(..)) ")
	public void logMethodCrash(JoinPoint jp){
		
		LOGGER.info("method has some issues " + jp.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.hardik.Spring_Boot_rest.service.JobService.getJob(..)) || execution(* com.hardik.Spring_Boot_rest.service.JobService.updateJob(..)) ")
	public void logMethodExecutedSuccess(JoinPoint jp){
		
		LOGGER.info("method Executed sucessfully " + jp.getSignature().getName());
	}
}

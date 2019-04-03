package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger log = Logger.getRootLogger();
	// create advice to be injected in our application methods to handling the cross cutting concern of logging
	
	@AfterReturning("within(com.cue.controller.*)")
	public void logAfter(JoinPoint jp) {
		log.info(jp.getSignature() + " was called.");
		System.out.println(jp.getSignature() + " was called.");
	}
	
	@AfterThrowing("within(com.cue.controller.*)")
	public void logAfterException(JoinPoint jp) {
		log.error(jp.getSignature() + " threw an exception.");
		System.out.println(jp.getSignature() + " was called.");
	}

}
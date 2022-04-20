package com.kcg.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	// All classes within controllers package will be affected
	@Pointcut("within(com.kcg.pma.controllers..*)"
			+ "|| within(com.kcg.pma.services..*)")
	public void definePackagePointcuts() {
		// empty method to name location of pointcut
	}
	
	// Before, After, Around
	// This method will run after everything in the controllers and services packages
	@After("definePackagePointcuts()")
	public void logAfter(JoinPoint jp) {
		log.debug("\n \n \n");
		log.debug("************* After method execution ***************** \n {}.{} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("_______________________________________________ \n \n \n");
	}
}

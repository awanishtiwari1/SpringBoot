package com.infy.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.infy.exception.InfyBankException;

@Component
@Aspect
public class LoggingAspect {

	public static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class); 

	
	
		@Before("execution(* com.infy.service.*Impl.*(..))")
		public void before() throws InfyBankException {
			try {
				LOGGER.info("Before advice called.");
				throw new InfyBankException("Testing exception");
			}
			catch(Exception e)
			{
				LOGGER.info("Exception occured in Before Aspect" + e.getMessage());
			}
		}
	
	
	

	@After("execution(* com.infy.service.*Impl.*(..))")
	public void after() throws InfyBankException {
		LOGGER.info("After advice called.");
	}

	@AfterReturning("execution(* com.infy.service.*Impl.*(..))")
	public void afterReturning() throws InfyBankException {
		LOGGER.info("After returning advice called.");
	}

	@AfterThrowing(pointcut = "execution(* com.infy.service.*Impl.*(..))", throwing = "exception")
	public void afterThrowing(InfyBankException exception) throws InfyBankException {
		LOGGER.error(exception.getMessage(), exception);
	}

}
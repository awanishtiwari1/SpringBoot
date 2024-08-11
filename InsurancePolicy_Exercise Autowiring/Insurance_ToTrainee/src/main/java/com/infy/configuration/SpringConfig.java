package com.infy.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infy.service.InsuranceServiceImpl;

@Configuration
public class SpringConfig {
	
	@Bean
	public InsuranceServiceImpl  insuranceService()
	{
		return new InsuranceServiceImpl();
	}
	
	
	
}
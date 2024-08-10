package com.infy.validator;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.exception.InsuranceException;
import com.infy.model.PolicyDTO;
import com.infy.repository.InsuranceRepository;

public class Validator {

	@Autowired
	static
	InsuranceRepository insuranceRepository;
	public static void validate(PolicyDTO policy) throws InsuranceException{
//		List<PolicyDTO> allPolicies = insuranceRepository.getAllPolicyDetails();
//		for(PolicyDTO list : allPolicies)
//		{
//			if(list.getPolicyNumber() == policy.getPolicyNumber())
//			{
//				
//			}
//		}
		
	}

	
	public static Boolean validatePolicyName(String policyName){

		return null;

	}
	
	public static Boolean validatePolicyType(String policyType){

		return null;

	}
	
	public static Boolean validatePremium(Double premium){

		return null;

	}
	
	public static Boolean validateTenure(Integer tenureInMonths){

		return null;

	}

	
	public static Boolean validateDateOfBirth(LocalDate dateOfBirth){

		return null;

	}

	
	public static Boolean validatePolicyNumber(String policyNumber,String policyType){

		return null;

	}

	
	public static Boolean validatePolicyHolderName(String policyHolderName){

		return null;

	}
}

package com.infy.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.exception.InsuranceException;
import com.infy.model.PolicyDTO;
import com.infy.repository.InsuranceRepository;

public class Validator {

	
	public static void validate(PolicyDTO policy) throws InsuranceException{
		if(!validatePolicyName(policy.getPolicyName()))
		{
			throw new InsuranceException("Validator.INVALID_POLICY_NUMBER");
		}
		
	}

	
	public static Boolean validatePolicyName(String policyName){

		return policyName.matches("[A-Za-z]+");
		
		
		//+ for one or more 
		//* for zero or more
		//? for either zero or one
		// \W for word 
		// \D for digit 

	}
	
	public static Boolean validatePolicyType(String policyType){

		return policyType.matches("(Term Life Insurance|Whole Life Policy|Endowment Plans)");

	}
	
	public static Boolean validatePremium(Double premium){

		if(premium > 100)
		{
			return true;
		}
		return false;

	}
	
	public static Boolean validateTenure(Integer tenureInMonths){

		if(tenureInMonths > 24)
		{
			return true;
		}
		return false;

	}

	
	public static Boolean validateDateOfBirth(LocalDate dateOfBirth){

	
		return dateOfBirth.isBefore(LocalDate.now());

	}

	
	public static Boolean validatePolicyNumber(String policyNumber,String policyType){

		if(policyNumber.length() == 6 && policyType.equals("Term Life Insurance"))
		{
			return true;
		}
		if(policyNumber.length() == 6 && policyType.equals("Whole Life Policy"))
		{
			return true;
		}
		if(policyNumber.length() == 6 && policyType.equals("EndowMent Plans"))
		{
			return true;
		}
		
		
		
		return false;

	}

	
	public static Boolean validatePolicyHolderName(String policyHolderName){

		return policyHolderName.matches("^(?=\\S.*\\S)(?:\\S{3,}\\s+)*\\S{3,}$");

	}
}

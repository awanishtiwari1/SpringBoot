package com.infy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.exception.InsuranceException;
import com.infy.model.PolicyDTO;
import com.infy.model.PolicyReportDTO;
import com.infy.repository.InsuranceRepository;
import com.infy.validator.Validator;


public class InsuranceServiceImpl implements InsuranceService{

	@Autowired
	InsuranceRepository insuranceRepository;
	@Autowired
	InsuranceService insuranceService;
	public String buyPolicy(PolicyDTO policy) throws InsuranceException {
		
		Validator.validate(policy);
		String s = insuranceRepository.buyPolicy(policy);
		return s;
	}

	public Long calculateAge(LocalDate dateOfBirth) throws InsuranceException {
		LocalDate l = LocalDate.now();
		int ret =   l.getMonthValue() - dateOfBirth.getMonthValue();
		Integer in = ret;
		return in.longValue();
	}

	public List<PolicyReportDTO> getReport(String policyType) throws InsuranceException {
		
		List<PolicyDTO>  list = insuranceRepository.getAllPolicyDetails();
		
		List<PolicyDTO> filterdList = new ArrayList<>();
		
		for(PolicyDTO l : list)
		{
			if(l.getPolicyType().equals(policyType))
			{
				filterdList.add(l);
			}
		}
		List<PolicyReportDTO> pl = new ArrayList<>();
		for(PolicyDTO l : filterdList)
		{
			Long p = insuranceService.calculateAge(l.getDateOfBirth());
			PolicyReportDTO o = new PolicyReportDTO();
			o.setPolicyHolderAge((double)p);
			o.setPolicyHolderName(l.getPolicyHolderName());
			o.setPolicyNumber(l.getPolicyNumber());
			o.setTenureInMonths(l.getTenureInMonths());
			
			pl.add(o);
		}
		
		if(filterdList.isEmpty())
		{
			throw new InsuranceException("Service.NO_RECORD");
		}
		
		return pl;
	}

		
	
	
}

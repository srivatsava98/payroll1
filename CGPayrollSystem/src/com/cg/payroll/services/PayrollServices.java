package com.cg.payroll.services;

import com.cg.payroll.beans.Associate;

public interface PayrollServices {

	int acceptAssociateDetails(long yearlyInvestmentUnder80C, String firstName, String lastName, String department,
			String designation, String pancard, String emailId, float basicSalary, float epf, float companyPf,
			long accountNumber, String bankName, String ifscCode);

	float calculateNetSalary(int associateId);

	Associate getAssociateDetails(int associateId);

	Associate[] getAllAssociatesDetails();

}
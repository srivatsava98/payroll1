package com.cg.payroll.services;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.PayrollDAOServices;
import com.cg.payroll.daoservices.PayrollDAOServicesImpl;

public class PayrollServicesImpl implements PayrollServices {

	private PayrollDAOServices daoservices;

	public PayrollServicesImpl() {
		daoservices = new PayrollDAOServicesImpl();
	}
	@Override
	public int acceptAssociateDetails(long yearlyInvestmentUnder80C, String firstName, String lastName,
			String department, String designation, String pancard, String emailId,float basicSalary,float epf, float companyPf,long accountNumber, String bankName, String ifscCode){
		Associate associate = new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new Salary(basicSalary, epf, companyPf), new BankDetails(accountNumber, bankName, ifscCode));
		int associateId=daoservices.insertAssociate(associate);
		return associateId;
	}
	@Override
	public float calculateNetSalary(int associateId){
		Associate associate = this.getAssociateDetails(associateId);
		if(associate!=null){
			float basicSalary=associate.getSalary().getBasicSalary();
			long yearlyInvestmentUnder80C=associate.getYearlyInvestmentUnder80C();
			float companyPf=associate.getSalary().getCompanyPf();
			float epf=associate.getSalary().getEpf();
			float personalAllowances=associate.getSalary().getPersonalAllowance();
			float conveyenceAllowance=associate.getSalary().getConveyenceAllowance();
			float otherAllowance=associate.getSalary().getOtherAllowance();
			float hra=associate.getSalary().getHra();
			float gratuity=associate.getSalary().getGratuity();
			float grossSalary=associate.getSalary().getGrossSalary();
			float netSalary=associate.getSalary().getNetSalary();
			float annualSalary,Cal,Cal1,Cal2,Cal3,Cal4,a;

			personalAllowances=(float)(0.3*basicSalary);
			conveyenceAllowance=(float)(0.2*basicSalary);
			otherAllowance=(float)(0.1*basicSalary);
			hra=(float)(0.25*basicSalary);
			gratuity=(float)(0.05*basicSalary);
			grossSalary=basicSalary+hra+conveyenceAllowance+personalAllowances+otherAllowance+companyPf;
			annualSalary=grossSalary*12;
			float nontax1=(yearlyInvestmentUnder80C+(12*(companyPf+epf)));
			if(nontax1>150000){
				nontax1=150000;
			}
			if(annualSalary<250000){
				associate.getSalary().setMonthlyTax(0);
				return ((annualSalary/12)-epf-companyPf);
			}
			else if(annualSalary>=250000&&annualSalary<500000){
				Cal=(annualSalary-250000-nontax1);
				float tax = (float)(Cal*0.1);
				if(tax<=0)
				{
					tax=0;
				}
				associate.getSalary().setMonthlyTax((tax/12));
				return((annualSalary/12)-(tax/12)-epf-companyPf);
			}
			else if(annualSalary>=500000&&annualSalary<1000000){
				Cal1=(250000-nontax1);
				a = (float)(Cal1*0.1);
				Cal2=(annualSalary-500000);
				float tax = (float)((Cal1*0.2)+a);
				associate.getSalary().setMonthlyTax((tax/12));
				return ((annualSalary/12)-(tax/12)-epf-companyPf);
			}
			else if(annualSalary>=1000000){
				Cal3=(250000-nontax1);
				a = (float)(Cal3*0.1);
				Cal4=(annualSalary-1000000);
				float tax = (float)((Cal4*0.3)+a+100000);
				associate.getSalary().setMonthlyTax((tax/12));
				return ((annualSalary/12)-(tax/12)-epf-companyPf);
			}
		}
		return 0;
	}

	@Override
	public Associate getAssociateDetails(int associateId){
		return daoservices.getAssociate(associateId);
	}

	@Override
	public Associate[]getAllAssociatesDetails(){
		return daoservices.getAssociates();
	}
}


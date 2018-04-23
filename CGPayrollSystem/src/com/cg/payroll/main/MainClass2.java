package com.cg.payroll.main;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class MainClass2 {
	public static void main(String[]args){ 

	PayrollServices payrollServicesImpl = new PayrollServicesImpl();
	int i=payrollServicesImpl.acceptAssociateDetails(100000l, "M", "S", "J", "T", "AAA123", "sri@gmail.com", 100000f, 1000f, 1000f, 999999999l, "HdFC", "HDFC123");
	System.out.println(payrollServicesImpl.getAssociateDetails(i).getFirstName());
	System.out.println(payrollServicesImpl.calculateNetSalary(i));
	System.out.println(payrollServicesImpl.getAssociateDetails(i).getSalary().getMonthlyTax());
	}
	
}
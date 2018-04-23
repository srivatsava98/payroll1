package com.cg.payroll.main;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;

public class MainClass1 {
	
	public static void main(String[] args) {
		String LastNameToBeSearch="S";
		Associate associate = searchAssociate(LastNameToBeSearch);
		if(associate!=null)
			System.out.println(associate.getFirstName()+" "+associate.getLastName()+" "+associate.getSalary().getBasicSalary());
		else
			System.out.println("No Details Found");
	}
	public static Associate searchAssociate(String LastName){
		Associate[]associates = new Associate[4];
		associates[0] = new Associate(111, 150000, "M", "S", "Java", "training", "FFQPS2110F", "sri@abc.com", new Salary(15000f, 1000f, 1000f, 1500f, 1000f, 1000f, 100f, 1500f, 100f, 1300f, 10000f), new BankDetails(1111, "AXIS", "AXIS1234"));
		associates[1] = new Associate(112, 140000, "V", "S", "Java", "training", "AAAAA1111", "vis@abc.com", new Salary(25000f, 1000f, 2000f, 1000f, 1500f, 1000f, 1000f, 2000f, 1200f, 15000f, 20000f), new BankDetails(1234, "HDFC", "HDFC1234"));	
		associates[2] = new Associate(113, 130000, "P", "N", "Java", "training", "AAAAA1111", "pav@abc.com", new Salary(20000f, 1000f, 2000f, 1000f, 1500f, 1000f, 1000f, 2000f, 1200f, 15000f, 15000f), new BankDetails(4567, "SCB", "SCB1234"));
		for(Associate associate : associates){
			if(associate!=null&&associate.getSalary().getBasicSalary()>=15000&&associate.getLastName()==LastName)
				System.out.println(associate.getFirstName()+" "+associate.getLastName()+" "+associate.getSalary().getBasicSalary());
				return associate;
		}
		return null;
		
	}
}


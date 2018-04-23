package com.cg.payroll.daoservices;
import com.cg.payroll.beans.Associate;
public class PayrollDAOServicesImpl implements PayrollDAOServices {

	public static Associate[] associateList = new Associate[10];
	public static int ASSOCIATE_ID_COUNTER=111;
	public static int ASSOCIATE_IDX_COUNTER=0;

	@Override
	public int insertAssociate(Associate associate){
		associate.setAssociateId(ASSOCIATE_ID_COUNTER++);
		associateList[ASSOCIATE_IDX_COUNTER++]=associate;
		if(ASSOCIATE_IDX_COUNTER==0.7*associateList.length){
			Associate temp[]=new Associate[10+associateList.length];
			System.arraycopy(associateList, 0, temp, 0, associateList.length);
			associateList = temp;
		return associate.getAssociateId();
		}
		return 0;
	}	
	@Override
	public boolean updateAssociate(Associate associate){
		for (int i=0;i<associateList.length;i++) 
			if(associateList[i]!=null&&associateList[i].getAssociateId() == associate.getAssociateId()){
				associateList[i]=associate;
			return true;
		}
		return false;
	}	
	
	@Override
	public boolean deleteAssociate(int associateId){
		for(int i=0;i<associateList.length;i++)
			if(associateList[i]!=null&&associateId==associateList[i].getAssociateId()){
				associateList[i]=null;
				ASSOCIATE_IDX_COUNTER--;
				if(associateList[i]!=null)
			return true;
		}
		return false;
	}	
	
	@Override
	public Associate getAssociate(int associateId){
		for(int i=0;i<associateList.length;i++)
			if(associateList[i].getAssociateId()==associateId){
				return associateList[i];
		}
		return null;
	}
	
	@Override
	public Associate[] getAssociates(){
		return associateList;
	}
}

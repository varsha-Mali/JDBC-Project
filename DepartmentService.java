package org.AlumniaSystem.Service;

import org.AlumniaSystem.Model.DepartmentModel;
import org.AlumniaSystem.Repository.DepartmentRepository;

public class DepartmentService
{ 
	DepartmentRepository deRepo=new DepartmentRepository();
	public boolean isAddDepartment(String Dept_Name,String HOD,int aid)
    {
		return deRepo.isAddDepartment( Dept_Name,HOD,aid);
    }
	public int getAdminID()
	{
		return deRepo.getAdminID();
	}

}

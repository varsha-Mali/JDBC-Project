package org.AlumniaSystem.Service;

import java.util.ArrayList;

import org.AlumniaSystem.Model.AdminModel;
import org.AlumniaSystem.Model.AlumniaModel;
import org.AlumniaSystem.Repository.AdminRepository;

public class AdminService
{
	AdminRepository AdRepo=new AdminRepository();
	public boolean AuthorizedAdmin(String adminName, String pass)
	{
		
		return AdRepo.AuthorizedAdmin(adminName,pass);
	}
    public ArrayList<AlumniaModel> isgetEventWiseAlumin(int  Events_ID)
	 {
		  return AdRepo.isgetEventWiseAlumin(Events_ID);
	 }
    public boolean isTakeAttendence(int Alumin_ID,int Events_ID,int Attendence)
    {
    	return AdRepo.isTakeAttendence(Alumin_ID, Events_ID, Attendence);
    }
}

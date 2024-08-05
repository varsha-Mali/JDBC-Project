package org.AlumniaSystem.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.AlumniaSystem.Model.AlumniaModel;
import org.AlumniaSystem.Model.EventsModel;
import org.AlumniaSystem.Repository.AlumniaRepository;

public class AlumniaService 
{
   AlumniaRepository alRepo=new AlumniaRepository();
   public boolean isAddAlumnia(String Name,String Email,String Profession,int Phone_No,int YearJoin,int YearPass,String uname,String pass,String dName)
   {
	   return alRepo.isAddAlumnia(Name, Email, Profession,Phone_No, YearJoin, YearPass, uname,pass,dName);
   }
   public List<AlumniaModel> getAllDetails() 
   {
	  return alRepo.getAllDetails();
   }
   public boolean updateAlumniaDetails(String Alumin_Name, String Email, String Profession,int phone_No, int YearJoin, int YearPass,String uname,String pass,int aid)
   {
	  return alRepo.updateAlumniaDetails(Alumin_Name, Email, Profession,phone_No, YearJoin, YearPass, uname,pass,aid);
   }
   public boolean deleteAlumniaById(int adid)
   {
	  return alRepo.deleteAlumniaByIdById(adid);
   }
   public boolean SortAlumniaYearWise() 
   {
	return alRepo.SortAlumniaYearWise();
   }
   public boolean MostSeniorAlumnia()
   {
	 return alRepo.MostSeniorAlumnia();
   }
   public LinkedHashMap<String, ArrayList<String>> getDepartmentWiseEventsNames() 
   {
      return alRepo.getDepartmentWiseEventsNames();
   }
  public boolean Registration_For_Events(int idd,String EName)
  {
	 return alRepo.Registration_For_Events(idd,EName);
  }
  public int AuthorizedUser(String uName,String Pass) 
  {
	 return alRepo.AuthorizedUser(uName,Pass);
  }

 
  
}
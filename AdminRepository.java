package org.AlumniaSystem.Repository;

import java.util.ArrayList;

import org.AlumniaSystem.Config.DBConfig;
import org.AlumniaSystem.Config.DBHelper;
import org.AlumniaSystem.Model.AdminModel;
import org.AlumniaSystem.Model.AlumniaModel;

public class AdminRepository extends DBHelper
{ 
    
	public boolean AuthorizedAdmin(String adminName, String pass) 
	{
		 try
    	 {
    		 stmt=conn.prepareStatement("Select * from Admin where Password=? and Admin_Name=?");
    		 stmt.setString(1, pass);
    		 stmt.setString(2, adminName);
             rs = stmt.executeQuery();//results the one resultset object
                //  stmt.executeUpdate();returns the integer (insert ,update,delete sql query) 
          if (rs.next())       
          {
                return true;            
                
          }
    
          } 
    	 catch (Exception ex) 
    	 {
              System.out.println("Error is"+ex);
         }
          return false;
    	 
	}
	public ArrayList<AlumniaModel>isgetEventWiseAlumin(int  Events_ID)
	{
	    ArrayList<AlumniaModel>al=new ArrayList<AlumniaModel>();
	   try
	   {
		   stmt=conn.prepareStatement("select s.Alumin_ID,s.Name from Alumnia_Registration s inner join registration_for_events re on s.Alumin_ID=re.alumin_ID inner join Events e on e.Events_ID=re.Events_ID where re.Events_ID=?");
		   stmt.setInt(1, Events_ID);
		   rs=stmt.executeQuery();
		   while(rs.next())
		   {
			   AlumniaModel amModel=new AlumniaModel();
			   amModel.setAlumin_ID(rs.getInt(1));
			   amModel.setName(rs.getString(2));
			   al.add(amModel);
			   
		   }
		   return al;
	   }
	   catch(Exception ex)
	   {
		   System.out.println("Error is:"+ex);
		   return null;
	   }
	}
	public boolean isTakeAttendence(int Alumin_ID,int Events_ID,int Attendence)
	{
		try
		{
			stmt=conn.prepareStatement("insert into Attendence values(?,?,?)");
			stmt.setInt(1, Alumin_ID);
			stmt.setInt(2, Events_ID);
			stmt.setInt(3, Attendence);
		    int value=stmt.executeUpdate();
		    if(value>0)
		    {
		    	return true;
		    }
		    else
		    {
		    	return false;
		    }
			
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
			return false;
		}
	}
}

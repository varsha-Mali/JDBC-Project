package org.AlumniaSystem.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.AlumniaSystem.Config.DBHelper;
import org.AlumniaSystem.Model.AlumniaModel;
import org.AlumniaSystem.Model.EventsModel;

public class AlumniaRepository extends DBHelper {
	private List<AlumniaModel> list = new ArrayList<AlumniaModel>();
	private List<EventsModel>l=new ArrayList<EventsModel>();
//	private LinkedHashMap<String,Integer>map;
	LinkedHashMap<String,ArrayList<String>>DepartmentWiseEventsMap;
	public boolean isAddAlumnia(String Name, String Email, String Profession, int Phone_No, int YearJoin, int YearPass,
			String uname, String pass, String dName) {
		int did = 0;
		try {
			// here we get Depatment Id from department table using dName.
			stmt = conn.prepareStatement("select Dept_ID from department where Dept_Name=?");
			stmt.setString(1, dName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				did = rs.getInt("Dept_ID");
			} else {
				System.out.println("Department Not Found..............!");
			}

			stmt = conn.prepareStatement("insert into Alumnia_Registration values('0',?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, did);
			stmt.setString(2, Name);
			stmt.setString(3, Email);
			stmt.setInt(4, Phone_No);
			stmt.setString(5, Profession);
			stmt.setInt(6, YearJoin);
			stmt.setInt(7, YearPass);
			stmt.setString(8, uname);
			stmt.setString(9, pass);
			int value = stmt.executeUpdate();
			if (value > 0) 
			{
				return true;
			} 
			else 
			{
				return false;
			}
		} catch (Exception ex) {
			System.out.println("Error is:" + ex);
			return false;
		}
	}

	public List<AlumniaModel> getAllDetails() {
		try {
			stmt = conn.prepareStatement(
					" select a. Alumin_ID,d.Dept_ID,a.Name,a.Email,a.Phone_No,a.Profession,a.Year_of_joining,a.Year_of_Passing,a.UserName,a.Password "
							+ "from Alumnia_Registration a inner join Department d on a.dept_ID=d.dept_ID");
			rs = stmt.executeQuery();
			while (rs.next()) {
				AlumniaModel AModel = new AlumniaModel();
				AModel.setAlumin_ID(rs.getInt(1));
				AModel.setDept_id(rs.getInt(2));
				AModel.setName(rs.getString(3));
				AModel.setEmail(rs.getString(4));
				AModel.setPhone_No(rs.getInt(5));
				AModel.setProfession(rs.getString(6));
				AModel.setYearjoin(rs.getInt(7));
				AModel.setYearPass(rs.getInt(8));
				AModel.setUsername(rs.getString(9));
				AModel.setPassword(rs.getString(10));
				list.add(AModel);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is:" + ex);
			return null;
		}
	}

	public boolean updateAlumniaDetails(String Alumin_Name, String Email, String Profession, int phone_No, int YearJoin,
			int YearPass, String uname, String pass, int aid) {
		try {
			stmt = conn.prepareStatement(
					"update Alumnia_Registration set Name=?,Email=?,Profession=?,phone_No=?,Year_of_Joining=?,Year_of_Passing=?,UserName=?,Password=? where Alumin_ID=?");
			stmt.setString(1, Alumin_Name);
			stmt.setString(2, Email);
			stmt.setString(3, Profession);
			stmt.setInt(4, phone_No);
			stmt.setInt(5, YearJoin);
			stmt.setInt(6, YearPass);
			stmt.setString(7, uname);
			stmt.setString(8, pass);
			stmt.setInt(9, aid);
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			System.out.println("Error is: " + e);
			return false;
		}
	}

	public boolean deleteAlumniaByIdById(int adid) {
		try {
			stmt = conn.prepareStatement("delete from Alumnia_Registration where Alumin_ID=?");
			stmt.setInt(1, adid);
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			System.out.println("Error is: " + e);
			return false;
		}
	}
	public boolean SortAlumniaYearWise()
	{
		try
		{
			stmt=conn.prepareStatement("select * from  Alumnia_Registration order by Year_of_Passing");
			rs=stmt.executeQuery();
			System.out.println("Alumin_ID"+"\t"+"Name"+"\t"+"Year_of_Passing"+"\t\t\t"+"Phone_No"+"\t"+"Email");
			while(rs.next())
			{
				         System.out.println(rs.getInt("alumin_id") + "\t\t" +rs.getString("Name") + "\t\t" +
                         rs.getInt("year_of_Passing") + "\t\t\t" +
                         rs.getInt("Phone_No") + "\t\t" +
                         rs.getString("Email"));
			}
			return  true;
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
			return false;
		}
	}

	public boolean MostSeniorAlumnia()
	{
		try
		{
			stmt=conn.prepareStatement(" SELECT * FROM Alumnia_Registration ORDER BY year_of_passing ASC LIMIT 1");
			rs=stmt.executeQuery();
			System.out.println("Alumin_ID"+"\t"+"Name"+"\t"+"Year_of_Passing"+"\t\t\t"+"Phone_No"+"\t"+"Email");
			while(rs.next())
			{
				      System.out.println(rs.getInt("alumin_id") + "\t\t" +rs.getString("Name") + "\t\t" +
                         rs.getInt("year_of_Passing") + "\t\t\t" +
                         rs.getInt("Phone_No") + "\t\t" +
                         rs.getString("Email"));
			}
			return  true;
			
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
		return false;
	}
	 public LinkedHashMap<String,ArrayList<String>>getDepartmentWiseEventsNames()
	    {
	    	try
	    	{
	    		this.DepartmentWiseEventsMap=new LinkedHashMap<String,ArrayList<String>>();
	    		stmt=conn.prepareStatement("select dept_Name from Department");
	    		rs=stmt.executeQuery();
	    		while(rs.next())
	    		{
	    			String dept_Name=rs.getString(1);
	    			PreparedStatement stmt1=conn.prepareStatement("select e.event_name,d.dept_name from Events e inner join dept_eventjoin dejoin on e.Events_id=dejoin.Events_Id inner join Department d on dejoin.dept_ID=d.dept_ID where d.dept_Name=?");
	    			stmt1.setString(1,dept_Name);
	    			ResultSet rs1=stmt1.executeQuery();
	    			ArrayList<String>EventsNames=new ArrayList<String>();
	    			while(rs1.next())
	    			{
	    				EventsNames.add(rs1.getString(1));
	    			}
	    			this.DepartmentWiseEventsMap.put(dept_Name, EventsNames);
	    		}
	    		return this.DepartmentWiseEventsMap;
	    	}
	    	catch(Exception ex)
	    	{
	    		System.out.println("Error is:"+ex);
	    		return null;
	    	}
	    }
	 
	 
	 public LinkedHashMap<String,ArrayList<String>>getEventsByDepartmentName(String dept_Name)
	    {
	    	try
	    	{
	    		this.DepartmentWiseEventsMap=new LinkedHashMap<String,ArrayList<String>>();
	    			PreparedStatement stmt1=conn.prepareStatement("select e.event_name,d.dept_name from Events e inner join dept_eventjoin dejoin on e.Events_id=dejoin.Events_Id inner join Department d on dejoin.dept_ID=d.dept_ID where d.dept_Name=?");
	    			stmt1.setString(1,dept_Name);
	    			ResultSet rs1=stmt1.executeQuery();
	    			ArrayList<String>AreaNames=new ArrayList<String>();
	    			while(rs1.next())
	    			{
	    				AreaNames.add(rs1.getString(1));
	    			}
	    			this.DepartmentWiseEventsMap.put(dept_Name, AreaNames);
	    		return this.DepartmentWiseEventsMap;
	    	}
	    	catch(Exception ex)
	    	{
	    		System.out.println("Error is:"+ex);
	    		return null;
	    	}
	    } 	
	     
	
	public boolean Registration_For_Events(int aId,String eName)
	{
		
		int  eId=0;
		try 
		{
			
			stmt = conn.prepareStatement("select Events_ID from Events where Event_Name=?");
			stmt.setString(1, eName);
			rs = stmt.executeQuery();
			if (rs.next()) 
			{
				eId = rs.getInt("Events_ID");
			} 
			else
			{
				System.out.println("Events Not Found..............!");
			}
			
			stmt=conn.prepareStatement("insert into registration_for_Events values('0',?,?)");
			stmt.setInt(1, aId);
			stmt.setInt(2, eId);
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
		}
		return false;
    }

	public int AuthorizedUser(String uName,String Pass) 
    {
	 try
	 {
	    stmt=conn.prepareStatement("Select  Alumin_ID from Alumnia_Registration where UserName=? and Password=?");
	    stmt.setString(1,uName);
	    stmt.setString(2,Pass);
	    rs = stmt.executeQuery();
	    if(rs.next())       
	    {
	         return rs.getInt("Alumin_ID");            
	    }
	    else 
	    {
	    	return 0;
	    }
	  } 
	  catch (Exception ex) 
	  {
	       System.out.println("Error is"+ex);
	       return 0;
	   }
	    	 
   }

}
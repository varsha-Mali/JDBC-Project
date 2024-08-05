package org.AlumniaSystem.Repository;

import org.AlumniaSystem.Config.DBHelper;
import org.AlumniaSystem.Model.DepartmentModel;

public class DepartmentRepository extends DBHelper 
{
	
	
	public int getAdminID()
	{
		int aid=0 ;
		try
		{
		 stmt=conn.prepareStatement("select Admin_ID from Admin");
		 rs=stmt.executeQuery();
		 if(rs.next())
		 {
			 aid=rs.getInt(1);
		 }
		return aid;
		}
		catch(Exception ex)
		{
			System.out.println("Error is"+ex);
		}
	    return 0;
		
	}

	public boolean isAddDepartment(String dept_Name, String hOD, int aid)
	{
		try
		{
			stmt=conn.prepareStatement("insert into Department values('0',?,?,?)");
			stmt.setString(1, dept_Name);
			stmt.setString(2, hOD);
			stmt.setInt(3,aid);
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
			return false;
		}
		

	}

}

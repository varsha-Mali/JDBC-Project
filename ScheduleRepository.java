package org.AlumniaSystem.Repository;

import java.util.ArrayList;
import java.util.List;

import org.AlumniaSystem.Config.DBHelper;
import org.AlumniaSystem.Model.EventsModel;
import org.AlumniaSystem.Model.ScheduleModel;

public class ScheduleRepository extends DBHelper
{
	private List<ScheduleModel>list1=new ArrayList<ScheduleModel>();
    public boolean isAddSchedule(ScheduleModel sModel,String eName)
    {
    	int eId = 0;
    	try
    	{
    		stmt  = conn.prepareStatement("select Events_ID from Events where Event_Name=?");
    		stmt.setString(1, eName);
    		rs = stmt.executeQuery();
    		if(rs.next()) 
    		{
    			eId = rs.getInt("Events_ID");
    		}
    		else
    		{
    			System.out.println("Event Not Found.............!");
    		}
    		stmt=conn.prepareStatement("insert into Schedule values('0',?,?,?)");
    		stmt.setString(1, sModel.getSchedule_Date());
    		stmt.setString(2,sModel.getSchedule_Time());
    		stmt.setInt(3, eId);
    		 int value=stmt.executeUpdate();
 			 return value>0?true:false;
    	}
    	catch(Exception ex)
    	{
    		System.out.println("Error is:"+ex);
    		return false;
    	}
    }
	public List<ScheduleModel> getAllSchedules()
	{
		try
		{
			stmt=conn.prepareStatement(" select s.Schedule_ID,s.Schedule_Time,s.Schedule_Date,e.Events_ID "
					+ "from Events e inner join Schedule s on s.Events_ID=e.Events_ID");
		    rs=stmt.executeQuery();
		    while(rs.next())
		     {
		    	ScheduleModel scModel=new ScheduleModel();
		         scModel.setSchedule_ID(rs.getInt(1));
		    	 scModel.setSchedule_Time(rs.getString(2));
		    	 scModel.setDate(rs.getString(3));
		    	 scModel.setEvent_ID(rs.getInt(4));
		    	list1.add(scModel);
		    }
		    return list1.size()>0?list1:null;
		}
		catch(Exception ex) 
		{
			System.out.println("Error is:"+ex);
			return null;
		}
	}
}

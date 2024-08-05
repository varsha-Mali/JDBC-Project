package org.AlumniaSystem.Repository;
import java.util.ArrayList;
import java.util.List;
import org.AlumniaSystem.Config.DBHelper;
import org.AlumniaSystem.Model.EventsModel;

public class EventsRepository extends DBHelper 
{
	private List<EventsModel>list=new ArrayList<EventsModel>();
	public boolean isAddEvents(EventsModel eModel, String dName) 
	{
		int did = 0;
		try {
			// here we get Depatment Id from department table using dName.
			stmt = conn.prepareStatement("select Dept_ID from department where Dept_Name=?");
			stmt.setString(1, dName);
			rs = stmt.executeQuery();
			if (rs.next()) 
			{
				did = rs.getInt("Dept_ID");
			} 
			else 
			{
				System.out.println("Department Not Found..............!");
			}
			
			// here we add Event information.....
			
			stmt = conn.prepareStatement("insert into events values ('0',?,curDate(),?)");
			stmt.setString(1,eModel.getEvent_Name());
			stmt.setInt(2, did);
			
			int value = stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else 
			{
				return false;
			}
		} 
		catch (Exception ex)
		{
			System.out.println("Error is:" + ex);
			return false;
		}
	}
	public List<EventsModel> getAllEvents() 
	{
		try
		{
			stmt=conn.prepareStatement("select e.Events_ID,e.Event_Name,e.Event_Date,d.Dept_ID from Events e"
					+ " inner join Department d on e.Dept_ID=d.Dept_ID");
		    rs=stmt.executeQuery();
		    while(rs.next())
		    {
		    	EventsModel EModel=new EventsModel();
		         EModel.setEvent_ID(rs.getInt(1));
		    	 EModel.setEvent_Name(rs.getString(2));
		    	 EModel.setDate(rs.getString(3));
		    	 EModel.setDept_id(rs.getInt(4));
		    	list.add(EModel);
		    }
		    return list.size()>0?list:null;
		}
		catch(Exception ex) 
		{
			System.out.println("Error is:"+ex);
			return null;
		}
	}
}

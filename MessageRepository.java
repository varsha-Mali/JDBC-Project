package org.AlumniaSystem.Repository;

import java.util.ArrayList;
import java.util.List;

import org.AlumniaSystem.Config.DBHelper;
import org.AlumniaSystem.Model.EventsModel;
import org.AlumniaSystem.Model.MessageModel;

public class MessageRepository extends DBHelper 
{
	private List<MessageModel>list=new ArrayList<MessageModel>();
     public boolean getMessage(MessageModel msgModel,String Ename)
     {
    	 int eId = 0;
     	try
     	{
     		stmt  = conn.prepareStatement("select Events_ID from Events where Event_Name=?");
     		stmt.setString(1, Ename);
     		rs = stmt.executeQuery();
     		if(rs.next()) 
     		{
     			eId = rs.getInt("Events_ID");
     		}
     		else
     		{
     			System.out.println("Event Not Found.............!");
     		}
     		stmt=conn.prepareStatement("insert into Message values(?,?)");
     		stmt.setInt(1, eId);
     		stmt.setString(2,msgModel.getMessage());
     		 int value=stmt.executeUpdate();
  			 return value>0?true:false;
     	}
     	catch(Exception ex)
     	{
     		System.out.println("Error is:"+ex);
     		return false;
     	}
     }

	public List<MessageModel> getAllMessage()
	{
		try
		{
			stmt=conn.prepareStatement("select e.Events_ID,m.Messages from Events e inner join Message m on e.Events_ID=m.Events_ID");
		    rs=stmt.executeQuery();
		    while(rs.next())
		    {
		    	MessageModel msgModel=new MessageModel();
		         msgModel.setEvent_ID(rs.getInt(1));
		    	 msgModel.setMessage(rs.getString(2));
		    	list.add(msgModel);
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

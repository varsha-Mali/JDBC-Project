package org.AlumniaSystem.Repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.AlumniaSystem.Config.DBHelper;
import org.AlumniaSystem.Model.AlumniaModel;
import org.AlumniaSystem.Model.EventsModel;
import org.AlumniaSystem.Model.FeedBackModel;

public class FeedBackRepository extends DBHelper 
{
	private List<FeedBackModel>list=new ArrayList<FeedBackModel>();
//	public boolean isGiveFeedBack(int alumin_ID, int event_ID, String feedBack, int rating) 
//	{
//		try
//		{
//		   stmt=conn.prepareStatement("insert into FeedBack values(?,?,?,?)");
//		   stmt.setInt(1, alumin_ID);
//		   stmt.setInt(2, event_ID);
//		   stmt.setString(3, feedBack);
//		   stmt.setInt(4, rating);
//           int value=stmt.executeUpdate();
//           if(value>0)
//           {
//        	   return true;
//           }
//           else
//           {
//        	   return false;
//           }	
//		}
//		catch(Exception ex)
//		{
//			System.out.println("Error is:"+ex);
//			return false;
//		}
//	} 
	public  boolean getAllFeedBack() 
	{
		try
		{
			stmt=conn.prepareStatement("select a.name,e.Event_Name,f.Feedback,f.rating from Feedback f inner join Events e on f.Events_ID=e.Events_ID inner join alumnia_Registration a on f.Alumin_ID=a.Alumin_ID ");
		 //   stmt.setInt(1,id_1);
		   // stmt.setInt(2,id_2);
			rs=stmt.executeQuery();
			System.out.println("Alumin_Name"+"\t\t"+"Events_Name"+"\t\t"+"FeedBack"+"\t\t\t"+"Rating");
		    while(rs.next())
		    {
		    	System.out.println(rs.getString("a.name")+"\t\t\t"+rs.getString("e.Event_Name")+"\t\t"+rs.getString("f.Feedback")+"\t\t\t"+rs.getInt("f.rating"));
		    	
		    }
//		    FeedBackModel fModel=new FeedBackModel();
//	    	AlumniaModel a= new AlumniaModel();
//	    	EventsModel e= new EventsModel();
//	    	
//	        fModel.setAlumni_ID(rs.getInt(1));
//	        fModel.setEvnets_ID(rs.getInt(2));
//	         fModel.setFeedback(rs.getString(3));
//	         fModel.setRating(rs.getInt(4));
//	    	list.add(fModel);
//		    return list.size()>0?list:null;
		    return true;
		    
		}
		catch(Exception ex) 
		{
			System.out.println("Error is:"+ex);
			return false;
		}
	}
	
	public boolean isGiveFeedback(int Alumin_ID,int Event_ID,String FeedBack,int Rating)
	{
		String checkAttendanceSql = "SELECT COUNT(*) AS count FROM Attendence WHERE Alumin_ID = ? AND Events_ID = ?";
        String insertFeedbackSql = "INSERT INTO Feedback (Alumin_ID, Events_ID, FeedBack,Rating) VALUES (?, ?, ?,?)";
		try
		{
			 PreparedStatement checkStmt = conn.prepareStatement(checkAttendanceSql);
             PreparedStatement insertStmt = conn.prepareStatement(insertFeedbackSql);
             {
            	// Check attendance
                 checkStmt.setInt(1, Alumin_ID);
                 checkStmt.setInt(2, Event_ID);
                  rs = checkStmt.executeQuery();
                 if (rs.next() && rs.getInt("count") > 0) {
                     // Insert feedback
                     insertStmt.setInt(1, Alumin_ID);
                     insertStmt.setInt(2, Event_ID);
                     insertStmt.setString(3, FeedBack);
                     insertStmt.setInt(4, Rating);
                     insertStmt.executeUpdate();
                     System.out.println("Feedback inserted successfully.");
                 } 
                 else
                 {
                     System.out.println("Alumni did not attend the event.");
                 }
             return true;
           }
		}     

		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);	
			return false;
		}
	}
	
	
	

}

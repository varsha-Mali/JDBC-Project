package org.AlumniaSystem.Service;

import java.util.List;

import org.AlumniaSystem.Model.FeedBackModel;
import org.AlumniaSystem.Repository.FeedBackRepository;

public class FeedBackService 
{
	FeedBackRepository feedRepo=new FeedBackRepository();
	public boolean isGiveFeedback(int Alumin_ID,int Event_ID,String FeedBack,int Rating)
	{
		return feedRepo.isGiveFeedback(Alumin_ID, Event_ID, FeedBack, Rating);
	}
	
	public boolean getAllFeedBack()
	{
	  return feedRepo.getAllFeedBack();	
	}
	
	
}

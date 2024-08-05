package org.AlumniaSystem.Service;
import java.util.List;

import org.AlumniaSystem.Model.MessageModel;
import org.AlumniaSystem.Repository.MessageRepository;

public class MessageService
{
     MessageRepository msgRepo=new MessageRepository();
     public boolean getMessage(MessageModel msgModel,String Ename)
     {
    	 return msgRepo.getMessage(msgModel, Ename);
     }
	public List<MessageModel> getAllMessage()
	{
		
		return msgRepo.getAllMessage();
	}
     
}

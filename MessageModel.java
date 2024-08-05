package org.AlumniaSystem.Model;

import org.AlumniaSystem.Config.DBHelper;

public class MessageModel extends EventsModel
{
      private int Message_ID;
      private String Message;
      private EventsModel eModel;
	public int getMessage_ID() {
		return Message_ID;
	}
	public void setMessage_ID(int message_ID) {
		Message_ID = message_ID;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public EventsModel geteModel() {
		return eModel;
	}
	public void seteModel(EventsModel eModel) {
		this.eModel = eModel;
	}
      
}

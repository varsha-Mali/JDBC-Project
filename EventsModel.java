package org.AlumniaSystem.Model;

import java.util.Date;

public class EventsModel extends DepartmentModel
{
    private int Event_ID;
    private String Event_Name;
    private DepartmentModel Dmodel;
	public int getEvent_ID() {
		return Event_ID;
	}
	public void setEvent_ID(int event_ID) {
		Event_ID = event_ID;
	}
	public String getEvent_Name() {
		return Event_Name;
	}
	public void setEvent_Name(String event_Name) {
		Event_Name = event_Name;
	}
	public DepartmentModel getDmodel() {
		return Dmodel;
	}
	public void setDmodel(DepartmentModel dmodel) {
		Dmodel = dmodel;
	}
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    
}

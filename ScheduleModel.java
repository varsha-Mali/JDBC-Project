package org.AlumniaSystem.Model;

import java.sql.Date;

public class ScheduleModel extends EventsModel 
{
	private int Schedule_ID;
	private String Schedule_Time;
	private String Schedule_Date;
	private EventsModel EModel;
	public int getSchedule_ID() {
		return Schedule_ID;
	}
	public void setSchedule_ID(int schedule_ID) {
		Schedule_ID = schedule_ID;
	}
	public String getSchedule_Time() {
		return Schedule_Time;
	}
	public void setSchedule_Time(String schedule_Time) {
		Schedule_Time = schedule_Time;
	}
	public String getSchedule_Date() {
		return Schedule_Date;
	}
	public void setSchedule_Date(String schedule_Date) {
		Schedule_Date = schedule_Date;
	}
	public EventsModel getEModel() {
		return EModel;
	}
	public void setEModel(EventsModel eModel) {
		EModel = eModel;
	}

}

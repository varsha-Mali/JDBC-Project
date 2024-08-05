package org.AlumniaSystem.Service;

import java.util.List;

import org.AlumniaSystem.Model.EventsModel;
import org.AlumniaSystem.Model.ScheduleModel;
import org.AlumniaSystem.Repository.ScheduleRepository;

public class ScheduleService 
{
	ScheduleRepository scRepo= new ScheduleRepository();

	public boolean isAddSchedule(ScheduleModel scModel, String eName) 
	{
		return scRepo.isAddSchedule(scModel, eName);
	}
	public List<ScheduleModel> getAllSchedule()
	{
		return scRepo.getAllSchedules();
	}
	
	
		
	
}

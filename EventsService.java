package org.AlumniaSystem.Service;
import java.util.List;
import org.AlumniaSystem.Model.EventsModel;
import org.AlumniaSystem.Repository.EventsRepository;

public class EventsService
{
	EventsRepository eRepo = new EventsRepository();
	public boolean isAddUserEvents(EventsModel eModel, String dName) 
	{
		return eRepo.isAddEvents(eModel, dName);
	}
	public List<EventsModel>getAllEvents()
	{
		return eRepo.getAllEvents();
	}
     
}

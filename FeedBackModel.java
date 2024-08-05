package org.AlumniaSystem.Model;

public class FeedBackModel 
{
     private int Alumni_ID;
     private int Evnets_ID;
     private String Feedback;
     private int Rating;
    private AlumniaModel AlModel;
    private EventsModel EModel;
     
	public AlumniaModel getAlModel() {
		return AlModel;
	}
	public void setAlModel(AlumniaModel alModel) {
		AlModel = alModel;
	}
	public EventsModel getEModel() {
		return EModel;
	}
	public void setEModel(EventsModel eModel) {
		EModel = eModel;
	}
	
	public int getAlumni_ID() {
		return Alumni_ID;
	}
	public void setAlumni_ID(int alumni_ID) {
		Alumni_ID = alumni_ID;
	}
	public int getEvnets_ID() {
		return Evnets_ID;
	}
	public void setEvnets_ID(int evnets_ID) {
		Evnets_ID = evnets_ID;
	}
	public String getFeedback() {
		return Feedback;
	}
	public void setFeedback(String feedback) {
		Feedback = feedback;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	
}

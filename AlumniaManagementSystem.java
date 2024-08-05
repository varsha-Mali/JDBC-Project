package org.AlumniaSystem.Client;
import java.util.*;

import org.AlumniaSystem.Model.AdminModel;
import org.AlumniaSystem.Model.AlumniaModel;
import org.AlumniaSystem.Model.DepartmentModel;
import org.AlumniaSystem.Model.EventsModel;
import org.AlumniaSystem.Model.FeedBackModel;
import org.AlumniaSystem.Model.MessageModel;
import org.AlumniaSystem.Model.ScheduleModel;
import org.AlumniaSystem.Service.AdminService;
import org.AlumniaSystem.Service.AlumniaService;
import org.AlumniaSystem.Service.DepartmentService;
import org.AlumniaSystem.Service.EventsService;
import org.AlumniaSystem.Service.FeedBackService;
import org.AlumniaSystem.Service.MessageService;
import org.AlumniaSystem.Service.ScheduleService;

public class AlumniaManagementSystem 
{

	public static void main(String[] args) 
	{
		AdminService AdService=new AdminService();
		DepartmentService deptService=new DepartmentService();
		EventsService eventService=new EventsService();
		ScheduleService scheduleService=new ScheduleService();
		MessageService msgService=new MessageService();
		AlumniaService alService=new AlumniaService();
		FeedBackService feedService=new FeedBackService();
	    Scanner sc=new Scanner(System.in);
	    int choice;
	    int y,id;
	    do
	    {
	    	System.out.println("1.For Admin");
	    	System.out.println("2 For Alumnia");
	    	System.out.println("Enter Your Choice:");
	    	choice=sc.nextInt();
	    	
	    	if(choice==1)
	    	{
	    		AdminModel model=new AdminModel();
	    		sc.nextLine();
    	    	System.out.println("Enter Admin Name:");
    	    	String adminName=sc.nextLine();
    	    	System.out.println("Enter Admin Password:");
    	    	String pass=sc.nextLine();
    	    	model.setAdmin_Name(adminName);
    	    	model.setPassword(pass);
    	    	boolean b=AdService.AuthorizedAdmin(adminName,pass);
    	    	if(b)
    	    	{
    	    		System.out.println("Admin Login SuccessFully..");
    	    		System.out.println("******************Admin Menu***********************");
	    	    	 do
	    	    	 {
	    	    		 System.out.println("1.Add Department");
	    	    		 System.out.println("2.Add Evnets");
	    	    		 System.out.println("3.Show Events");
	    	    		 System.out.println("4.Add Schedule");
	    	    		 System.out.println("5.Add Message");
	    	    		 System.out.println("6.Sort Alumnia YearWise");
	    	    		 System.out.println("7.Most Senior Alumnia");
         	    		 System.out.println("8.Take Attendence those present in meeting");
	    	    		 System.out.println("Enter Your Choice:");
		    	    	 choice=sc.nextInt();
		    	    	 switch(choice)
		    	    	 {
		    	    	   case 1:
		    	    		   sc.nextLine();
		    	    		   System.out.println("************************Add Department************************");
		    	    		   System.out.println("Enter Department Name:");
		    	    		   String Dept_Name=sc.nextLine();
		    	    		   System.out.println("Enter Department HOD Name:");
		    	    		   String HOD=sc.nextLine();
		    	    		   DepartmentModel DModel=new DepartmentModel();
		    	    		   DModel.setDept_Name(Dept_Name);
		    	    		   DModel.setDept_HOD(HOD);
		    	    		   int aid=deptService.getAdminID();
		    	    		   b=deptService.isAddDepartment(Dept_Name,HOD,aid);
		    	    		   if(b)
		    	    		   {
		    	    			   System.out.println("Department Added Successfully...");
		    	    		   }
		    	    		   else
		    	    		   {
		    	    			   System.out.println("Department Not Added...");
		    	    		   }
		    	    		 break;
		    	    	   case 2:
		    	    		   System.out.println("****************************View Events**********************");
		    	    			  List<EventsModel> list=eventService.getAllEvents();
		    	 				  if(list!=null)
		    	 				  {
		    	 					 System.out.println("Events_ID"+"\t"+"Events_Name"+"\t\t"+"Events_Date"+"\t\t"+"Dept_ID");
		    	 					 list.forEach((m)->System.out.println(m.getEvent_ID()+"\t\t"+m.getEvent_Name()+"\t\t\t"+m.getDate()+"\t\t"+m.getDept_id()));
		    	 				  }
		    	 				  else
		    	 				  {
		    	 					 System.out.println("There is no Events Present");
		    	 				  }
		    	 				 break;
		    	    	   case 3:
		    	    		   
		    	    		   System.out.println("***********************Add Evnets**********************");
		    	    		   sc.nextLine();
		    	    		   System.out.println("Enter Department Name:");
		    	    		   String dName=sc.nextLine();
		    	    		   System.out.println("Enter Events ID:");
		    	    		   int Event_ID=sc.nextInt();
		    	    		   sc.nextLine();
		    	    		   System.out.println("Enter Events Name:");
		    	    		   String Event_Name=sc.nextLine();
		    	    		   EventsModel EModel=new EventsModel();
		    	    		   EModel.setEvent_ID(Event_ID);
		    	    		   EModel.setEvent_Name(Event_Name);
		    	    		   b=eventService.isAddUserEvents(EModel,dName);
		    	    		   if(b)
		    	    		   {
		    	    			   System.out.println("Event Added Successfully..");
		    	    		   }
		    	    		   else
		    	    		   {
		    	    			   System.out.println("Event Not Added");
		    	    		   }
		    	    		 break; 
		    	    	   case 4:
		    	    		   System.out.println("*************************Add Schedule************************");
		    	    		   sc.nextLine();
		    	    		   System.out.println("Enter Event Name:");
		    	    		   String eName = sc.nextLine();
		    	    		   System.out.println("Enter Schedule Time:");
		    	    		   String Schedule_Time=sc.nextLine();
		    	    		   System.out.println("Enter Schedule Date:");
		    	    		   String date=sc.nextLine();
		    	    		   ScheduleModel scModel=new ScheduleModel();
		    	    		   scModel.setSchedule_Date(date);
		    	    		   scModel.setSchedule_Time(Schedule_Time);
		    	    		   b=scheduleService.isAddSchedule(scModel,eName);
		    	    		   if(b)
		    	    		   {
		    	    			   System.out.println("Schedule Added SucessFully....");
		    	    		   }
		    	    		   else
		    	    		   {
		    	    			   System.out.println("Schedule Not Added");
		    	    		   }
		    	    		break;
		    	    	   case 5:
		    	    		   System.out.println("******************Add Message*********************");
		    	    		   sc.nextLine();
		    	    		   System.out.println("Enter Event Name:");
		    	    		    eName = sc.nextLine();
		    	    		    System.out.println("Enter Message:");
		    	    		    String msg=sc.nextLine();
		    	    		    MessageModel msgModel=new MessageModel();
		    	    		    msgModel.setMessage(msg);
		    	    		    b=msgService.getMessage(msgModel,eName);
		    	    		    if(b)
		    	    		    {
		    	    		    	System.out.println("Message Added Successfully..");
		    	    		    }
		    	    		    else
		    	    		    {
		    	    		    	System.out.println("Message Not Added");
		    	    		    }
		    	    		 break;   
		    	    	   case 6:
		    	    		   System.out.println("**************************Sort Alumnia YearWise******************************");
		    	    		   b=alService.SortAlumniaYearWise();
		    	    		   if(b)
		    	    		   {
		    	    			   System.out.println("Alumnia Sorted YearWise");
		    	    		   }
		    	    		   else
		    	    		   {
		    	    			   System.out.println("Something went Wrong");
		    	    		   }
		    	    		   break;
		    	    	   case 7:
		    	    		   System.out.println("*********************************Most Senior Alumnia***********************************");
		    	    		   b=alService.MostSeniorAlumnia();
		    	    		   if(b)
		    	    		   {
		    	    			   System.out.println("Most Senoir Alumnia is Present");
		    	    		   }
		    	    		   else
		    	    		   {
		    	    			   System.out.println("Most Senoir Alumnia is not Present in database");
		    	    		   }
		    	    		  break;
		    	    		  
		    	    	    case 8:
		    	    		   System.out.println("***********************Take Attendence**************************");
		    	    		   List<EventsModel> listR=eventService.getAllEvents();
		    	 				if(listR!=null)
		    	 				{
		    	 					System.out.println("Events_ID"+"\t"+"Events_Name"+"\t\t"+"Events_Date"+"\t\t"+"Dept_ID");
		    	 					listR.forEach((m)->System.out.println(m.getEvent_ID()+"\t\t"+m.getEvent_Name()+"\t\t\t"+m.getDate()+"\t\t"+m.getDept_id()));
		    	 				}
		    	 				else
		    	 				{
		    	 					System.out.println("There is no Events Present");
		    	 				}
		    	 				
		    	 				
		    	 				System.out.println("Enter Event ID:");
		    	 				int EID=sc.nextInt();
		    	 				ArrayList<AlumniaModel>al=AdService.isgetEventWiseAlumin(EID);
		    	 				if(al.size()>0)
		    	 				{
		    	 					for(AlumniaModel amModel:al)
			    	 				{
			    	 					System.out.println(amModel.getAlumin_ID()+"\t"+amModel.getName());
			    	 					int Alumin_ID=amModel.getAlumin_ID();
			    	 					System.out.println("1.Present   0.Absent");
			    	 					int Attend=sc.nextInt();
			    	 				b=AdService.isTakeAttendence(Alumin_ID, EID, Attend);
			    	 				if(b)
			    	 				{
			    	 					System.out.println("Attendence Marked");
			    	 				}
			    	 				else
			    	 				{
			    	 					System.out.println("Something went Wrong");
			    	 				}
			    	 					
			    	 		         }
		    	 				}
		    	 				else
		    	 				{
		    	 					System.out.println("NO Alumnia Present");
		    	 				}
		    	 				
		    	 				break;
		    	    	   default:
			    	    	   System.out.println("Wrong Choice");
		    	    	 }
	    	      
	    	    	 }while(choice<8);
    	    	}
    	    	else
    	    	{
    	    		System.out.println("Invalid Admin Login");
    	    	}
	    	}
	    	else 
	    	{
	    		 sc.nextLine();
    	    	 System.out.println("**********************Alumnia Menu***************************");
    	    	 do
    	    	 {
    	    		 
    	    		 System.out.println("1.Registration");
    	    		 System.out.println("2.Login Here");
    	    		 System.out.println("Enter Your Choice:");
    	    		 choice=sc.nextInt();
    	    		 switch(choice)
    	    		 {
    	    		       case 1:
    	    		    	     System.out.println("******************Registration***********************");
		    	    			 sc.nextLine();
			    	    		 System.out.println("Enter Department Name:");
			    	    		 String dName=sc.nextLine();
		    	    			 System.out.println("Enter Alumin Name:");
		    	    			 String Alumin_Name=sc.nextLine();
		    	    			 System.out.println("Enter Alumin Email_ID:");
		    	    			 String Email=sc.nextLine();
		    	    			 System.out.println("Enter Phone Number:");
		    	    			 int phone_No=sc.nextInt();
		    	    			 sc.nextLine();
		    	    			 System.out.println("Enter Alumin Profession:");
		    	    			 String Profession=sc.nextLine();
		    	    			 System.out.println("Enter Year of Joining:");
		    	    			 int YearJoin=sc.nextInt();
		    	    			 System.out.println("Enter Year of Passing:");
		    	    			 int YearPass=sc.nextInt();
		    	    			 sc.nextLine();
		    	    			 System.out.println("Enter UserName:");
		    	    			 String uname=sc.nextLine();
		    	    			 System.out.println("Enter Password:");
		    	    			 String pass=sc.nextLine();
		    	    			 AlumniaModel AModel=new AlumniaModel();
		    	    			 AModel.setName(Alumin_Name);
		    	    			 AModel.setDept_Name(dName);
		    	    			 AModel.setEmail(Email);
		    	    			 AModel.setProfession(Profession);
		    	    			 AModel.setPhone_No(phone_No);
		    	    			 AModel.setYearjoin(YearJoin);
		    	    			 AModel.setYearPass(YearPass);
		    	    			 AModel.setUsername(uname);
		    	    			 AModel.setPassword(pass);
		    	    			boolean b=alService.isAddAlumnia(Alumin_Name, Email, Profession,phone_No, YearJoin, YearPass, uname,pass,dName);
		    	    			 if(b)
		    	    			 {
		    	    				 System.out.println("Registration SuccessFully...");
		    	    			 }
		    	    			 else
		    	    			 {
		    	    				 System.out.println("Registration Failed");
		    	    			 }
		    	    			 break;
    	    		       case 2:
    	    		    	   sc.nextLine();
    	    		    	   System.out.println("*******************Login Here**********************");
    	    		    	   AlumniaModel aModel=new AlumniaModel();
    	    		    	   System.out.println("Enter Your UserName:");
    	    		    	   String uName=sc.nextLine();//adfgasd
                               //sc.nextLine();
    	    		    	   System.out.println("Enter Your Password:");
    	    		    	   String Pass=sc.nextLine();//zxcvzcv
    	    		    	
    	    		    	   id=alService.AuthorizedUser(uName,Pass);
    	    		    	   System.out.println("in Client Alumni Id:"+id);
    	    		    	   if(id!=0)
    	    		    	   {
    	    		    		   System.out.println("Login SuccessFully..");
    	    		    		   System.out.println("*****************DashBoard***********************************");
    	    		    		   do
    	    		    		   {
    	    		    			  System.out.println("1.View Alumnia Details");
    	    		    			  System.out.println("2.Update Alumnia Details");
    	    		    			  System.out.println("3.Delete Alumnia Details");
    	    		    			  System.out.println("4.Show Departmentwise Events");
    	    		    			  System.out.println("5.Registration for Events");
    	    		    			  System.out.println("6.View Schedule");
    	    		    			  System.out.println("7.View Messages");
    	    		    			  System.out.println("8.Give FeedBack");
    	    		    			  System.out.println("9.View All FeedBack");
    	    		    			  System.out.println("Enter Your Choice:");
    	    		    			  choice=sc.nextInt();
    	    		    			  switch(choice)
    	    		    			  {
    	    		    			    case 1:
    	    		    			    System.out.println("********************View Alumnia Details*******************");
    	    	    		    	    List<AlumniaModel>l=alService.getAllDetails();
    			    	 				if(l!=null)
    			    	 				{
    			    	 					
    			    	 					l.forEach((m)->System.out.println(m.getAlumin_ID()+"\t"+m.getDept_id()+"\t"+m.getName()+"\t"+m.getEmail()+"\t"+m.getPhone_No()+"\t"+m.getProfession()+"\t"+m.getYearjoin()+"\t"+m.getYearPass()+"\t"+m.getUsername()+"\t"+m.getPassword()));
    			    	 				}
    			    	 				else
    			    	 				{
    			    	 					System.out.println("There is no Alumnia Present");
    			    	 				}
    			    	 				break;
    	    	    		           case 2:
    	    	    		    	     System.out.println("****************************Update Alumnia Details*************************");
    	    	    		    	     System.out.println("Enter Alumin_ID which you want to update");
    									 int aid=sc.nextInt();
    									 sc.nextLine();
    									 System.out.println("Enter Alumin Name:");
    			    	    			 Alumin_Name=sc.nextLine();
    			    	    			 System.out.println("Enter Alumin Email_ID:");
    			    	    			 Email=sc.nextLine();
    			    	    			 System.out.println("Enter Phone Number:");
    			    	    			 phone_No=sc.nextInt();
    			    	    			 sc.nextLine();
    			    	    			 System.out.println("Enter Alumin Profession:");
    			    	    			 Profession=sc.nextLine();
    			    	    			 System.out.println("Enter Year of Joining:");
    			    	    			 YearJoin=sc.nextInt();
    			    	    			 System.out.println("Enter Year of Passing:");
    			    	    			 YearPass=sc.nextInt();
    			    	    			 sc.nextLine();
    			    	    			 System.out.println("Enter UserName:");
    			    	    			 uname=sc.nextLine();
    			    	    			 System.out.println("Enter Password:");
    			    	    			 pass=sc.nextLine();
    									 b=alService.updateAlumniaDetails(Alumin_Name, Email, Profession,phone_No, YearJoin, YearPass, uname,pass,aid);
    									 if(b)
    									 {
    										System.out.println("Data Updated Successfully.........");
    									 }
    									 else
    									 {
    										System.out.println("Please Enter Valid  Alumin_ID");
    									 }
    									 break;
    	    	    		            case 3:
    	    	    		            System.out.println("****************Delete Alumnia Details*************************");
    									System.out.println("Enter  Alumin_ID which you want to delete");
    									int adid=sc.nextInt();
    									b=alService.deleteAlumniaById(adid);
    									if(b)
    									 {
    										System.out.println("Alumnia deleted successfully........");
    									 }
    									 else
    									 {
    										System.out.println("Please enter valid Alumnia id.....");
    									 }
    									 break;
    	    	    		            case 4:
    	    	    		            	System.out.println("****************************Show Departmentwise Events*****************");
    	    	    		            	LinkedHashMap<String,ArrayList<String>>EventsNames=alService.getDepartmentWiseEventsNames();
    	    	    						Set<Map.Entry<String, ArrayList<String>>>set=EventsNames.entrySet();
    	    	    						for(Map.Entry<String, ArrayList<String>>m:set)
    	    	    						{
    	    	    							ArrayList<String>Values=m.getValue();
    	    	    							if(Values.size()>0)
    	    	    							{
    	    	    								System.out.println("DepartMent:"+m.getKey());//DepaertmentName
    	    	    								System.out.println("=========================================================");
    	    	    								for(String EventsName:Values)
    	    	    								{
    	    	    									System.out.println("EventsName:"+m.getValue());
    	    	    								}
    	    	    					
    	    	    								System.out.println("=======================================================\n");
    	    	    							}	
    	    	    						}
    	    	    	
    	    	    		            	break;
    		    	    		      case 5:
    		    	    			  System.out.println("****************Registration for Events***************************");
    		    	    			  List<EventsModel> listR=eventService.getAllEvents();
    			    	 				if(listR!=null)
    			    	 				{
    			    	 					System.out.println("Events_ID"+"\t"+"Events_Name"+"\t\t"+"Events_Date"+"\t\t"+"Dept_ID");
    			    	 					listR.forEach((m)->System.out.println(m.getEvent_ID()+"\t\t"+m.getEvent_Name()+"\t\t\t"+m.getDate()+"\t\t"+m.getDept_id()));
    			    	 				}
    			    	 				else
    			    	 				{
    			    	 					System.out.println("There is no Events Present");
    			    	 				}
    		    	    			 
    		    	    			 sc.nextLine();
    		    	    			 System.out.println("Enter Events Name:");
    			    	    		 String EName=sc.nextLine();
    			    	    		 boolean flag =alService.Registration_For_Events(id,EName);
    			    	    		 if(flag)
    			    	    		 {
    			    	    			 System.out.println("Registration SuccessFully..");
    			    	    		 }
    			    	    		 else
    			    	    		 {
    			    	    			 System.out.println("Something Went Wrong");
    			    	    		 }
    		    	    			 break;
    		    	    		 case 6:
    		    	    			 System.out.println("***************************View Schedule************************");
    		    	    			 List<ScheduleModel>list1= scheduleService.getAllSchedule();
    		    	 				if(list1!=null)
    		    	 				{
    		    	 					System.out.println("Schedule_ID"+"\t"+"Schedule_Time"+"\t\t"+"Schedule_Date"+"\t\t"+" Events_ID");
    		    	 					list1.forEach((m)->System.out.println(m.getSchedule_ID()+"\t\t"+m.getSchedule_Time()+"\t\t\t"+m.getDate()+"\t\t"+m.getEvent_ID()));
    		    	 				}
    		    	 				else
    		    	 				{
    		    	 					System.out.println("There is Schedule");
    		    	 				}
    		    	 				break;
    		    	    		 case 7:
    		    	    			 System.out.println("******************************View Message*******************************");
    		    	    			 List<MessageModel>list2= msgService.getAllMessage();
    			    	 				if(list2!=null)
    			    	 				{
    			    	 					System.out.println("Events_ID"+"\t"+"Message");
    			    	 					list2.forEach((m)->System.out.println(m.getEvent_ID()+"\t\t"+m.getMessage()));
    			    	 				}
    			    	 				else
    			    	 				{
    			    	 					System.out.println("There is no Message");
    			    	 				}
    			    	 		  break;
    		    	    		 case 8:
    		    	    			 System.out.println("********************************Give FeedBack******************************************");
    		    	    			 System.out.println("Enter Alumnia_ID:");
    		    	    			 int Alumin_ID=sc.nextInt();
    		    	    			 System.out.println("Enter Events_ID:");
    		    	    			 int Event_ID=sc.nextInt();
    		    	    			 sc.nextLine();
    		    	    			 System.out.println("Give Feedback:");
    		    	    			 String FeedBack=sc.nextLine();
    		    	    			 System.out.println("Enter Rating Upto 5:");
    		    	    			 int Rating=sc.nextInt();
    		    	    			 FeedBackModel feedModel=new FeedBackModel();
    		    	    			 feedModel.setAlumni_ID(Alumin_ID);
    		    	    			 feedModel.setEvnets_ID(Event_ID);
    		    	    			 feedModel.setFeedback(FeedBack);
    		    	    			 feedModel.setRating(Rating);
    		    	    			 b=feedService.isGiveFeedback(Alumin_ID,Event_ID,FeedBack,Rating);
//    		    	    			 if(b)
//    		    	    			 {
//    		    	    				 System.out.println("FeedBack Submit SuccessFully....");
//    		    	    			 }
//    		    	    			 else
//    		    	    			 {
//    		    	    				 System.out.println("Something went Wrong");
//    		    	    			 }
    		    	    			break; 
    		    	    		 case 9:
    		    	    			 System.out.println("************************Display All FeedBack**************************************");
    		    	    			 b=feedService.getAllFeedBack();
    			    	 				if(b)
    			    	 				{
    			    	 					
    			    	 					System.out.println("FeedBack Submited SuccessFully...");		    	 				
    			    	 				}
    			    	 				else
    			    	 				{
    			    	 					System.out.println("There is no FeedBack Availble");
    			    	 				}
    			    	 				break;  
    	    		    			  }
    	    		    			  
    	    		    			 
    	    		    		   }while(true);
    	    		    	   }
    	    		    	   else
    	    		    	   {
    	    		    		   System.out.println("Invalid User");
    	    		    	   }
    	    		    	   
	    	    		 }
    	    		 }while(choice<10);
    	    		 
	    	    }
    	    		 System.out.println("Do You Want To Continue:");
		    	     System.out.println("IF Yes then Press 1:");				     
				    y=sc.nextInt();	 
	    	}while(y==1);
	    	
	    }
	    
	}


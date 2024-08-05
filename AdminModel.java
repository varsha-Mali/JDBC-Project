package org.AlumniaSystem.Model;

public class AdminModel 
{ 
	private int Admin_ID;
	private String Password;
	private String Admin_Name;
	public String getAdmin_Name() {
		return Admin_Name;
	}
	public void setAdmin_Name(String admin_Name) {
		Admin_Name = admin_Name;
	}
	public AdminModel()
	{
		
	}
	public AdminModel(int Admin_ID,String Password)
	{
		this.Admin_ID=Admin_ID;
		this.Password=Password;
	}
	public int getAdmin_ID() 
	{
		return Admin_ID;
	}
	public void setAdmin_ID(int admin_ID) 
	{
		Admin_ID = admin_ID;
	}
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String password)
	{
		Password = password;
	}
	

}

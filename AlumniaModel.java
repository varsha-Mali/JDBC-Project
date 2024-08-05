package org.AlumniaSystem.Model;

public class AlumniaModel  extends DepartmentModel
{
   private int Alumin_ID;
   private String Name;
   private String Email;
   private int Phone_No;
   private String Profession;
   private int Yearjoin;
   private int YearPass;
   public int getYearjoin() {
	return Yearjoin;
}
public void setYearjoin(int yearjoin) {
	Yearjoin = yearjoin;
}
public int getYearPass() {
	return YearPass;
}
public void setYearPass(int yearPass) {
	YearPass = yearPass;
}
private String username;
   private String Password;
   private DepartmentModel dModel;
public int getAlumin_ID() {
	return Alumin_ID;
}
public void setAlumin_ID(int alumin_ID) {
	Alumin_ID = alumin_ID;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public int getPhone_No() {
	return Phone_No;
}
public void setPhone_No(int phone_No) {
	Phone_No = phone_No;
}
public String getProfession() {
	return Profession;
}
public void setProfession(String profession) {
	Profession = profession;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public DepartmentModel getdModel() {
	return dModel;
}
public void setdModel(DepartmentModel dModel) {
	this.dModel = dModel;
}
   
}

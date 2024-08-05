package org.AlumniaSystem.Model;

public class DepartmentModel 
{
	private int Dept_id;
	private String Dept_Name;
	private String Dept_HOD;
	private AdminModel model;
	public int getDept_id() {
		return Dept_id;
	}
	public void setDept_id(int dept_id) {
		Dept_id = dept_id;
	}
	public String getDept_Name() {
		return Dept_Name;
	}
	public void setDept_Name(String dept_Name) {
		Dept_Name = dept_Name;
	}
	public String getDept_HOD() {
		return Dept_HOD;
	}
	public void setDept_HOD(String dept_HOD) {
		Dept_HOD = dept_HOD;
	}
	public AdminModel getModel() {
		return model;
	}
	public void setModel(AdminModel model) {
		this.model = model;
	}

}

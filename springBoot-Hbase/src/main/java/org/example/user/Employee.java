package org.example.user;

import org.springframework.boot.autoconfigure.domain.EntityScan;


public class Employee {

	private String empid;
	private String  empname;
	private String place;
	
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
	
	
}

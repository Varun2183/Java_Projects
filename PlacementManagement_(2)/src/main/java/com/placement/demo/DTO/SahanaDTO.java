package com.placement.demo.DTO;

import com.placement.demo.model.RahulUser;

public class SahanaDTO {

	private int college_id;
	private String collegeAdmin;
	private String collegeName;
	private String location;
	
	private RahulUser user;

	public SahanaDTO(int college_id, String collegeAdmin, String collegeName, String location, RahulUser user) {
		super();
		this.college_id = college_id;
		this.collegeAdmin = collegeAdmin;
		this.collegeName = collegeName;
		this.location = location;
		this.user = user;
	}

	public SahanaDTO() {
		super();
	}

	public int getCollege_id() {
		return college_id;
	}

	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}

	public String getCollegeAdmin() {
		return collegeAdmin;
	}

	public void setCollegeAdmin(String collegeAdmin) {
		this.collegeAdmin = collegeAdmin;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public RahulUser getUser() {
		return user;
	}

	public void setUser(RahulUser user) {
		this.user = user;
	}
	
	
	
}

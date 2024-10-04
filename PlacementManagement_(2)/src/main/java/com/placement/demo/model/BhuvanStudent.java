package com.placement.demo.model;

import jakarta.persistence.Column;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bhuvanstudent")
public class BhuvanStudent {
	
	@Id
	private Integer id;
	private String name;
	private String college;
	private String rollno;
	private String qualification;
	private String course;
	private Integer year;
	private String certificate;
	private Integer hallticketno;
	@Column(name="certificate_Id")
	private Integer certificate_Id;
	private Integer college_id;
	

	public BhuvanStudent() {
		super();
		
	}

	
	public BhuvanStudent(Integer id, String name, String college, String rollno, String qualification, String course, Integer year,
			String certificate,Integer hallticketno, Integer certificate_Id, Integer college_id) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.rollno = rollno;
		this.qualification = qualification;
		this.course = course;
		this.year = year;
		this.certificate=certificate;
		this.hallticketno = hallticketno;
		this.certificate_Id = certificate_Id;
		this.college_id = college_id;

    }

    
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}


	public String getRollno() {
		return rollno;
	}


	public void setRollno(String rollno) {
		this.rollno = rollno;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}
	
	public String getCertificate() {
		return certificate;
	}


	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}


	public Integer getHallticketno() {
		return hallticketno;
	}


	public void setHallticketno(Integer hallticketno) {
		this.hallticketno = hallticketno;
	}


	public Integer getCertificate_Id() {
		return certificate_Id;
	}


	public void setCertificate_Id(Integer certificate_Id) {
		this.certificate_Id = certificate_Id;
	}


	public Integer getCollege_id() {
		return college_id;
	}


	public void setCollege_id(Integer college_id) {
		this.college_id = college_id;
	}
	
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", college=" + college + ", rollno=" + rollno
				+ ", qualification=" + qualification + ", course=" + course + ", year=" + year + ", certificate="
				+ certificate + ", hallticketno=" + hallticketno + "]";
	}
	
}


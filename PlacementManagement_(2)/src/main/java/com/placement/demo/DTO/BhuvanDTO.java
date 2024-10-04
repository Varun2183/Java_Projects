package com.placement.demo.DTO;

import com.placement.demo.model.ChaitraCertificate;
import com.placement.demo.model.SahanaSACollege;

public class BhuvanDTO {
	
	private Integer id;
	private String name;
	private String college;
	private String rollno;
	private String qualification;
	private String course;
	private Integer year;
	private String certificate;
	private Integer hallticketno;
	
	private ChaitraCertificate c_certi;
	
	private SahanaSACollege coll;
	
	public BhuvanDTO() {
		super();
	}

	public BhuvanDTO(Integer id, String name, String college, String rollno, String qualification, String course,
			Integer year, String certificate, Integer hallticketno, ChaitraCertificate c_certi,SahanaSACollege coll) {
		super();
		this.id = id;
		this.name = name;
		this.college = college;
		this.rollno = rollno;
		this.qualification = qualification;
		this.course = course;
		this.year = year;
		this.certificate = certificate;
		this.hallticketno = hallticketno;
		this.c_certi = c_certi;
		this.coll = coll;
	}

	public SahanaSACollege getColl() {
		return coll;
	}

	public void setColl(SahanaSACollege coll) {
		this.coll = coll;
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

	public ChaitraCertificate getC_certi() {
		return c_certi;
	}

	public void setC_certi(ChaitraCertificate c_certi) {
		this.c_certi = c_certi;
	}

}

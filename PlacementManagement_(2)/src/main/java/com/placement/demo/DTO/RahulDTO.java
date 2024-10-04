package com.placement.demo.DTO;

import com.placement.demo.model.VarunAdmin;

public class RahulDTO {

	private int id;
	private String name;
	private String type;
	private String password;
//	private Integer adminId;
//	private String adminName;
	private VarunAdmin admin;
	
	public VarunAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(VarunAdmin admin) {
		this.admin = admin;
	}

//	public String getAdminName() {
//		return adminName;
//	}
//
//	public void setAdminName(String adminName) {
//		this.adminName = adminName;
//	}

	public RahulDTO() {
		super();
	}

//	public RahulDTO(int id, String name, String type, String password, Integer adminId,String adminName) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.type = type;
//		this.password = password;
//		this.adminId = adminId;
//		this.adminName = adminName;
//	}
	public RahulDTO(int id, String name, String type, String password,VarunAdmin admin) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.password = password;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//
//	public Integer getAdminId() {
//		return adminId;
//	}
//
//	public void setAdminId(Integer adminId) {
//		this.adminId = adminId;
//	}
	
}

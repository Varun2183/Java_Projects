package com.placement.demo.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="rahuluser")
public class RahulUser {
	
	@Id
	private int id;
	private String name;
	private String type;
	private String password;
	@Column(name="admin_id")
	private Integer adminId;

	// One-to-one relationship with VarunAdmin
//	@OneToOne
//	@JoinColumn(name = "admin_id")  // Foreign key to reference VarunAdmin
//	@JsonIgnore
//	private VarunAdmin admin;
	
	public RahulUser() {
		super();
	}

	public RahulUser(int id, String name, String type, String password, Integer adminId) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.password = password;
		this.adminId = adminId;
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

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	

	@Override
	public String toString() {
		return "RahulUser [id=" + id + ", name=" + name + ", type=" + type + ", password=" + password + "]";
	}
}

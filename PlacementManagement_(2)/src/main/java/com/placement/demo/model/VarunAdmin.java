package com.placement.demo.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "varunadmin")
public class VarunAdmin {
	
	@Id
	private Integer id;
	private String name;
	private String password;

	// One-to-one relationship with RahulUser
//	@OneToOne(mappedBy = "admin")  // This refers to the 'admin' field in RahulUser
//	@JsonIgnore
//	private RahulUser rahulUser;

	public VarunAdmin() {
		super();
	}

	public VarunAdmin(Integer id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "VarunAdmin [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
}

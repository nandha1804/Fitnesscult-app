package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Details {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String name;
	String doj;
	String package_type;

	public Details() {
	}

	public Details(int id, String name, String doj, String package_type) {
		this.id = id;
		this.name = name;
		this.doj = doj;
		this.package_type = package_type;
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
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getPackage_type() {
		return package_type;
	}
	public void setPackage_type(String package_type) {
		this.package_type = package_type;
	}

	
	
}
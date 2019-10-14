package com.spring.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	 @Id
	 @GeneratedValue (strategy = GenerationType.AUTO)
	// @Column(name = "id")
	 private long id;
	 @Column(name = "name")
     private String name;
	 @Column(name = "email")
     private String email;
	 @Column(name = "phone_no")
     private long phoneNo;
     
     
	public Student() {
		super();
	}


	public Student(String name, String email) {
		super();
		this.name = name;
		this.email = email;
		//this.phoneNo = phoneNo;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
    
     
}

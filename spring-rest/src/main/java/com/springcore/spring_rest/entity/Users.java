package com.springcore.spring_rest.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity

@NamedQueries({
	@NamedQuery(name="Users.findByEmail",query="SELECT e FROM Users e where e.email=:emailID"),
	@NamedQuery(name="Users.findAll",query="SELECT e FROM Users e")
})
public class Users {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	@Column(unique= true)
	private String email;
	private String city;
	
	public Users(){
		this.id= UUID.randomUUID().toString();
	}

	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

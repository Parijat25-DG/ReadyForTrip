package com.example.mongo.api.model;

public class Traveller {
	
	private long id;
	private String name;
	private String mobile;
	private String email;
	private String address;
	private String dateOfBirth;
	private String dateOfTravel;
	private String coTravellerContactName;
	private String coTravellerContactMobile;
	private String coTravellerContactEmail;
	
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDateOfTravel() {
		return dateOfTravel;
	}
	public void setDateOfTravel(String dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	public String getCoTravellerContactName() {
		return coTravellerContactName;
	}
	public void setCoTravellerContactName(String coTravellerContactName) {
		this.coTravellerContactName = coTravellerContactName;
	}
	public String getCoTravellerContactMobile() {
		return coTravellerContactMobile;
	}
	public void setCoTravellerContactMobile(String coTravellerContactMobile) {
		this.coTravellerContactMobile = coTravellerContactMobile;
	}
	public String getCoTravellerContactEmail() {
		return coTravellerContactEmail;
	}
	public void setCoTravellerContactEmail(String coTravellerContactEmail) {
		this.coTravellerContactEmail = coTravellerContactEmail;
	}
	

}

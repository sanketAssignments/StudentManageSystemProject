package com.stud.bean;

public class Address {
	private int rollno;
	private String streetName;
	private String city;
	private String zipCode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int rollno, String streetName, String city, String zipCode) {
		super();
		this.rollno = rollno;
		this.streetName = streetName;
		this.city = city;
		this.zipCode = zipCode;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Address [rollno=" + rollno + ", streetName=" + streetName + ", city=" + city + ", zipCode=" + zipCode
				+ "]";
	}

}

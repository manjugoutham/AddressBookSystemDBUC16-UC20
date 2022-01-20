package com.bridgelabz.addressbookjdbc;

public class AddressData {
	
	String firstName,lastName,address,Department_Type,city,state,email;
	int zip,phoneNumber;
	
	public AddressData()
	{
		
	}
	
	public AddressData(String firstName, String lastName, String address, String department_Type, String city,
			String state, String email, int zip, int phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		Department_Type = department_Type;
		this.city = city;
		this.state = state;
		this.email = email;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment_Type() {
		return Department_Type;
	}
	public void setDepartment_Type(String department_Type) {
		Department_Type = department_Type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "AddressData [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", Department_Type=" + Department_Type + ", city=" + city + ", state=" + state + ", email=" + email
				+ ", zip=" + zip + ", phoneNumber=" + phoneNumber + "]";
	}

}

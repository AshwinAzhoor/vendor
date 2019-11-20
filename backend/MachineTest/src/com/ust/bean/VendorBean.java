package com.ust.bean;

public class VendorBean {

	// instance variables
	private int vendorId;
	private String vendorName;
	private String address;
	private String location;
	private String service;
	private String pinCode;
	private String isActive;
	private String personId;
	private String contactName;
	private String department;
	private String email;
	private String phone;
	private int loginId;
	private String userName;
	private String password;

	/************ Getters and Setters *********************/
	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// default constructor
	public VendorBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	/****************** Parameterized constructors **************/
	public VendorBean(int loginId, String userName, String password) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
	}

	public VendorBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public VendorBean(int vendorId, String vendorName, String address,
			String location, String service, String pinCode, String isActive) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pinCode = pinCode;
		this.isActive = isActive;
	}

	public VendorBean(String vendorName, String address, String location,
			String service, String pinCode, String isActive) {
		super();
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pinCode = pinCode;
		this.isActive = isActive;
	}

	public VendorBean(int vendorId, String personId, String contactName,
			String department, String email, String phone) {
		super();
		this.vendorId = vendorId;
		this.personId = personId;
		this.contactName = contactName;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}

	public VendorBean(int vendorId, String contactName, String department,
			String email, String phone) {
		super();
		this.vendorId = vendorId;
		this.contactName = contactName;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}

	public VendorBean(int vendorId, String vendorName, String address,
			String location, String service, String pinCode, String isActive,
			String personId, String contactName, String department,
			String email, String phone, int loginId, String userName,
			String password) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pinCode = pinCode;
		this.isActive = isActive;
		this.personId = personId;
		this.contactName = contactName;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
	}

	// toString method
	@Override
	public String toString() {
		return "VendorBean [vendorId=" + vendorId + ", vendorName="
				+ vendorName + ", address=" + address + ", location="
				+ location + ", service=" + service + ", pinCode=" + pinCode
				+ ", isActive=" + isActive + ", personId=" + personId
				+ ", contactName=" + contactName + ", department=" + department
				+ ", email=" + email + ", phone=" + phone + ", loginId="
				+ loginId + ", userName=" + userName + ", password=" + password
				+ "]";
	}

}

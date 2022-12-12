package model;

public class Customer {

	private String customerID;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private int discount;
	private int credit;
	private int pincode;
	
	
	public Customer(String customerID, String name, String email, String phoneNumber, String address, int discount,
			int credit, int pincode) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.discount = discount;
		this.credit = credit;
		this.pincode = pincode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}

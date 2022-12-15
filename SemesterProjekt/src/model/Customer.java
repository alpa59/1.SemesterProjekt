package model;
/**
 * the customer class represent the customers that are registered in the system
 *
 * @param customerID  The customer's ID number
 * @param name        The name of the customer.
 * @param email       The customer's email address
 * @param phoneNumber The customer's phone number.
 * @param address     The customer´s address.
 * @param discount    The amount of discount the customer has.
 * @param credit      The amount of credit the customer has.
 * @param pincode     The customer´s pincode
 */
public class Customer {

	private String customerID;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private int discount;
	private double credit;
	private int pincode;

	public Customer(String customerID, String name, String email, String phoneNumber, String address, int discount,
			int pincode) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.discount = discount;
		this.credit = 10000;
		this.pincode = pincode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getCredit() {
		return credit;
	}

	public int getDiscount() {
		return discount;
	}

	public void setCredit(double newCredit) {
		credit = newCredit;
	}

	public void updateCredit(double total) {
		this.credit-=total;

	}

}

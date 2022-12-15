package model;

import java.util.ArrayList;

public class CustomerCont {

	private static CustomerCont instance;
	private ArrayList<Customer> customer;

	public static CustomerCont getInstance() {
		if (instance == null) {
			instance = new CustomerCont();
		}
		return instance;
	}

	public ArrayList<Customer> getCustomer() {
		return customer;
	}
	private CustomerCont() {
		customer = new ArrayList<>();
	}

	public void add(Customer c) {
		customer.add(c);
	}
	
	/**
	 *  finds customer by number from the customer class
	 * @param phone
	 * @return Customer
	 */
	
	public Customer findCustomerByNumber(String phone) {
		Customer res = null;
		for (Customer c : customer) {
			if (c.getPhoneNumber().equals(phone)) {
				res = c;
			}
		}
		return res;
	}

	

}

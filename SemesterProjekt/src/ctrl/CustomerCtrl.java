package ctrl;

import model.Customer;
import model.CustomerCont;

public class CustomerCtrl {
	
	/**
	 * Returns a customer based on their phone number
	 * @param phone
	 * @return Customer c
	 */
	public Customer findCustomerByNumber(String phone) {
		CustomerCont cc = CustomerCont.getInstance();
		Customer c = cc.findCustomerByNumber(phone);
		return c;
	}
	
}

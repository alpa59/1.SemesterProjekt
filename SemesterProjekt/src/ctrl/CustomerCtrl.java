package ctrl;

import model.Customer;
import model.CustomerCont;

public class CustomerCtrl {

	public Customer findCustomerByNumber(String phone) {
		CustomerCont cc = CustomerCont.getInstance();
		Customer c = cc.findCustomerByNumber(phone);
		return c;
	}
	
}

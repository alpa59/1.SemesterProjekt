package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Customer;
import model.CustomerCont;
import model.Order;

class CustomerCtrlTest {

	@Test
	void findCustomerByPhoneTest() {
		//arrange
		CustomerCont cc = CustomerCont.getInstance();
		Customer c = new Customer("123","Bob","bob@","1234","Bobst",20,123);
		cc.add(c);
		//act
		Customer fc = cc.findCustomerByNumber("1234");
		//assert
		assertEquals(c,fc);
	}

}

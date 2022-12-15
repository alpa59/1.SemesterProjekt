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
		Customer c = new Customer("123","Bob","bob@","1","Bobst",20,123);
		Customer c1 = new Customer("123","Bob","bob@","2","Bobst",20,123);
		Customer c2 = new Customer("123","Bob","bob@","3","Bobst",20,123);
		Customer c3 = new Customer("123","Bob","bob@","4","Bobst",20,123);
		Customer c4 = new Customer("123","Bob","bob@","5","Bobst",20,123);
		Customer c5 = new Customer("123","Bob","bob@","6","Bobst",20,123);
		Customer c6 = new Customer("123","Bob","bob@","7","Bobst",20,123);
		Customer c7 = new Customer("123","Bob","bob@","8","Bobst",20,123);
		Customer c8 = new Customer("123","Bob","bob@","9","Bobst",20,123);
		Customer c9 = new Customer("123","Bob","bob@","10","Bobst",20,123);
		Customer c10 = new Customer("123","Bob","bob@","11","Bobst",20,123);
		cc.add(c);
		cc.add(c1);
		cc.add(c2);
		cc.add(c3);
		cc.add(c4);
		cc.add(c5);
		cc.add(c6);
		cc.add(c7);
		cc.add(c8);
		cc.add(c9);
		cc.add(c10);
		//act
		Customer fc = cc.findCustomerByNumber("1");
		Customer fc1 = cc.findCustomerByNumber("2");
		Customer fc2 = cc.findCustomerByNumber("3");
		Customer fc3 = cc.findCustomerByNumber("4");
		Customer fc4 = cc.findCustomerByNumber("5");
		Customer fc5 = cc.findCustomerByNumber("6");
		Customer fc6 = cc.findCustomerByNumber("7");
		
		Customer fc7 = cc.findCustomerByNumber("do not find");
		//assert
		assertEquals(c,fc);
		assertEquals(c1,fc1);
		assertEquals(c2,fc2);
		assertEquals(c3,fc3);
		assertEquals(c4,fc4);
		assertEquals(c5,fc5);
		assertEquals(c6,fc6);
		
		assertEquals(null, fc7);
	}

}

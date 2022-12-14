package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;

class OrderTest {
	private Order order;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void findOrderLineItemAndAddtest() {
		// arrange
		AbstractProduct p = new SimpleProduct("test1", "simp1", "1", 12, 54321, 655, 5454, 454, 45);
		
		order = new Order(null);
		// act
		// assert
		boolean result = order.findOrderLineItemAndAdd(p);
		assertFalse(result);
		
		boolean result1 = order.findOrderLineItemAndAdd(p);
		assertTrue(result1);
		
		

	}
	@Test
	void calculateTotalTest() {
		//arrange
		Order order = new Order(null);
		Customer c = new Customer(null, null, null, "1234", null, 0, 0);
		CustomerCont.getInstance().add(c);
		order.setCustomer(c);
		AbstractProduct p = new SimpleProduct("test1", "simp1", "1", 12, 54321, 655, 5454, 454, 45);
		order.findOrderLineItemAndAdd(p);
		
		//act
		double totalCal = order.calculateTotal();
		//assert
		assertEquals(totalCal, 12);
		
	}
	
//	@Test
//	void calculateDiscountOnCustomer() {
//		Order o1 = new Order(null);
//		Order o2 = new Order(null);
//		Customer c = new Customer(null, null, null, "1234", null, 0, 0);
//		Customer c1 = new Customer(null, null, null, "1234", null, 10, 0);
//		CustomerCont.getInstance().add(c1);
//		CustomerCont.getInstance().add(c);
//		o1.setCustomer(c);
//		o2.setCustomer(c1);
//		
//		//act
//		double cr = o1.calculateDiscountOnCustomer(c);
//		double cr1 = o2.calculateDiscountOnCustomer(c1);
//		
//		assertEquals(1, cr);
//		assertEquals(cr1,0.1);
//	}

	void generateTestData() {
		AbstractProduct p = new SimpleProduct("test1", "simp1", "1", 12, 54321, 655, 5454, 454, 45);
		AbstractProduct p1 = new SimpleProduct("test2", "simp2", "2", 13, 12312, 454, 4545, 045, 4545);
		AbstractProduct p2 = new SimpleProduct("test3", "simp3", "3", 14, 1231231, 4545, 0445, 4540, 4540);
		AbstractProduct p3 = new SimpleProduct("test4", "simp4", "4", 15, 1231231, 54540, 45450, 45450, 45450);
		AbstractProduct p4 = new SimpleProduct("test5", "simp5", "5", 12, 213123, 454330, 54540, 3434, 0555);
		AbstractProduct p5 = new SimpleProduct("test6", "simp6", "6", 123, 2323, 6660, 777, 8880, 9990);

		ProductCont.getInstance().addProduct(p);
		ProductCont.getInstance().addProduct(p1);
		ProductCont.getInstance().addProduct(p2);
		ProductCont.getInstance().addProduct(p3);
		ProductCont.getInstance().addProduct(p4);
		ProductCont.getInstance().addProduct(p5);

		Customer c = new Customer("1", null, null, "1234", null, 20, 0);
		CustomerCont.getInstance().add(c);

	}
}

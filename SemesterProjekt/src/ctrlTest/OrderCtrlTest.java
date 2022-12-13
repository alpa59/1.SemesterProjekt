package ctrlTest;
import ctrl.*;
import model.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderCtrlTest {
	OrderCtrl oc;
	@BeforeEach
	void setUp() throws Exception {
		oc = new OrderCtrl();
	}

	@Test
	void createOrderTest() {
		//arrange
		//act
		Order o = oc.createOrder(null);
		//assert
		assertNotEquals(null, o);
	}
	
	@Test
	void scanProductTest() throws ScannedProductFailedException {
		//arrange
		AbstractProduct p = new SimpleProduct("test", "simp", "123", 0, 0, 0, 0, 0, 0);
		oc.createOrder(null);
		ProductCont.getInstance().addProduct(p);
		//act
		AbstractProduct p2 = oc.scanProduct("123");
		//assert
		assertEquals(p, p2);
	}

	@Test
	void checkCreditAndPayTest() {
		//arrange
		//act
		//assert
	}
	
	void generateTestData() {
		AbstractProduct p = new SimpleProduct("test1", "simp1", "1", 12,54321, 655, 5454, 454, 45);
		AbstractProduct p1 = new SimpleProduct("test2", "simp2", "2", 13, 12312, 454, 4545, 045, 4545);
		AbstractProduct p2= new SimpleProduct("test3", "simp3", "3", 14, 1231231, 4545, 0445, 4540, 4540);
		AbstractProduct p3 = new SimpleProduct("test4", "simp4", "4", 15, 1231231, 54540, 45450, 45450, 45450);
		AbstractProduct p4 = new SimpleProduct("test5", "simp5", "5", 12,213123, 454330, 54540, 3434 , 0555);
		AbstractProduct p5 = new SimpleProduct("test6", "simp6", "6", 123, 2323, 6660,777, 8880, 9990);
		
		ProductCont.getInstance().addProduct(p);
		ProductCont.getInstance().addProduct(p1);
		ProductCont.getInstance().addProduct(p2);
		ProductCont.getInstance().addProduct(p3);
		ProductCont.getInstance().addProduct(p4);
		ProductCont.getInstance().addProduct(p5);
		
	}
}



package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.AbstractProduct;
import model.Customer;
import model.CustomerCont;
import model.ProductCont;
import model.SimpleProduct;

class ProductCtrlTest {

	@Test
	void findProductTest() {
		//arrange
		ProductCont pc = ProductCont.getInstance();
		SimpleProduct sp = new SimpleProduct("Pizza","Lækker","1234",40,60,1,100,150, 0);
		pc.addProduct(sp);
		//act
		AbstractProduct simp = pc.findProduct("1234");
		//assert
		assertEquals(sp,simp);
	}
		
	@Test
	void updateInventoryTest() {
		//arrange
		ProductCont prodCont = ProductCont.getInstance();
		SimpleProduct simpProd = new SimpleProduct("Kage","Usund","2345",20,40,1,50,99,0);
		prodCont.addProduct(simpProd);
		//act
		if (prodCont.findProduct("2345").equals(simpProd)) {
			
		}
		
		//assert
		
	}
}

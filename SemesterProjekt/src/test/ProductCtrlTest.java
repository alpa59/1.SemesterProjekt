package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.AbstractProduct;
import model.Customer;
import model.CustomerCont;
import model.InventoryLocation;
import model.InventoryLocationLine;
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
		SimpleProduct simpProd = new SimpleProduct("Kage","Usund","2345",20,40,1,50,99,1);
		simpProd.createInventoryLocation(5,"Nordpolen");
		ProductCont.getInstance().addProduct(simpProd);
		//act
		ProductCont.getInstance().findProductAndUpdateQuantity(simpProd, -1);
		InventoryLocationLine ill = simpProd.findInventoryLocationline("Nordpolen");
		//assert
		assertEquals(4,ill.getAmount());
	}
	
	@Test
	void updateInventoryTest2() {
		//arrange
		SimpleProduct simpProd = new SimpleProduct("Kage","Usund","2345",20,40,1,50,99,1);
		simpProd.createInventoryLocation(5,"Nordpolen");
		ProductCont.getInstance().addProduct(simpProd);
		//act
		ProductCont.getInstance().findProductAndUpdateQuantity(simpProd, 2);
		InventoryLocationLine ill = simpProd.findInventoryLocationline("Nordpolen");
		//assert
		assertEquals(7,ill.getAmount());
	}
}

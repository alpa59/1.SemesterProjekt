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
		ProductCont prodCont = ProductCont.getInstance();
		SimpleProduct simpProd = new SimpleProduct("Kage","Usund","2345",20,40,1,50,99,1);
		InventoryLocation il = new InventoryLocation("Nordpolen");
		InventoryLocationLine ill = new InventoryLocationLine(1,simpProd,"Nordpolen");
		ill.setInventoryLocation(il);
		prodCont.addProduct(simpProd);
		//act
		prodCont.findProductAndUpdateQuantity(simpProd, 1);
		//assert
		assertEquals(ill.getAmount(),1);
	}
}

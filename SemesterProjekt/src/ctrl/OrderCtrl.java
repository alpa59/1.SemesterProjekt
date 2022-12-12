package ctrl;

import model.AbstractProduct;
import model.Customer;
import model.CustomerCont;
import model.Order;
import model.OrderCont;
import model.Personel;
import model.ProductCont;

public class OrderCtrl {
	
	public Order createOrder(Personel currPersonel) {
		Order o = new Order(currPersonel);
		OrderCont.getInstance().addOrder(o);
		return o;
	}
	
	public AbstractProduct scanProduct(String barcode) {
//		AbstractProduct product = ProductCont.getInstance().findProduct(barcode);
//		if (product !=null) {
//			OrderCont.getInstance()
//			}
		return null;
	}
	
	public Customer findCustomerByNumber(String phone) {
		return CustomerCont.getInstance().findCustomerByNumber(phone);
	}
	
	public void chooseDeliveryAddress(String address) {
		
	}
	
	public double choosePayment(enum payment) {
		
	}
	
}

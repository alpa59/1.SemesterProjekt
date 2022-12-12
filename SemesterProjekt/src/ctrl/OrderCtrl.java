package ctrl;

import model.AbstractProduct;
import model.Customer;
import model.Order;
import model.OrderCont;
import model.Personel;

public class OrderCtrl {
	
	public Order createOrder(Personel currPersonel) {
		Order o = new Order(currPersonel);
		OrderCont.getInstance().addOrder(o);
		return o;
	}
	
	public AbstractProduct scanProduct(String barcode) {
	
	}
	
	public Customer findCustomerByNumber(String phone) {
		
	}
	
	public void chooseDeliveryAddress(String address) {
		
	}
	
	public double choosePayment(enum payment) {
		
	}
	
}

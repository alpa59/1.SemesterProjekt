package ctrl;

import model.*;

public class OrderCtrl {

	private Personel currPersonel;
	private Order currOrder;

	public Order createOrder() {
		Order o = new Order(currPersonel);
		currOrder = o;
		return o;
	}

	public AbstractProduct scanProduct(String barcode) {
		AbstractProduct currProduct = null;
		currProduct = new ProductCtrl().findProduct(barcode);
		checkAlreadyScannedProductAndAdd(currProduct);
		return currProduct;
	}

	private boolean checkAlreadyScannedProductAndAdd(AbstractProduct currProduct) {
		boolean res = currOrder.findOrderLineItem(currProduct);
		return res;
	}

	public Customer findCustomerByNumber(String phone) {
		return CustomerCont.getInstance().findCustomerByNumber(phone);
	}

	public void chooseDeliveryAddress(String address) {
		currOrder.setAddress(address);
	}

	public void choosePayment(Payment payment) {
		currOrder.setPayment(payment);
	}
	
}


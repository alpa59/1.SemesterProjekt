package ctrl;

import model.*;

public class OrderCtrl {

	private Order currOrder;

	public Order createOrder(Personel currPersonel) {
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
		CustomerCtrl cc = new CustomerCtrl();
		return cc.findCustomerByNumber(phone);
	}

	public void chooseDeliveryAddress(String address) {
		currOrder.setAddress(address);
	}

	public void choosePayment(Payment payment) {
		currOrder.setPayment(payment);
	}
	
	public void confirmOrder() {
		updateInventory();
	}
	
	public void updateInventory() {
		ProductCtrl pc = new ProductCtrl();
		for(int i = 0; i < currOrder.getOrderLines().size();i++){
			AbstractProduct res = currOrder.getOrderLines().get(i).getAbstractProduct();
			pc.updateInventory(res, currOrder.getOrderLines().get(i).getAmount());
		}
	}
	
}



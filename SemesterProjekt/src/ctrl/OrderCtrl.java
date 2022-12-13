package ctrl;

import model.*;

public class OrderCtrl {

	private Order currOrder;

	public Order createOrder(Personel currPersonel) {
		Order o = new Order(currPersonel);
		currOrder = o;
		return o;
	}

	public AbstractProduct scanProduct(String barcode) throws ScannedProductFailedException {

		AbstractProduct currProduct = new ProductCtrl().findProduct(barcode);

		if (currProduct == null) {
			throw new ScannedProductFailedException("Could not scan the product", null);
		}
		
		checkAlreadyScannedProductAndAdd(currProduct);
		
		return currProduct;
	}

	private boolean checkAlreadyScannedProductAndAdd(AbstractProduct currProduct) {
		boolean res = currOrder.findOrderLineItemAndAdd(currProduct);
		return res;
	}

	public boolean checkCreditAndPay() {
		boolean res = false;
		double total = currOrder.calculateTotal();
		if (currOrder.getCustomer().getCredit() >= total) {
			currOrder.getCustomer().updateCredit(total);
			res = true;
		} 

		return res;
	}

	public Customer findCustomerByNumber(String phone) {
		CustomerCtrl cc = new CustomerCtrl();
		Customer c =  cc.findCustomerByNumber(phone);
		currOrder.setCustomer(c);
		return c;
	}

	public void chooseDeliveryAddress(String address) {
		currOrder.setAddress(address);
	}

	public void choosePayment(Payment payment) {
		currOrder.setPayment(payment);
	}

	public void confirmOrder() {
		updateInventory(); 
		OrderCont.getInstance().addOrder(currOrder);
	}


	public void updateInventory() {
		ProductCtrl pc = new ProductCtrl();
		for (int i = 0; i < currOrder.getOrderLines().size(); i++) {
			AbstractProduct res = currOrder.getOrderLines().get(i).getAbstractProduct();
			pc.updateInventory(res, currOrder.getOrderLines().get(i).getAmount());
		}
	}

}

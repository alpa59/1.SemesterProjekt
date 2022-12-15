package ctrl;

import model.*;

public class OrderCtrl {

	private Order currOrder;

	/**
	 * Creates a new order
	 * 
	 * @param currPersonel
	 * @return currOrder o
	 */
	public Order createOrder() {
		PersonelCtrl pc = new PersonelCtrl();
		Personel currPersonel = pc.getCurrPersonel();
		Order o = new Order(currPersonel);
		currOrder = o;
		return o;
	}

	/**
	 * Scans a product based on its barcode and adds it to the order
	 * 
	 * @param barcode
	 * @return AbstractProduct
	 * @throws ScannedProductFailedException
	 */
	public AbstractProduct scanProductAndAddToOrder(String barcode) throws ScannedProductFailedException {

		AbstractProduct currProduct = new ProductCtrl().findProduct(barcode);

		if (currProduct == null) {
			throw new ScannedProductFailedException("Could not scan the product", null);
		}

		checkAlreadyScannedProductAndAdd(currProduct);

		return currProduct;
	}

	/**
	 * Checks whether the selected product is already scanned and adds it to the
	 * order if necessary
	 * 
	 * @param currProduct
	 * @return res
	 */
	private boolean checkAlreadyScannedProductAndAdd(AbstractProduct currProduct) {
		boolean res = currOrder.findOrderLineItemAndAdd(currProduct);
		return res;
	}

	/**
	 * Checks whether the customer has enough store credit for the purchase and pays
	 * for the order if so
	 * 
	 * @return res
	 */
	public boolean checkCreditAndPay() {
		boolean res = false;
		double total = currOrder.calculateTotal();
		if (currOrder.getCustomer().getCredit() >= total) {
			currOrder.getCustomer().updateCredit(total);
			res = true;
		}

		return res;
	}

	/**
	 * Finds a customer based on their phone number in the current order
	 * 
	 * @param phone
	 * @return
	 */
	public Customer findCustomerByNumber(String phone) {
		CustomerCtrl cc = new CustomerCtrl();
		Customer c = cc.findCustomerByNumber(phone);
		currOrder.setCustomer(c);
		return c;
	}

	public void chooseDeliveryAddress(String address) {
		currOrder.setDeliveryLocation(address);
	}

	public void choosePayment(Payment payment) {
		currOrder.setPayment(payment);
	}

	public void confirmOrder() {
		updateInventory();
		currOrder.setStatusToActive();
		OrderCont.getInstance().addOrder(currOrder);
	}

	/**
	 * Updates the inventory according to the current order
	 */
	public void updateInventory() {
		ProductCtrl pc = new ProductCtrl();
		for (int i = 0; i < currOrder.getOrderLines().size(); i++) {
			AbstractProduct res = currOrder.getOrderLines().get(i).getAbstractProduct();
			int amount = currOrder.getOrderLines().get(i).getAmount();
			pc.updateInventory(res, amount);
		}
	}

	public String printOrder() {
		String ress = currOrder.printOrder();
		return ress;
	}

}

package model;

import java.time.LocalDate;
import java.util.List;

public class Order {
	private int orderId;
	private double totalPrice;
	private boolean status;
	private String deliveryLocation;
	private LocalDate date;
	private Customer customer;
	private Personel cashier;
	private List<OrderLine> orderLines;
	private Payment payment;

	public Order(Personel currPersonel) {
		this.orderId = 1; // TODO make orderID count
		this.date = LocalDate.now();
		cashier = currPersonel;
	}

	public boolean findOrderLineItem(AbstractProduct abstractProduct) {
		boolean res = false;
		for (int i = 0; i < orderLines.size(); i++) {
			if (orderLines.get(i).getAbstractProduct().equals(abstractProduct)) {
				orderLines.get(i).increaseQtyByOne();
				res = true;
			} else {
				new OrderLine(abstractProduct);

			}
		}
		return res;
	}

	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);

	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setAddress(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public double calculateTotal() {
		double total = 0.0;
		for (int i = 0; i < orderLines.size(); i++) {
			total = +orderLines.get(i).getAbstractProduct().getPrice();
		}
		return total;

	}
	
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
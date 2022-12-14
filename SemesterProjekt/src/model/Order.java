package model;

import java.time.LocalDate;
import java.util.LinkedList;
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
		this.date = LocalDate.now();
		cashier = currPersonel;
		orderLines = new LinkedList<>();
		
	}

	public boolean findOrderLineItemAndAdd(AbstractProduct abstractProduct) {
		boolean res = false;
		for (int i = 0; i < orderLines.size(); i++) {
			if (orderLines.get(i).getAbstractProduct().equals(abstractProduct)) {
				orderLines.get(i).increaseQtyByOne();
				res = true;
			}
		}
		
		if(!res) {
			OrderLine ol = new OrderLine(abstractProduct);
			addOrderLine(ol);
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
		double total = 0;
		for (int i = 0; i < orderLines.size(); i++) {
			total+= orderLines.get(i).getAbstractProduct().getPrice();
		}
		if(customer !=null) {
			double discount = calculateDiscountOnCustomer(customer);
			total*= discount;
		}
		return total;

	}

	private double calculateDiscountOnCustomer(Customer customer) {
		double discount = 0;
		if (customer != null) {
			discount = customer.getDiscount();
			discount = discount / 100;
		} else {
			discount = 1;
		}
		return discount;
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

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String printOrder() {
		StringBuilder ress = new StringBuilder();
		ress.append("Order: ");
		ress.append(orderId);
		for(OrderLine ol : orderLines) {
			ress.append("\nAmount: ");
			ress.append(ol.getAmount());
			ress.append("\t Product: ");
			ress.append(ol.getAbstractProduct().getDescription());
		}
		
		
		return ress.toString();
	}

}
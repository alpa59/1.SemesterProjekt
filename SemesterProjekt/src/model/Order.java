package model;

import java.time.LocalDate;

public class Order {
	private int orderId;
	private double totalPrice;
	private boolean condition;
	private String deliveryLocation;
	private LocalDate date;
	private Customer customer;
	private String address;
	
	public Order(Personel currPersonel) {
		
	}
	
	public OrderLine findOrderLineItem(AbstractProduct abstractProduct) {
		
	}
	
	public boolean addOrderLine(Orderline orderLine) {
		
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double calculateTotal() {
		
	}
	
	public Customer getCustomer() {
		
	}
	
	public void increaseQtyByOne(OrderLine orderLine) {
		
	}
	
	public void setDeliveryLocation(String deliveryLocation) {
			this.deliveryLocation = deliveryLocation;
	}
		
	public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
	}

}
package model;

import java.time.LocalDate;

public class Order {
	private int orderId;
	private double totalPrice;
	private boolean condition;
	private String deliveryLocation;
	private LocalDate date;
	
	public Order() {
	}

	public void setDeliveryLocation(String deliveryLocation) {
			this.deliveryLocation = deliveryLocation;
	}
		
	public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
	}

}
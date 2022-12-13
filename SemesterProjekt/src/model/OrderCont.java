package model;

import java.util.ArrayList;

public class OrderCont {
	
	private static OrderCont instance;
	private ArrayList<Order> orders;
	private int lastOrderId;

	public static OrderCont getInstance() {
		if (instance == null) {
			instance = new OrderCont();
		}
		return instance;
	}

	private OrderCont() {
		orders = new ArrayList<>();
	}

	public void addOrder(Order o) {
		orders.add(o);
		o.setOrderId(lastOrderId + 1);
		lastOrderId++;
	}
}

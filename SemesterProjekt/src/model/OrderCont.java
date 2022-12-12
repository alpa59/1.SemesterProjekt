package model;

import java.util.ArrayList;

public class OrderCont {
	private static OrderCont instance;
	private ArrayList<Order> orders;
	
	public static OrderCont getInstance() {
		if (instance == null) {
			instance = new OrderCont();
		}
		return instance;
	}

	public OrderCont() {
		orders = new ArrayList<>();
	}

	public void addOrder(Order o) {
		orders.add(o);

	}
}

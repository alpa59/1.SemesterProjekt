package model;

import java.util.ArrayList;

/**
 * The `OrderCont` class is a singleton that represents a container for orders.
 *
 * @param instance    The singleton instance of this class.
 * @param orders      The list of orders in this container.
 * @param lastOrderId The ID of the last order added to this container.
 */
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

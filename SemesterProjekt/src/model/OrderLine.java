package model;

/**
 * The `OrderLine` class represents a single line in an order.
 *
 * @param amount          The number of items in this order line.
 * @param abstractProduct The product associated with this order line.
 * @param order           The order that this order line belongs to.
 */
public class OrderLine {
	private int amount = 1;
	private AbstractProduct abstractProduct;
	private Order order;

	public OrderLine(AbstractProduct abstractProduct) {
		this.abstractProduct = abstractProduct;
	}

	public void increaseQtyByOne() {
		this.amount++;
	}

	public int getAmount() {
		return amount;
	}

	public AbstractProduct getAbstractProduct() {
		return abstractProduct;
	}

}

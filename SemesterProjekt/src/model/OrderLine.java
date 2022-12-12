package model;

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

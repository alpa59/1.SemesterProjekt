package model;

public class CompositeLine {

	private int amount;
	private AbstractProduct abstractProduct;
	private Composite composite;

	public CompositeLine(int amount, AbstractProduct abstractProduct, Composite composite) {
		this.amount = amount;
		this.abstractProduct = abstractProduct;
		this.composite = composite;
	}

	public AbstractProduct getAbstractProduct() {
		return abstractProduct;
	}

	public int getAmount() {
		return amount;
	}

}

package model;

public class InventoryLocationLine {

	private int amount;
	private SimpleProduct simpleProduct;
	private InventoryLocation inventoryLocation;

	public InventoryLocationLine(int amount, SimpleProduct simpleProduct) {
		super();
		this.amount = amount;
		this.simpleProduct = simpleProduct;
	}

	public void setSimpleproduct(SimpleProduct simpleProduct) {
		this.simpleProduct = simpleProduct;
	}

}

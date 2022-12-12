package model;

public class InventoryLocationLine {

	private int amount;
	private SimpleProduct simpleProduct;
	private InventoryLocation inventoryLocation;

	public InventoryLocationLine(int amount, SimpleProduct simpleProduct, String location) {
		super();
		this.amount = amount;
		this.simpleProduct = simpleProduct;
		inventoryLocation = new InventoryLocation(location);
	}

	public void setSimpleproduct(SimpleProduct simpleProduct) {
		this.simpleProduct = simpleProduct;
	}

	public boolean updateAmount(int quantity) {
		boolean res = false;
		if (amount >= quantity) {
			amount -= quantity;
			res = true;
		}
		return res;
	}

}

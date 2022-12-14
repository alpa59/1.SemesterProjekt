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

	public SimpleProduct getSimpleProduct() {
		return simpleProduct;
	}

	public void setSimpleProduct(SimpleProduct simpleProduct) {
		this.simpleProduct = simpleProduct;
	}

	public boolean updateAmount(int quantity) {
		boolean res = false;
		if (amount >= quantity) {
			this.amount+= quantity;
			res = true;
		}
		return res;
	}

	public int getAmount() {
		return amount;
	}

	public InventoryLocation getInventoryLocation() {
		return inventoryLocation;
	}

	public void setInventoryLocation(InventoryLocation inventoryLocation) {
		this.inventoryLocation = inventoryLocation;
	}
	
	

}

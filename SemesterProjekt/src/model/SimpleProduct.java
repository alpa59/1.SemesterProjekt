package model;

import java.util.LinkedList;
import java.util.List;

public class SimpleProduct extends AbstractProduct {

	private int minStock;
	private int maxStock;
	private List<InventoryLocationLine> ills;

	public SimpleProduct(String name, String description, String barcode, double price, double purchasePrice,
			double nettoPrice, double weight, int minStock, int maxStock) {
		super(name, description, barcode, price, purchasePrice, nettoPrice, weight);
		this.minStock = minStock;
		this.maxStock = maxStock;
		ills = new LinkedList<>();
	}

	public void createInventoryLocation(int amount, String location) {
		InventoryLocationLine line = new InventoryLocationLine(amount, this, location);
		addIventoryLocationLine(line);
	}

	private void addIventoryLocationLine(InventoryLocationLine ill) {
		ills.add(ill);
		ill.setSimpleproduct(this);
	}

	@Override
	protected boolean updateInventory(int quantity) {
		return false;
	}

}

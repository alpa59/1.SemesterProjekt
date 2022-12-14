package model;

import java.util.LinkedList;
import java.util.List;

public class SimpleProduct extends AbstractProduct {

	private int minStock;
	private int maxStock;
	private double price;
	private List<InventoryLocationLine> ills;

	public SimpleProduct(String name, String description, String barcode, double price, double purchasePrice,
			double nettoPrice, double weight, int minStock, int maxStock) {
		super(name, description, barcode, purchasePrice, nettoPrice, weight);
		this.price = price;
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
		ill.setSimpleProduct(this);
	}

	@Override
	protected boolean updateInventory(int quantity) {
		boolean res = false;
		System.out.println(ills.size() + " is ills");
		for (int i = 0; i < ills.size() && res == false; i++) {
			if (quantity <= ills.get(i).getAmount()) {
				ills.get(i).updateAmount(quantity);
				res = true;
			}
		}

		return res;
	}

	@Override
	public double getPrice() {
		return price;
	}

	public InventoryLocationLine findInventoryLocationline(String location) {
		boolean isFound = false;
		InventoryLocationLine res = null;
		for (int i = 0; i < ills.size() && !isFound; i++) {
			if (ills.get(i).getInventoryLocation().getLocation().equals(location)) {
				res = ills.get(i);
				isFound = true;
			}
		}
		return res;
	}

}

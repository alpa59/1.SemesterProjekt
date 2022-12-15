package model;

import java.util.LinkedList;
import java.util.List;

public class SimpleProduct extends AbstractProduct {

	private int minStock;
	private int maxStock;
	private double price;
	private List<InventoryLocationLine> ills;

	/**
	 * This is the SimpleProduct class
	 * It represents a SimpleProduct with different fields that described itself,
	 * and some of which is extended from the AbstractProduct class. 
	 * The class has methods for creating a InventoryLocation, updating that location and finding it. 
	 * 
	 * @param name
	 * @param description
	 * @param barcode
	 * @param price
	 * @param purchasePrice
	 * @param nettoPrice
	 * @param weight
	 * @param minStock
	 * @param maxStock
	 */
	public SimpleProduct(String name, String description, String barcode, double price, double purchasePrice,
			double nettoPrice, double weight, int minStock, int maxStock) {
		super(name, description, barcode, purchasePrice, nettoPrice, weight);
		this.price = price;
		this.minStock = minStock;
		this.maxStock = maxStock;
		ills = new LinkedList<>();
	}

	/**
	 * It creates a Inventory Location with an set amount. InventoryLocationLine is
	 * associated with the SimpleProduct and the InventoryLocation class created is
	 * associated so.
	 * 
	 * @param amount
	 * @param location
	 */
	public void createInventoryLocation(int amount, String location) {
		InventoryLocationLine line = new InventoryLocationLine(amount, this, location);
		addIventoryLocationLine(line);
	}

	private void addIventoryLocationLine(InventoryLocationLine ill) {
		ills.add(ill);
		ill.setSimpleProduct(this);
	}

	/**
	 * It updates the inventory by reducing or increasing the quantity of items in
	 * the list of InventoryLocationLines.
	 *
	 * @param quantity - The quantity to reduce or increase by.
	 * @return true if the inventory was updated successfully, false otherwise.
	 */
	@Override
	protected boolean updateInventory(int quantity) {
		boolean res = false;
		for (int i = 0; i < ills.size() && res == false; i++) {
			if (quantity <= ills.get(i).getAmount()) {
				ills.get(i).updateAmount(quantity);
				res = true;
			}
		}

		return res;
	}

	/**
	 * It searches for an inventory location line with a specified location.
	 *
	 * @param String location - The location to search for.
	 * @return The inventory location line with the specified location, or null if
	 *         not found.
	 */
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

	@Override
	public double getPrice() {
		return price;
	}

}

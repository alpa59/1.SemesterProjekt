package model;

public class SimpleProduct extends AbstractProduct {

	private int minStock;
	private int maxStock;

	

	public SimpleProduct(String name, String description, String barcode, double price, double purchasePrice,
			double nettoPrice, double weight, int minStock, int maxStock) {
		super(name, description, barcode, price, purchasePrice, nettoPrice, weight);
		this.minStock = minStock;
		this.maxStock = maxStock;
	}



	@Override
	protected boolean updateInventory(int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

}

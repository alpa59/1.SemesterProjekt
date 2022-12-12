package model;

public abstract class AbstractProduct {
	private String name;
	private String description;
	private String barcode;
	private double price;
	private double purchasePrice;
	private double nettoPrice;
	private double weight;

	public AbstractProduct(String name, String description, String barcode, double price, double purchasePrice,
			double nettoPrice, double weight) {
		super();
		this.name = name;
		this.description = description;
		this.barcode = barcode;
		this.price = price;
		this.purchasePrice = purchasePrice;
		this.nettoPrice = nettoPrice;
		this.weight = weight;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	protected abstract boolean updateInventory(int quantity);
}

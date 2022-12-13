package model;

import java.util.List;

public abstract class AbstractProduct {
	private String name;
	private String description;
	private String barcode;
	private double purchasePrice;
	private double nettoPrice;
	private double weight;
	private List<CompositeLine> compositeLines;

	public AbstractProduct(String name, String description, String barcode, double purchasePrice,
			double nettoPrice, double weight) {
		
		this.name = name;
		this.description = description;
		this.barcode = barcode;
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
	
	protected abstract double getPrice();
	
	protected abstract boolean updateInventory(int quantity);
	
}

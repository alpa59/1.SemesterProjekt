package model;

import java.util.List;

public abstract class AbstractProduct {
	private String name;
	private String description;
	private String barcode;
	private double purchasePrice;
	private double nettoPrice;
	private double weight;
	
	/**
	 * Abstractproduct represent the products in the system
	 * 
	 * @param name             The name of the product
	 * @param description      A description of the product
	 * @param barcode          The products barcode
	 * @param purchasePrice    The purchasing price of the product
	 * @param nettoPrice       The lowest price the company is willing to sell for
	 * @param weight           The weight of the product
	 */

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
	
	public String getDescription(){
		return description;
	}
	
	public double getPurchasePrice() {
		return purchasePrice;
	}
	
	public abstract double getPrice();
	
	protected abstract boolean updateInventory(int quantity);
	
}

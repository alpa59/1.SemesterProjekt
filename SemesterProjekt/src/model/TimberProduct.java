package model;

public class TimberProduct extends SimpleProduct{
	
	private String woodType;
	private String dimensions;
	
	
	public TimberProduct(String name, String description, String barcode, double price, double purchasePrice,
			double nettoPrice, double weight, int minStock, int maxStock, String woodType, String dimensions) {
		super(name, description, barcode, price, purchasePrice, nettoPrice, weight, minStock, maxStock);
		this.woodType = woodType;
		this.dimensions = dimensions;
	}
	
	
	
}

package model;

import java.util.LinkedList;
import java.util.List;

public class Composite extends AbstractProduct {

	private List<CompositeLine> compositeLine;
	private String category;

	public Composite(String name, String description, String barcode, double price, double purchasePrice,
			double nettoPrice, double weight, String category) {
		super(name, description, barcode, price, purchasePrice, nettoPrice, weight);
		this.category = category;
		compositeLine = new LinkedList<>();
	}

	public void add(CompositeLine cl) {
		compositeLine.add(cl);
	}

	@Override
	protected boolean updateInventory(int quantity) {
		return false;
	}

}

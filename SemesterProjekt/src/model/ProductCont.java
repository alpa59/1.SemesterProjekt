package model;

import java.util.*;

public class ProductCont {

	private static ProductCont instance;
	private ArrayList<AbstractProduct> products;

	public static ProductCont getInstance() {
		if (instance == null) {
			instance = new ProductCont();
		}
		return instance;
	}

	private ProductCont() {
		products = new ArrayList<>();
	}
	
	public void addProduct(AbstractProduct product) {
		products.add(product);
	}

	public AbstractProduct findProduct(String barcode) {
		AbstractProduct res = null;
		boolean found = false;
		for (int i = 0; i < products.size() && !found; i++) {
			if (products.get(i).getBarcode().equals(barcode)) {
				res = products.get(i);
				found = true;
			}
		}

		return res;
	}

	public void findProductAndUpdateQuantity(AbstractProduct abstractProduct, int quantity) {
		boolean found = false;
		for(int i = 0; i < products.size() && !found; i++) {
			if(products.get(i).equals(abstractProduct)) {
				products.get(i).updateInventory(quantity);
			}
		}
	}

}

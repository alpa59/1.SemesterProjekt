package model;

import java.util.*;

/**
 * This is the ProductCont class. It is a singleton class that manages a list of
 * products. The class has a private constructor and a static method for getting
 * the single instance of the class.
 */
public class ProductCont {

	private static ProductCont instance;
	private ArrayList<AbstractProduct> products;

	/**
	 * This is the getInstance() method. It returns the single instance of the
	 * ProductCont class.
	 *
	 * @return The single instance of the ProductCont class.
	 */
	public static ProductCont getInstance() {
		if (instance == null) {
			instance = new ProductCont();
		}
		return instance;
	}

	/**
	 * This is the private constructor for the ProductCont class. It creates a new
	 * instance of the class and initializes the list of products.
	 */
	private ProductCont() {
		products = new ArrayList<>();
	}

	/**
	 * This is the addProduct() method. It adds a product to the list of products
	 * managed by the ProductCont class.
	 *
	 * @param product The product to add.
	 */
	public void addProduct(AbstractProduct product) {
		products.add(product);
	}

	/**
	 * This is the findProduct() method. It searches for a product with a specified
	 * barcode in the list of products managed by the ProductCont class.
	 *
	 * @param barcode - The barcode to search for.
	 * @return The product with the specified barcode, or null if not found.
	 */
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

	/**
	 * This is the findProductAndUpdateQuantity() method. It searches for a product
	 * in the list of products managed by the ProductCont class and updates its
	 * quantity.
	 *
	 * @param abstractProduct The product to search for and update.
	 * @param quantity        The quantity to update the product with.
	 */
	public void findProductAndUpdateQuantity(AbstractProduct abstractProduct, int quantity) {
		boolean found = false;
		for (int i = 0; i < products.size() && !found; i++) {
			if (products.get(i).equals(abstractProduct)) {
				products.get(i).updateInventory(quantity);
			}
		}
	}

}

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
	
	public AbstractProduct findProduct(int barcode) {
		return null;
	}
	
	public AbstractProduct findProduct(AbstractProduct product, int quantity) {
		return null;
	}

}

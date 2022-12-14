package ctrl;
import model.*;

public class ProductCtrl {
	
	/**
	 * Finds a product in the product container
	 * @param barcode
	 * @return product
	 */
	public AbstractProduct findProduct(String barcode) {
		return ProductCont.getInstance().findProduct(barcode);
	}
	
	/**
	 * Updates the inventory of a specific product in the product container
	 * @param abstractProduct
	 * @param quantity
	 */
	public void updateInventory(AbstractProduct abstractProduct, int quantity) {
		ProductCont.getInstance().findProductAndUpdateQuantity(abstractProduct, quantity);
	}
}

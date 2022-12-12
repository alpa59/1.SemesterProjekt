package ctrl;
import model.*;

public class ProductCtrl {

	public AbstractProduct findProduct(String barcode) {
		return ProductCont.getInstance().findProduct(barcode);
	}
	
	public void updateInventory(AbstractProduct abstractProduct, int quantity) {
		ProductCont.getInstance().findProductAndUpdateQuantity(abstractProduct, quantity);
	}
}

package ctrl;
import model.*;

public class ProductCtrl {

	public AbstractProduct findProduct(int barcode) {
		return ProductCont.getInstance().findProduct(barcode);
	}
	
	public void updateInventory(Order order) {
		
		ProductCont.getInstance().findProduct(product, quantity);
	}
}

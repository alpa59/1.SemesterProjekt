package ctrl;

import model.Order;
import model.OrderCont;
import model.Personel;

public class OrderCtrl {
	
	public Order createOrder(Personel currPersonel) {
		Order o = new Order(currPersonel);
		OrderCont.getInstance().addOrder(o);
		return o;
	}
}

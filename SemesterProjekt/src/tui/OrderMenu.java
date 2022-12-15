package tui;

import ctrl.*;
import model.Payment;
import model.Personel;

public class OrderMenu {
	private OrderCtrl orderCtrl;
	private boolean isFinnishedScanningItems, scannedOneItem,cancelled;

	public OrderMenu() {
		orderCtrl = new OrderCtrl();
		isFinnishedScanningItems = false;
		cancelled = false;
		
		makeNewOrder();

	}

	private void makeNewOrder() {
		
		orderCtrl.createOrder();

		StringRenderer r = new StringRenderer();
		TextChoice<String> tc = new TextChoice<>("Order Menu", r);

		tc.addOptions(promptScanningOptions());

		while (!isFinnishedScanningItems && !cancelled) {

			String input = tc.prompt("Choose option", true);
			if (input != null) {
				checkInput(input.toLowerCase());
			} else {
				cancelled = true;
				System.out.println("Order is cancelled");
			}

		}

		if (!cancelled) {
			checkIsCustomer();
			orderCtrl.confirmOrder();
			System.out.println(orderCtrl.printOrder());
		}
		
	}

	private void checkIsCustomer() {
		TextInput ti = new TextInput();

		boolean isCustomer = ti.promptBoolean("Are you a registered customer");

		if (isCustomer) {
			handleCustomer();
		}

	}

	private void checkInput(String input) {

		switch (input) {
		case "scan next item":
			TextInput ti = new TextInput();
			String scannedItem = ti.promptString("Scan item");
			Object item;
			try {
				item = orderCtrl.scanProductAndAddToOrder(scannedItem);
				scannedOneItem = true;
			} catch (ScannedProductFailedException e) {
				System.out.println("Could not scan item");
			}
			break;
		case "finished scanning":
			if (scannedOneItem) {
				isFinnishedScanningItems = true;
			} else {
				System.out.println("Scan atleast one item");
			}

			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + input);
		}

	}

	private void handleCustomer() {
		boolean goOn = findCustomerByPhone();
		if (goOn) {
			setAddress();
			choosePayment();
		}
		else {
			System.out.println("Could not find customer. Try again");
			handleCustomer();
		}
	}

	private boolean findCustomerByPhone() {

		TextInput ti = new TextInput();
		String phone = ti.promptString("Whats is your phone number");
		Object c = orderCtrl.findCustomerByNumber(phone);
		boolean ress = c != null ? true : false;
		return ress;
	}

	private void setAddress() {
		TextInput ti = new TextInput();
		String address = ti.promptString("Whats is your address");
		orderCtrl.chooseDeliveryAddress(address);

	}

	private void choosePayment() {
		TextInput ti = new TextInput();
		boolean payByCredit = ti.promptBoolean("Pay by credit");
		if (payByCredit) {
			boolean haveCredit = orderCtrl.checkCreditAndPay();
			if (!haveCredit) {
				payInStore();
			} else {

				orderCtrl.choosePayment(Payment.INVOICE);
			}
		} else {
			payInStore();
		}

	}

	private void payInStore() {
		System.out.println("Pay in store");
		orderCtrl.choosePayment(Payment.INSTORE);

	}

	private String[] promptScanningOptions() {
		String[] res = { "Scan next item", "Finished scanning" };
		return res;
	}

}
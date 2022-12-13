package tui;

import ctrl.*;

import model.Personel;

public class OrderMenu {
	private OrderCtrl orderCtrl;
	private boolean isFinnishedScanningItems, scannedOneItem;

	public OrderMenu() {
		orderCtrl = new OrderCtrl();
		isFinnishedScanningItems = false;
		boolean cancelled = false;
		createOrder();

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
				item = orderCtrl.scanProduct(scannedItem);
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

	private void createOrder() {
		Personel currPersonel = new Personel("", "", 0, "", "");
		orderCtrl.createOrder(currPersonel);

	}

	private void handleCustomer() {
		findCustomerByPhone();
		setAddress();
		choosePayment();
	}

	private void findCustomerByPhone() {

		TextInput ti = new TextInput();
		String phone = ti.promptString("Whats is your phone number");
		orderCtrl.findCustomerByNumber(phone);
	}

	private void setAddress() {
		TextInput ti = new TextInput();
		String address = ti.promptString("Whats is your phone number");
		orderCtrl.chooseDeliveryAddress(address);

	}

	private void choosePayment() {
		TextInput ti = new TextInput();
		boolean payByCredit = ti.promptBoolean("Pay by credit? or instore purchase?");
		if (payByCredit) {
			boolean haveCredit = orderCtrl.checkCreditAndPay();
			if (!haveCredit) {
				payInStore();
			}
		} else {
			payInStore();
		}

	}

	private void payInStore() {
		System.out.println("Pay in store");

	}

	private String[] promptScanningOptions() {
		String[] res = { "Scan next item", "Finished scanning" };
		return res;
	}

}
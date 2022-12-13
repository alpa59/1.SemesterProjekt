package tui;

import ctrl.*;

import model.Personel;

public class OrderMenu {
	private OrderCtrl orderCtrl;
	
	public OrderMenu() {
		Personel currPersonel = new Personel("", "", 0, "", "");
		orderCtrl = new OrderCtrl();
		
		orderCtrl.createOrder(currPersonel);
		
		
		
		StringRenderer r = new StringRenderer();
		TextChoice<String> tc = new TextChoice<>("Order Menu", r );
		
		tc.addOptions(promptScanningOptions());
		
		boolean isFinnishedScanningItems = false;
		while(!isFinnishedScanningItems) {
			
			String res = tc.prompt("Currently scanning items", false).toLowerCase();
			
			switch (res) {
				case "scan next item":
					TextInput ti = new TextInput();
					
					String scannedItem = ti.promptString("Scan item");
					
					orderCtrl.scanProduct(scannedItem);
					
					break;
				case "finished scanning":
					
					isFinnishedScanningItems = true;
					
					break;	
			default:
				throw new IllegalArgumentException("Unexpected value: " + res);
			}
			
			
			
			TextInput ti = new TextInput();
			
			boolean isCustomer = ti.promptBoolean("Are you a registered customer");
			
			if(isCustomer) {
				handleCustomer();
			}
			
			orderCtrl.confirmOrder();

		}
		
	}
	
	
	
	
	private void handleCustomer() {
		findCustomerByPhone();
		setAddress();
		choosePayment();
	}

	private void choosePayment() {
		TextInput ti = new TextInput();
		boolean payByCredit = ti.promptBoolean("Pay by credit? or instore purchase?");
		if(payByCredit) {
			boolean haveCredit = orderCtrl.checkCreditAndPay();
			if(!haveCredit) {
				payInStore();
			}
		}else {
			payInStore();
		}
		
	}




	private void payInStore() {
		System.out.println("Not enough Credit, pay in store");
		
	}




	private void setAddress() {
		TextInput ti = new TextInput();
		String address = ti.promptString("Whats is your phone number");
		orderCtrl.chooseDeliveryAddress(address);
		
	}

	private void findCustomerByPhone() {
		
		TextInput ti = new TextInput();
		String phone = ti.promptString("Whats is your phone number");
		orderCtrl.findCustomerByNumber(phone);
	}
		
	
	private String[] promptScanningOptions() {
		String[] res = {"Scan next item", "Finished scanning"};
		return res;
	}
	
	
	
}
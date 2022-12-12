package tui;

import ctrl.*;
import model.Personel;

public class OrderMenu {
	private OrderCtrl orderCtrl;
	
	public OrderMenu(Personel currPersonel) {
		
		orderCtrl = new OrderCtrl();
		orderCtrl.createOrder(currPersonel);
		boolean finnishedScanningItems = false;
		while(!finnishedScanningItems) {
			StringRenderer r = new StringRenderer();
			TextChoice<String> tc = new TextChoice<>("Order Menu", r );
			
			tc.addOptions(promptOptions());
			
			String res = tc.prompt("Currently scanning items", false).toLowerCase();
			
			switch (res) {
				case "scan next item":
					TextInput ti = new TextInput();
					
					String scannedItem = ti.promptString("Scan item");
					
					
					break;
				case "finished scanning":
					
					finnishedScanningItems = true;
					
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + res);
			}
		}
		
	}
	
	
	
	
		
	private String[] promptOptions() {
		String[] res = {"Scan next item", "Finished scanning"};
		return res;
	}
}

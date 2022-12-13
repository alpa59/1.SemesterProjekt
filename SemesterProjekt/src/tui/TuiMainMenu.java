package tui;

import model.AbstractProduct;
import model.Customer;
import model.CustomerCont;
import model.ProductCont;
import model.SimpleProduct;

public class TuiMainMenu {
	public static void main(String[] args) {
		startUp();
		endApplication();
	}

	private static void endApplication() {
		System.out.println("Exiting");
	}

	private static void startUp() {
		System.out.println("Sales manegent system version 0.1");

		boolean goOn = true;
		while (goOn) {
			String res = promptUser().toLowerCase();

			switch (res) {
			case "make order":
				System.out.println();
				OrderMenu om = new OrderMenu();
				break;
			case "generate test data":
				generateTestData();
				break;
			case "exit":
				TextInput ti = new TextInput();
				goOn = !ti.promptBoolean("Are you sure you want to exit? \"yes\" or \"no\"");
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + res);
			}
		}

	}

	private static String promptUser() {
		StringRenderer sr = new StringRenderer();
		TextChoice<String> tc = new TextChoice("Main menu", sr);
		String[] prompts = promptOptions();

		tc.addOptions(prompts);

		String res = tc.prompt("Choose option", false);
		return res;

	}

	private static String[] promptOptions() {
		String[] res = { "Make order","Generate test data", "Exit" };
		return res;
	}
	
	private static void generateTestData() {
		AbstractProduct p = new SimpleProduct("test1", "simp1", "1", 12,54321, 655, 5454, 454, 45);
		AbstractProduct p1 = new SimpleProduct("test2", "simp2", "2", 13, 12312, 454, 4545, 045, 4545);
		AbstractProduct p2= new SimpleProduct("test3", "simp3", "3", 14, 1231231, 4545, 0445, 4540, 4540);
		AbstractProduct p3 = new SimpleProduct("test4", "simp4", "4", 15, 1231231, 54540, 45450, 45450, 45450);
		AbstractProduct p4 = new SimpleProduct("test5", "simp5", "5", 12,213123, 454330, 54540, 3434 , 0555);
		AbstractProduct p5 = new SimpleProduct("test6", "simp6", "6", 123, 2323, 6660,777, 8880, 9990);
		
		ProductCont.getInstance().addProduct(p);
		ProductCont.getInstance().addProduct(p1);
		ProductCont.getInstance().addProduct(p2);
		ProductCont.getInstance().addProduct(p3);
		ProductCont.getInstance().addProduct(p4);
		ProductCont.getInstance().addProduct(p5);
		
		Customer c = new Customer("1", null, null, "1234", null, 20, 0);
		CustomerCont.getInstance().add(c);
		
	}

}

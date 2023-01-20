package gui;

import model.AbstractProduct;
import model.Customer;
import model.CustomerCont;
import model.ProductCont;
import model.SimpleProduct;

public class Main {

	public static void main(String[] args) {
		MainMenu mm = new MainMenu();
		mm.setVisible(true);
		
		
		
		generateTestData();
	}
	
	private static void generateTestData() {
		AbstractProduct p = new SimpleProduct("Product 1", "Hammer", "1", 12,5, 10, 1, 1, 5000);
		AbstractProduct p1 = new SimpleProduct("Product 2", "Søm", "2", 13, 1, 5, 0.1, 1 , 5000);
		AbstractProduct p2= new SimpleProduct("Product 3", "Skrue", "3", 14, 2, 7, 0.2, 4540, 1000000);
		AbstractProduct p3 = new SimpleProduct("Product 4", "Sav", "4", 15, 7, 10, 3, 10, 1000000);
		AbstractProduct p4 = new SimpleProduct("Product 5", "Boremaskine", "5", 600,200, 400, 4, 10 , 100);
		AbstractProduct p5 = new SimpleProduct("Product 6", "Vaterpas", "6", 60, 40, 50,0.5, 10, 1000);
		
		ProductCont.getInstance().addProduct(p);
		ProductCont.getInstance().addProduct(p1);
		ProductCont.getInstance().addProduct(p2);
		ProductCont.getInstance().addProduct(p3);
		ProductCont.getInstance().addProduct(p4);
		ProductCont.getInstance().addProduct(p5);
		
		Customer c = new Customer("1", "Mathias Rasmussen", "@gmail.com", "88888888", "addresse 123", 20, 5041);
		CustomerCont.getInstance().add(c);
		
	}
}

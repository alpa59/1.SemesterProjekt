package model;

public class OrderLine {
	private int amount;
	
	
	public void increaseQtyByOne() {
		this.amount++;
	}
	
	public int getAmount() {
		return amount;
	}
	
}

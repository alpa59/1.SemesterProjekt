package model;

import java.util.LinkedList;
import java.util.List;

public class InventoryLocation {

	private String location;
	private List<InventoryLocationLine> inventoryLocationLine;

	public InventoryLocation(String location) {
		super();
		this.location = location;
		inventoryLocationLine = new LinkedList<>();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}

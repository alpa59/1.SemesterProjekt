package model;

public class Personel {
	private String name;
	private String phoneNumber;
	private int personelID;
	private String email;
	private String title;

	public Personel(String name, String phoneNumber, int personelID, String email, String title) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.personelID = personelID;
		this.email = email;
		this.title = title;
	}
	
	public String getName() {
		return name;		
	}

	

}

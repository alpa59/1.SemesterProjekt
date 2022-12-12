package model;

public class Personel {
	private String name;
	private String phoneNumber;
	private String personelID;
	private String email;
	private String title;
	
	public Personel(String name, String phoneNumber, String personelID, String email, String title) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.setPersonelID(personelID);
		this.email = email;
		this.title = title;
	}

	public String getPersonelID() {
		return personelID;
	}

	public void setPersonelID(String personelID) {
		this.personelID = personelID;
	}
	
	
}

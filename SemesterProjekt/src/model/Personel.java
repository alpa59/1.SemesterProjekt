package model;

/**
 * The `Personel` class represents a person who is a member of Vestbjerg
 * Byggecenter's personnel.
 * 
 * @param name        The name of the person.
 * @param phoneNumber The person's phone number.
 * @param personelID  The person's ID number.
 * @param email       The person's email address.
 * @param title       The person's job title.
 */
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

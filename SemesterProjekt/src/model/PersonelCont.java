package model;

import java.util.ArrayList;

/**
 * This is the PersonelCont class. It is a singleton class that manages a list
 * of personels. The class has a private constructor and a static method for
 * getting the single instance of the class.
 */
public class PersonelCont {

	private static PersonelCont instance;
	private ArrayList<Personel> personels;

	public static PersonelCont getInstance() {
		if (instance == null) {
			instance = new PersonelCont();
		}
		return instance;
	}

	private PersonelCont() {
		personels = new ArrayList<>();
	}

	/**
	 * This is the addPersonel() method. It adds a personel to the list of personels
	 * managed by the PersonelCont class.
	 *
	 * @param personel The personel to add.
	 */
	public void addPersonel(Personel personel) {
		personels.add(personel);
	}

}

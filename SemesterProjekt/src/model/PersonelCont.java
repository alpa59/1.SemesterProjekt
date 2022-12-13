package model;

import java.util.ArrayList;

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

	public void addPersonel(Personel personel) {
		personels.add(personel);
	}
	
}

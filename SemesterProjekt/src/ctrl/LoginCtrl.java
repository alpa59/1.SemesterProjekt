package ctrl;

import model.Personel;

public class LoginCtrl {
	private static LoginCtrl instance;
	private static Personel currLoginPersonel;
	
	private LoginCtrl(){
		currLoginPersonel = new Personel("Test Personel", "12345678", 1, "test@gmail.com", "Test");
	}
	
	public static LoginCtrl getInstance() {
		if(instance == null) {
			instance = new LoginCtrl(); 
		}
		
		return instance;
	}

	public static Personel getCurrLoginPersonel() {
		return currLoginPersonel;
	}

	
	
	
	
}

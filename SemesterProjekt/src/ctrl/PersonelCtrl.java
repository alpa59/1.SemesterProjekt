package ctrl;

import model.Personel;

public class PersonelCtrl {

	public Personel getCurrPersonel() {
		Personel currPersonel = LoginCtrl.getInstance().getCurrLoginPersonel();
		return currPersonel;
	}

}

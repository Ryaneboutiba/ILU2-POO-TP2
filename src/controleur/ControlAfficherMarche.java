package controleur;

import villagegaulois.Village;

public class ControlAfficherMarche {
	private Village village;

	public ControlAfficherMarche(Village village) {
		this.village = village;
	}

	//TODO a completer
	public String[] donnerInfosMarche() {
		String[] infosMarche=village.donnerEtatMarche();
		System.out.println(infosMarche.length);
		return infosMarche;
	}
}

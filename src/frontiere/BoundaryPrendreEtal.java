package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO a completer
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis desole "+nomVendeur+" mais il faut etre un habitant de notre village pour commercer ici");
		}else {
			System.out.println("Bonjour "+nomVendeur+" je vais regarder si je peux vous trouver un etal.");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Desole "+nomVendeur+" je n'ai plus d'etal qui ne sois pas deja occupe");
			}else {
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait il me rest un etal pour vous");
				System.out.println("Il me faudrait quelque renseignement");
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}

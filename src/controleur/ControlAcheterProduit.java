package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
	public Gaulois[] vendeursProduit(String produit) {
		Gaulois[] tousVendeur=village.rechercherVendeursProduit(produit);
		return tousVendeur;
	}
	
	public int acheterProduit(String nomVendeur,int quantiteVoulue) {
		if(!controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis desole "+nomVendeur+" il faut etre un habitant du village pour commercer ici");
		}
		Gaulois vendeur=village.trouverHabitant(nomVendeur);
		Etal etal=village.rechercherEtal(vendeur);
		return etal.acheterProduit(quantiteVoulue);
	}
	
	/*public void acheterProduit(String nomAcheteur,Gaulois vendeur,int quantiteVoulue) {
		Etal etal=village.rechercherEtal(vendeur);
		int quantiteAcheter=etal.acheterProduit(quantiteVoulue);
		if(quantiteAcheter==0) {
			System.out.println(nomAcheteur+" veut acheter "+quantiteVoulue+" malheureusement il y en a plus");
		}else if(quantiteAcheter==etal.getQuantite()) {
			System.out.println(nomAcheteur+" veut acheter "+quantiteVoulue+" ,malheureusement "+vendeur.getNom()+" n'en vend plus que "+quantiteAcheter+" "+nomAcheteur+" achete tout le stock de "+vendeur.getNom()+".");
		}else {
			System.out.println(nomAcheteur+" achete "+quantiteAcheter+" a "+vendeur.getNom());
		}
	}*/
}

package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO Ã  completer
		System.out.println("Quel produit souhaitez acheter?\n");
		String produit=scan.nextLine();
		System.out.println("Chez quel commerçant voulez-vous acheter des "+produit+"?\n");
		Gaulois[] vendeur=controlAcheterProduit.vendeursProduit(produit);
		if(vendeur==null) {
			System.out.println("Desole nous ne vendons pas ce produit dans le marche");
		}else {
			for(int i=0;i<vendeur.length;i++) {
				System.out.println((i+1)+"- "+vendeur[i].getNom()+"\n");
			}
			int numVendeur=Clavier.entrerEntier("");
			System.out.println("Panoramix se deplace jusqu'a l'etal du vendeur "+vendeur[numVendeur-1].getNom());
			int quantiteVoulue=Clavier.entrerEntier("Combien de fleurs voulez-vous acheter?\n");
			/*controlAcheterProduit.acheterProduit(nomAcheteur,vendeur[numVendeur-1],quantiteProduitVoulue);*/
			int quantiteAcheter=controlAcheterProduit.acheterProduit(vendeur[numVendeur-1].getNom(), quantiteVoulue);
			System.out.println("Au revoir client "+nomAcheteur);
		}
	}
}

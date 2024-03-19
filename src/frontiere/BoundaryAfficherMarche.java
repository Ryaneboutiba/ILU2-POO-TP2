package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infoMarche=controlAfficherMarche.donnerInfosMarche();
		if(infoMarche.length==0) {
			System.out.println("Le marche est vide , revenez plus tard");
		}else {
			System.out.println(nomAcheteur+" vous trouverez au marche : \n");
			int i=0;
			do{
				String vendeur=infoMarche[i];
				i++;
				String quantite=infoMarche[i];
				i++;
				String produit=infoMarche[i];
				System.out.println("-"+vendeur+" qui vend "+quantite+" "+produit+"\n");
			}while(infoMarche.length-1>i);
		}

	}
}

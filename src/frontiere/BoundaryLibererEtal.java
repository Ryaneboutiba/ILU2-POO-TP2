package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		//TODO a completer
		Boolean venderuReconnu=controlLibererEtal.isVendeur(nomVendeur);
		if(!venderuReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marche aujourd'hui");
		}else {
			String[] donnesEtal=controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe=donnesEtal[0];
			if(etalOccupe=="true") {
				String produit=donnesEtal[2];
				String quantiteInitial=donnesEtal[3];
				String quantiteVendu=donnesEtal[4];
				System.out.println("Vous avez vendu "+quantiteVendu+" sur"+quantiteInitial+" "+produit);
				System.out.println("Au revoir "+nomVendeur+",passez une bonne journee");
			}
			
		}
	}

}

package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
	}
	
	@Test
	public void testEtalVide() {
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur("asterix");
		assertEquals(etal, null);
	}
	
	@Test
	public void testTrouverEtal() {
		Gaulois asterix=new Gaulois("asterix",3);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix,"fleurs", 10);
		Etal etal1=village.rechercherEtal(asterix);
		Etal etal2=controlTrouverEtalVendeur.trouverEtalVendeur("asterix");
		assertEquals(etal2, etal1);
	}

}

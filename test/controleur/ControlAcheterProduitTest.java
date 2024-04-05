package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAcheterProduit controlAcheterProduit;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 10);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		controlVerifierIdentite= new ControlVerifierIdentite(village);
		controlAcheterProduit=new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}
	
	
	@Test
	public void testVendeursProduitValide() {
		Gaulois asterix=new Gaulois("asterix",5);
		Gaulois obelix=new Gaulois("obelix",55);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(asterix);
		village.installerVendeur(obelix, "fleurs", 5);
		village.installerVendeur(asterix, "fleurs", 10);
		Gaulois[] vendeurFleurs= {obelix,asterix};
		Gaulois[] res=controlAcheterProduit.vendeursProduit("fleurs");
		assertNotNull(res);
		assertEquals(res.length, 2);
		assertArrayEquals(res, vendeurFleurs);
	}
	
	
	@Test
	public void testVendeursProduitNonValide() {
		assertEquals(controlTrouverEtalVendeur.trouverEtalVendeur("fleurs"), null);
	}
	
	
	@Test
	public void testAcheterProduit() {
		Gaulois asterix=new Gaulois("asterix",5);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 10);
		int q1=controlAcheterProduit.acheterProduit("asterix", 2);
		assertEquals(q1, 2);
		int q2=controlAcheterProduit.acheterProduit("asterix", 15);
		assertEquals(q2, 8);
		int q3=controlAcheterProduit.acheterProduit("asterix", 15);
		assertEquals(q3, 0);
	}
	
	


}

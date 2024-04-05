package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherMarche controlAfficherMarche;
	

	
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 10);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherMarche=new ControlAfficherMarche(village);
	}
	
	
	@Test
	public void testAfficherMarcheValide() {
		Gaulois asterix=new Gaulois("asterix",5);
		Gaulois obelix=new Gaulois("obelix",55);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(asterix);
		village.installerVendeur(obelix, "chocolat", 5);
		village.installerVendeur(asterix, "fleurs", 10);
		String[] test= {"obelix","5","chocolat","asterix","10","fleurs"};
		String[] value=controlAfficherMarche.donnerInfosMarche();
		assertNotNull(value);
		assertEquals(value.length, 6);
		for(int i=0;i<value.length;i++) {
			assertEquals(value[i], test[i]);
		}
	}
	
	@Test
	public void testAfficherMarcheNonValide() {
		String[] test=controlAfficherMarche.donnerInfosMarche();
		assertEquals(test.length, 0);
	}
	
	
	
	
	
	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/

}

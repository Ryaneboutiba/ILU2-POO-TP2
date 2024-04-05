package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlLibererEtal controlLibererEtal;
	
	
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
	}
	
	
	@Test
	public void testIsVendeurValid() {
		Gaulois asterix=new Gaulois("asterix",8);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 10);
		assertTrue(controlLibererEtal.isVendeur("asterix"));
	}
	
	@Test
	public void testIsVendeurNonValide() {
		assertFalse(controlLibererEtal.isVendeur("obelix"));
		Gaulois obelix=new Gaulois("obelix",99);
		village.ajouterHabitant(obelix);
		village.installerVendeur(obelix, "chocolat", 5);
		assertTrue(controlLibererEtal.isVendeur("obelix"));
	}
	
	
	@Test
	public void testLibererEtalValide() {
		Gaulois asterix=new Gaulois("asterix",8);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "fleurs", 10);
		String[] test=controlLibererEtal.libererEtal("asterix");
		assertNotNull(test);
		assertEquals(test.length, 5);
		assertEquals(test[0], "true");
		assertEquals(test[1], "asterix");
		assertEquals(test[2], "fleurs");
		assertEquals(test[3], "10");
		assertEquals(test[4], "0");
	}
	
	@Test
	public void testLibererEtalNonValide() {
		String[] test=controlLibererEtal.libererEtal("asterix");
		assertEquals(test, null);
	}
	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/

}

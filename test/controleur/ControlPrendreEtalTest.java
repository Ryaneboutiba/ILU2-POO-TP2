package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifieIdentite;
	private ControlPrendreEtal controlPrendreEtal;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifieIdentite=new ControlVerifierIdentite(village);
		controlPrendreEtal=new ControlPrendreEtal(controlVerifieIdentite ,village);
	}
	
	
	@Test
	public void testPrendreEtalBas() {
		Gaulois asterix=new Gaulois("asterix",8);
		village.ajouterHabitant(asterix);
		int valeur=controlPrendreEtal.prendreEtal("asterix", "fleurs", 20);
		assertEquals(valeur, 1);
		Gaulois obelix=new Gaulois("obelix", 15);
		village.ajouterHabitant(obelix);
		valeur=controlPrendreEtal.prendreEtal("obelix","chocolat",25);
		assertEquals(valeur, -1);
	}
	
	@Test
	public void verifierIdentite() {
		Gaulois asterix=new Gaulois("asterix",8);
		assertFalse(controlPrendreEtal.verifierIdentite("asterix"));
		village.ajouterHabitant(asterix);
		assertTrue(controlPrendreEtal.verifierIdentite("asterix"));
	}
	
	@Test
	public void testResteEtal() {
		Gaulois asterix=new Gaulois("asterix",8);
		assertTrue(controlPrendreEtal.resteEtals());
		village.ajouterHabitant(asterix);
		int valeur=controlPrendreEtal.prendreEtal("asterix", "fleurs", 20);
		assertEquals(valeur, 1);
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	
	
	/*
	@Test
	void test() {
		fail("Not yet implemented");
	}*/

}

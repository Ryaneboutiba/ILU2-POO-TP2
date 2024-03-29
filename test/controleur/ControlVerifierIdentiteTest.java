package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;
import controleur.ControlEmmenager;
import villagegaulois.*;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	private ControlEmmenager controlEmmenager;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	public void testIsHabitantGaulois() {
		Gaulois asterix=new Gaulois("asterix",8);
		village.ajouterHabitant(asterix);
		ControlVerifierIdentite controleVerifieIdentite=new ControlVerifierIdentite(village);
		assertTrue(controleVerifieIdentite.verifierIdentite("asterix"));
		assertFalse(controleVerifieIdentite.verifierIdentite("obelix"));
		Gaulois obex=new Gaulois("obex",88);
		village.ajouterHabitant(obex);
		assertTrue(controleVerifieIdentite.verifierIdentite("obex"));
	}
	
	@Test
	public void testIsHabitantDruide() {
		Druide baroucix=new Druide("baroucix",1,5,17);
		village.ajouterHabitant(baroucix);
		ControlVerifierIdentite controleVerifieIdentite=new ControlVerifierIdentite(village);
		assertTrue(controleVerifieIdentite.verifierIdentite("baroucix"));
		assertFalse(controleVerifieIdentite.verifierIdentite("Existe pas"));
		
	}

	//@Test
	/*void test() {
		fail("Not yet implemented");
	}*/

}

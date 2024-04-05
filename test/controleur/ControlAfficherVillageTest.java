package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage=new ControlAfficherVillage(village);
	}
	
	
	@Test
	public void testNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(), "le village des irréductibles");
	}
	
	@Test
	public void testAfficherHabitant() {
		Gaulois asterix=new Gaulois("asterix",3);
		Gaulois obelix=new Gaulois("obelix",3);
		Gaulois rr=new Gaulois("rr",3);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		village.ajouterHabitant(rr);
		String[] test= {"Abraracourcix","asterix","obelix","rr"};
		String[] obtenue=controlAfficherVillage.donnerNomsVillageois();
		assertNotNull(obtenue);
		assertEquals(obtenue.length, 4);
		assertArrayEquals(obtenue, test);
	}
	
	
	@Test
	public void testDonnerNbEtal() {
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);
	}
	

}

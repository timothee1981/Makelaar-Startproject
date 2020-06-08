package nl.hva.miw.ooad;

import static org.junit.Assert.*;

import org.junit.Test;

public class FundaTest {

	@Test
	public void testKoopHuis() {
		
		Funda f = new Funda();
		int m_id = f.registreerMakelaar("Makelaar1", "Adres M1");
		int k_id = f.registreerKoper("Koper1", "Adres K1");
		
		int h_id = f.registreerHuis(m_id, "Huis1", 100, 300000);
		int h2_id = f.registreerHuis(m_id, "Huis2", 100, 400000);


		
		f.koopHuis(k_id, h_id);
		f.koopHuis(k_id, h2_id);


		
		assertEquals( 700000, f.totaleOmzet(m_id), 0.1 );


	}

	@Test
	public void registreerHuis() {
		Funda f = new Funda();
		int m_id = f.registreerMakelaar("Makelaar1", "Adres M1");
		int h_id1 = f.registreerHuis(m_id, "Huis1", 100, 300000);
		int h_id2_actual = f.registreerHuis(m_id,"Huis2", 100, 50000);

		int expectedInt = 1001;
		assertEquals(expectedInt,h_id2_actual);

		Makelaar henry = new Makelaar("henry","this");
		int h_id3 = f.registreerHuis(henry.getId(), "Huis1", 100, 300000);
		int expected = -1;
		assertEquals(expected,h_id3);

	}
}

package nl.hva.miw.ooad;

import java.util.HashMap;
import java.util.Map;

public class Funda {
	
	Map<Integer, Makelaar> makelaars = new HashMap<>(); 	// geregistreerde makelaars
	Map<Integer, Koper> kopers = new HashMap<>(); 			// geregistreerde kopers
	Map<Integer, Huis> huizen = new HashMap<>(); 			// geregistreerde huizen

	public Funda() {
	}

	
	/**
	 * Registreer een makelaar, retourneert een id
	 * @return
	 */
	public int registreerMakelaar( String naam, String adres ) {
		Makelaar m = new Makelaar(naam, adres);
		int m_id = m.getId();
		makelaars.put( m_id, m );
		return m_id;
	}

	/**
	 * Registreer een koper, retourneert een id
	 * @return
	 */
	public int registreerKoper( String naam, String adres ) {
		Koper k = new Koper(naam, adres);
		int k_id = k.getId();
		kopers.put( k_id, k );
		return k_id;
	}
	
	
	/**
	 * Registreer een huis, retourneert een id
	 * @param m_id - makelaar die huis aanbiedt
	 * @param adres
	 * @param oppervlakte
	 * @param prijs
	 * @return
	 */
	public int registreerHuis( int m_id, String adres, int oppervlakte, double prijs ) {
		// OPDRACHT 2: Implementeer deze methode op basis van gegeven sequence diagram

		int h_id;
		if(isGeregistreerdMakelaar(m_id)) {
			Makelaar m = makelaars.get(m_id);
			Huis huis = new Huis(adres, oppervlakte, prijs, m);
			h_id = huis.getId();
			huizen.put(h_id, huis);
			return h_id;
		}else {
			return  -1;
		}

	}
	

	/**
	 * Koper koopt een huis. Registreert huis als verkocht en voegt huis toe aan de makelaars lijst van verkochte huizen.
	 * 
	 * Controleert of huis en koper wel geregistreerd staan.
	 * 
	 * @param k_id - koper_id
	 * @param h_id - huis_id
	 */
	public void koopHuis( int k_id, int h_id ) {
		// OPDRACHT 3: Implementeer deze methode op basis van gegeven use-case beschrijving
		Huis huis = huizen.get(h_id);
		Makelaar makelaar = huizen.get(h_id).getMakelaar();
		//checken als koper en huis geregistreerd zijn

		if(isGeregistreerdKoper(k_id)&& isGeregistreerdHuis(h_id)) {
			//geef aan makelaar van huis door dat huis verkocht is
			makelaar.huisVerkocht(huis);
		}


	}


	/**
	 * Retourneert totale omzet van een makelaar.
	 * Als makelaar niet bestaat wordt -1 geretourneerd.
	 * 
	 * @param m_id
	 * @return
	 */
	public double totaleOmzet( int m_id ) {
		if (isGeregistreerdMakelaar( m_id )) {
			return makelaars.get( m_id ).totaleOmzet();
		} else {
			return -1;
		}
	}
	
	/**
	 * Retourneert of koper geregistreerd is.
	 * 
	 * @param k_id
	 * @return
	 */
	private boolean isGeregistreerdKoper( int k_id ) {
		return kopers.containsKey( k_id );
	}

	/**
	 * Retourneert of makelaar geregistreerd is.
	 * 
	 * @param m_id
	 * @return
	 */
	private boolean isGeregistreerdMakelaar( int m_id ) {
		return makelaars.containsKey( m_id );
	}

	/**
	 * Retourneert of huis geregistreerd is.
	 * 
	 * @param h_id
	 * @return
	 */
	private boolean isGeregistreerdHuis( int h_id ) {
		return huizen.containsKey( h_id );
	}
}

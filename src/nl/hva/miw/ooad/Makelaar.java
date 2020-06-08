package nl.hva.miw.ooad;

import java.util.ArrayList;
import java.util.List;

/**
 * Makelaar klasse
 * 
 * @author michel
 *
 */
public class Makelaar extends Person {
	
	private static int next_id = 1;		// Gebruikt om opeenvolgende id's te genereren.
	
	private int id;
	protected List<Huis> verkochteHuizen = new ArrayList<>(); // Welke huizen zijn verkocht door deze makelaar?

	public Makelaar(String naam, String adres) {
		super(naam, adres);
		
		this.id = next_id++;
	}
	
	public int getId() {
		return id;
	}
	
	/**
	 * Huis is verkocht door deze makelaar.
	 * 
	 * @param huis
	 */
	void huisVerkocht( Huis huis ) {
		verkochteHuizen.add( huis );
		
		huis.setVerkocht( true );
	}

	protected int aantalVerkochteHuizen()  {
		return verkochteHuizen.size();
	}
	
	/**
	 * Retourneert de totale prijs van verkochte huizen door deze makelaar
	 * @return
	 */
	double totaleOmzet() {
		double sum = 0;

		for ( Huis h : verkochteHuizen ) {
			sum += h.getPrijs();
		}
		
		return sum;
	}
	
	public double gemiddeldeHuisPrijs() {
		return totaleOmzet() / aantalVerkochteHuizen();
	}
	
	@Override
	public String toString() {
		return "Makelaar [id=" + id + "," + super.toString() + ", aantal verkochte huizen=" + aantalVerkochteHuizen() + "]";
	}
}

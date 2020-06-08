package nl.hva.miw.ooad;

/**
 * Koper klasse
 * 
 * @author michel
 *
 */
public class Koper extends Person {
	
	private static int next_id = 1;		// Gebruikt om opeenvolgende id's te genereren.
	
	private int id;

	public Koper(String naam, String adres) {
		super(naam, adres);
		
		this.id = next_id++;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Koper [id=" + id + "," + super.toString() + "]";
	}

}

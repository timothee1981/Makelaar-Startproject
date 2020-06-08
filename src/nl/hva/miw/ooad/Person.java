package nl.hva.miw.ooad;

/**
 * Person class
 * 
 * @author michel
 *
 */
public abstract class Person {
	private String Naam;
	private String Adres;

	public Person(String naam, String adres) {
		super();
		Naam = naam;
		Adres = adres;
	}
	
	public String getNaam() {
		return Naam;
	}

	public String getAdres() {
		return Adres;
	}

	@Override
	public String toString() {
		return "Person [Naam=" + Naam + ", Adres=" + Adres + "]";
	}
}

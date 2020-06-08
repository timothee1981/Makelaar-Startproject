package nl.hva.miw.ooad;

public class Huis {
	
	private static int next_id = 1000;		// Gebruikt om opeenvolgende id's te genereren.
	
	private int id;
	private String adres;
	private int oppervlakte;
	private double prijs;
	private Makelaar makelaar;
	
	private boolean verkocht;

	Huis(String adres, int oppervlakte, double prijs, Makelaar makelaar) {
		super();
		this.adres = adres;
		this.oppervlakte = oppervlakte;
		this.prijs = prijs;
		this.makelaar = makelaar;
		this.verkocht = false;
		
		this.id = next_id++;
	}

	int getId() {
		return id;
	}

	String getAdres() {
		return adres;
	}

	int getOppervlakte() {
		return oppervlakte;
	}

	double getPrijs() {
		return prijs;
	}

	Makelaar getMakelaar() {
		return makelaar;
	}

	public boolean isVerkocht() {
		return verkocht;
	}

	void setVerkocht(boolean verkocht) {
		this.verkocht = verkocht;
	}
	
	@Override
	public String toString() {
		return "Huis [id=" + id + ", adres=" + adres + ", oppervlakte=" + oppervlakte + ", prijs=" + prijs + "]";
	}
}

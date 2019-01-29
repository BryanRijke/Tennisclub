package domain.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name = "Bestuurslid")
public class Bestuurslid {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Bestuurslidnummer", updatable = false, nullable = false)
	private int bestuurslidNr;
	
	@Column (name = "Begin_datum")
	@Temporal (TemporalType.DATE)
	private Calendar beginDatum;
	
	@Column (name = "Eind_datum")
	@Temporal (TemporalType.DATE)
	private Calendar eindDatum;
	
	@Column (name = "Functie")
	private String functie;
	
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn (name = "Spelersnummer", foreignKey = @ForeignKey (name = "Speler_Spelersnummer1"))
	private Speler spelersNr;
	
	
	public Bestuurslid() {
		
	}
	
	public Bestuurslid(int bestuurslidNr, Calendar beginDatum, Calendar eindDatum, String functie) {
		this.bestuurslidNr = bestuurslidNr;
		this.beginDatum = beginDatum;
		this.eindDatum = eindDatum;
		this.functie = functie;
	}

	@Override
	public String toString() {
		return "Bestuurslid: \nBestuurslidnummer: " + bestuurslidNr + "\nBegin datum: " + beginDatum + "\nEind datum: " + eindDatum
				+ "\nFunctie: " + functie;
	}

	public int getBestuurslidNr() {
		return bestuurslidNr;
	}

	public void setBestuurslidNr(int bestuurslidNr) {
		this.bestuurslidNr = bestuurslidNr;
	}

	public Calendar getBeginDatum() {
		return beginDatum;
	}

	public void setBeginDatum(Calendar beginDatum) {
		this.beginDatum = beginDatum;
	}

	public Calendar getEindDatum() {
		return eindDatum;
	}

	public void setEindDatum(Calendar eindDatum) {
		this.eindDatum = eindDatum;
	}

	public String getFunctie() {
		return functie;
	}

	public void setFunctie(String functie) {
		this.functie = functie;
	}
}

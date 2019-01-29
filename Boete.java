package domain.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name = "Boete")
public class Boete {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Betalingsnummer", updatable = false, nullable = false)
	private int betalingsNr;
	
	@Column (name = "Datum")
	@Temporal (TemporalType.DATE)
	private Calendar datum;
	
	@Column (name = "Bedrag")
	private int bedrag;
	
	@ManyToOne
	@JoinColumn (name = "Spelersnummer", foreignKey = @ForeignKey (name = "Speler_Spelersnummer2"))
	private Speler spelersNr;
	
	@ManyToOne
	@JoinColumn (name = "Teamnummer", foreignKey = @ForeignKey (name = "Team_Teamnummer3"))
	private Team teamNr;
	
	
	public Boete() {
		
	}
	
	public Boete(int betalingsNr, Calendar datum, int bedrag) {
		this.betalingsNr = betalingsNr;
		this.datum = datum;
		this.bedrag = bedrag;
	}

	@Override
	public String toString() {
		return "Boete: \nBetalingsnummer: " + betalingsNr + "\nDatum: " + datum + "\nBedrag: " + bedrag;
	}

	public int getBetalingsNr() {
		return betalingsNr;
	}

	public void setBetalingsNr(int betalingsNr) {
		this.betalingsNr = betalingsNr;
	}

	public Calendar getDatum() {
		return datum;
	}

	public void setDatum(Calendar datum) {
		this.datum = datum;
	}

	public int getBedrag() {
		return bedrag;
	}

	public void setBedrag(int bedrag) {
		this.bedrag = bedrag;
	}
}

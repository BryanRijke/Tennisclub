package domain.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name = "Speler")
public class Speler {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Spelersnummer")
	private int spelersNr;
	
	@Column (name = "Achternaam")
	private String naam;
	
	@Column (name = "Voorletters")
	private String voorletters;
	
	@Column (name = " Voorvoegsels")
	private String voorvoegsels;
	
	@Column (name = " Geboortedatum")
	private Calendar gebDatum;
	
	@Column (name = "Geslacht")
	private String geslacht;
	
	@Column (name = "Jaar_van_toetreden")
	@Temporal (TemporalType.DATE)
	private Calendar jaarToe;
	
	@Column (name = "Straat")
	private String straat;
	
	@Column (name = "Huisnummer")
	private int huisNr;
	
	@Column (name = "Postcode")
	private String postCode;
	
	@Column (name = "Woonplaats")
	private String plaats;
	
	@Column (name = "Telefoonnummer")
	private String telefoon;
	
	@Column (name = "Bondsnummer")
	private int bondsNr;
	
	@OneToOne (mappedBy = "spelersNr", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Bestuurslid bestuurslidNr;
	
	@ManyToOne
	@JoinColumn (name = "Teamnummer", foreignKey = @ForeignKey (name = "Team_Teamnummer2"))
	private Team teamNr;
	
	@OneToMany (mappedBy = "spelersNr")
	private List<Boete> boetes = new ArrayList<Boete>();
	
	
	public Speler() {
		
	}
	
	public Speler(int spelersNr, String naam, String voorletters, String voorvoegsels, Calendar gebDatum, 
			String geslacht, Calendar jaarToe, String straat, int huisNr, String postCode, String plaats, String telefoon, int bondsNr) {
		this.spelersNr = spelersNr;
		this.naam = naam;
		this.voorletters = voorletters;
		this.voorvoegsels = voorvoegsels;
		this.gebDatum = gebDatum;
		this.geslacht = geslacht;
		this.jaarToe = jaarToe;
		this.straat = straat;
		this.huisNr = huisNr;
		this.postCode = postCode;
		this.plaats = plaats;
		this.telefoon = telefoon;
		this.bondsNr = bondsNr;
	}

	@Override
	public String toString() {
		return "Speler: \nSpelersnummer: " + spelersNr + "\nNaam: " + naam + "\nVoorletters: " + voorletters + "\nVoorvoegsels: "
				+ voorvoegsels + "\nGeboortedatum: " + gebDatum + "\nGeslacht: " + geslacht + "\nJaar van toelating: " + jaarToe
				+ "\nStraat: " + straat + "\nHuisnummer: " + huisNr + "\nPostcode: " + postCode + "\nPlaats: " + plaats
				+ "\nTelefoon: " + telefoon + "\nBondsnummer: " + bondsNr;
	}

	public int getSpelersNr() {
		return spelersNr;
	}

	public void setSpelersNr(int spelersNr) {
		this.spelersNr = spelersNr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getVoorvoegsels() {
		return voorvoegsels;
	}

	public void setVoorvoegsels(String voorvoegsels) {
		this.voorvoegsels = voorvoegsels;
	}

	public Calendar getGebDatum() {
		return gebDatum;
	}

	public void setGebDatum(Calendar gebDatum) {
		this.gebDatum = gebDatum;
	}

	public String getGeslacht() {
		return geslacht;
	}

	public void setGeslacht(String geslacht) {
		this.geslacht = geslacht;
	}

	public Calendar getJaarToe() {
		return jaarToe;
	}

	public void setJaarToe(Calendar jaarToe) {
		this.jaarToe = jaarToe;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public int getHuisNr() {
		return huisNr;
	}

	public void setHuisNr(int huisNr) {
		this.huisNr = huisNr;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPlaats() {
		return plaats;
	}

	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}

	public String getTelefoon() {
		return telefoon;
	}

	public void setTelefoon(String telefoon) {
		this.telefoon = telefoon;
	}

	public int getBondsNr() {
		return bondsNr;
	}

	public void setBondsNr(int bondsNr) {
		this.bondsNr = bondsNr;
	}
}

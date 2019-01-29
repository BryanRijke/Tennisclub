package domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity (name = "Wedstrijd")
public class Wedstrijd {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Wedstrijdnummer", updatable = false, nullable = false)
	private int wedstrijdNr;
	
	@Column (name = "Teamnummer")
	private int teamNr;
	
	@Column (name = "Spelersnummer")
	private int spelersNr;
	
	@Column (name = "Gewonnen")
	private int gewonnen;
	
	@Column (name = "Verloren")
	private int verloren;
	
	@ManyToMany
	@JoinTable (name = "Teams_Wedstrijden",
		joinColumns = @JoinColumn (name = "Wedstrijdnummer", foreignKey = @ForeignKey (name = "Wedstrijd_Wedstrijdnummer")),
		inverseJoinColumns = @JoinColumn (name = "Teamnummer", foreignKey = @ForeignKey (name = "Team_Teamnummer1")))
	private Set<Team> teams = new HashSet<>();
	
	
	public Wedstrijd() {
		
	}
	
	public Wedstrijd(int wedstrijdNr, int teamNr, int spelersNr, int gewonnen, int verloren) {
		this.wedstrijdNr = wedstrijdNr;
		this.teamNr = teamNr;
		this.spelersNr = spelersNr;
		this.gewonnen = gewonnen;
		this.verloren = verloren;
	}

	@Override
	public String toString() {
		return "Wedstrijd: \nWedstrijdnummer: " + wedstrijdNr + "\nTeamnummer: " + teamNr + "\nSpelersnummer: " + spelersNr
				+ "\nGewonnen: " + gewonnen + "\nVerloren: " + verloren;
	}

	public int getWedstrijdNr() {
		return wedstrijdNr;
	}

	public void setWedstrijdNr(int wedstrijdNr) {
		this.wedstrijdNr = wedstrijdNr;
	}

	public int getTeamNr() {
		return teamNr;
	}

	public void setTeamNr(int teamNr) {
		this.teamNr = teamNr;
	}

	public int getSpelersNr() {
		return spelersNr;
	}

	public void setSpelersNr(int spelersNr) {
		this.spelersNr = spelersNr;
	}

	public int getGewonnen() {
		return gewonnen;
	}

	public void setGewonnen(int gewonnen) {
		this.gewonnen = gewonnen;
	}

	public int getVerloren() {
		return verloren;
	}

	public void setVerloren(int verloren) {
		this.verloren = verloren;
	}
}

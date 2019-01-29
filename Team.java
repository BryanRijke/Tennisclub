package domain.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity (name = "Team")
public class Team {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Teamnummer", updatable = false, nullable = false)
	private int teamNr;
	
	@Column (name = "Aanvoerdersnummer")
	private int aanvoerderNr;
	
	@Column (name = "Divisie")
	private String divisie;
	
	@ManyToMany (mappedBy = "teams")
	private Set<Wedstrijd> wedstrijden = new HashSet<>();
	
	@OneToMany (mappedBy = "teamNr")
	private List<Speler> spelers = new ArrayList<Speler>();
	
	@OneToMany (mappedBy = "teamNr")
	private List<Boete> boetes = new ArrayList<Boete>();
	
	
	public Team() {
		
	}
	
	public Team(int teamNr, int aanvoerderNr, String divisie) {
		this.teamNr = teamNr;
		this.aanvoerderNr = aanvoerderNr;
		this.divisie = divisie;
	}

	@Override
	public String toString() {
		return "Team: \nTeamnummer: " + teamNr + "\nAanvoerdersnummer: " + aanvoerderNr + "\nDivisie: " + divisie;
	}

	public int getTeamNr() {
		return teamNr;
	}

	public void setTeamNr(int teamNr) {
		this.teamNr = teamNr;
	}

	public int getAanvoerderNr() {
		return aanvoerderNr;
	}

	public void setAanvoerderNr(int aanvoerderNr) {
		this.aanvoerderNr = aanvoerderNr;
	}

	public String getDivisie() {
		return divisie;
	}

	public void setDivisie(String divisie) {
		this.divisie = divisie;
	}
}

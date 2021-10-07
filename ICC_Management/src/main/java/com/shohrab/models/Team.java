
package com.shohrab.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="team_tbl")
public class Team extends BaseModel{
	
	@Column(name="team_name",unique = true, nullable = false, updatable = false)
	private String teamName;

	@OneToOne
	@JoinColumn(name = "c_id")
	private Country country;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Players> players;
	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(String teamName) {
		super();
		
		this.teamName = teamName;
	}

	

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	


//	public List<Players> getPlayers() {
//		return players;
//	}
//
//	public void setPlayers(List<Players> players) {
//		this.players = players;
//	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Team [teamName=" + teamName + "]";
	}
}

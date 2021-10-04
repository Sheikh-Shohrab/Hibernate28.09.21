
package com.shohrab.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="team")
public class Team extends BaseModel{
	
	@Column(name="team_name",unique = true, nullable = false, updatable = false)
	private String teamName;

	@OneToOne
	@JoinColumn(name = "c_id")
	private Country countryId;
	
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
	
	public Country getCountry() {
		return countryId;
	}

	public void setCountry(Country country) {
		this.countryId = country;
	}

	@Override
	public String toString() {
		return "Team [teamName=" + teamName + "]";
	}
}

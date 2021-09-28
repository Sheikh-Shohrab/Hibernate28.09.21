
package com.shohrab.models;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="team")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="team_id", nullable = false, unique = true)
	private long id;
	
	@Column(name="team_name")
	private String teamName;
	

	private List<Players> players;
	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(long id, String teamName) {
		super();
		this.id = id;
		this.teamName = teamName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	public List<Players> getPlayers() {
		return players;
	}

	public void setPlayers(List<Players> players) {
		this.players = players;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + "]";
	}

	public String getTeamCode() {
		// TODO Auto-generated method stub
		return null;
	}

}

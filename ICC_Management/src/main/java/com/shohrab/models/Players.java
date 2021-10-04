package com.shohrab.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="players")
public class Players extends BaseModel{
	
	@Column(name = "player_type", nullable = false, updatable = false)
	private String playerType;
	
	@OneToOne
	@JoinColumn(name = "team_id")
	private Team team;

	

	public Players() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Players(String playerType) {
		super();
		
		this.playerType = playerType;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}
	
	@Override
	public String toString() {
		return "Players [playerType=" + playerType + "]";
	}

	
}

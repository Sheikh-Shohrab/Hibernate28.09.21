package com.shohrab.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="player_tbl")
public class Players extends BaseModel{
	
	@Column(name = "player_type", nullable = false, updatable = false)
	private String playerType;
	
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
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

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Players(String playerType, Team team, User user) {
		super();
		this.playerType = playerType;
		this.team = team;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Players [playerType=" + playerType + "]";
	}

	
}

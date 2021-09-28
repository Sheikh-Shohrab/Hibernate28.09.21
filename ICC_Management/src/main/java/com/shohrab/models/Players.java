package com.shohrab.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="players")
public class Players {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "player_id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "player_type")
	private String playerType;

	public Players() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Players(long id, String playerType) {
		super();
		this.id = id;
		this.playerType = playerType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}
	
	@Override
	public String toString() {
		return "Players [id=" + id + ", playerType=" + playerType + "]";
	}

	
}

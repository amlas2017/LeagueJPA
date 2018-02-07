package com.philippe.league.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LJ_PLAYER")
public class Player extends Identifier {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1248851851826750062L;

	private String firstName;
	private int jerseyNumber;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(String name, String firstName, int jerseyNumber, Team team) {
		super(name);
		this.firstName = firstName;
		this.jerseyNumber = jerseyNumber;
		this.team = team;
	}

	@ManyToOne
	private Team team;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", jerseyNumber=" + jerseyNumber + ", team=" + team + "]";
	}
	
	

}

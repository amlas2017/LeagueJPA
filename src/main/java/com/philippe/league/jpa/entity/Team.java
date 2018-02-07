package com.philippe.league.jpa.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LJ_TEAM")
public class Team extends Identifier {

	/**
	 * 
	 */
	private static final long serialVersionUID = -728929211028398201L;

	private String division;

	@ManyToOne
	private League league;

	@OneToMany(mappedBy = "team")
	private Collection<Player> players;

	public Collection<Player> getPlayers() {
		return players;
	}

	public Team(String name, String division, League league) {
		super(name);
		this.division = division;
		this.league = league;
	}
	
	

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPlayers(Collection<Player> players) {
		this.players = players;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	

	
	
	

}

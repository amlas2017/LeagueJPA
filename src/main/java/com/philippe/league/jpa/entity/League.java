package com.philippe.league.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LJ_LEAGUE")
public class League extends Identifier  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8027260952217707993L;
	
	private String sport;	
	
	public League() {
		
	}

	public League(String name,String sport) {
		super(name);
		this.sport = sport;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	@Override
	public String toString() {
		return super.toString()+"League [sport=" + sport + "]";
	}
	
	
	
	

}

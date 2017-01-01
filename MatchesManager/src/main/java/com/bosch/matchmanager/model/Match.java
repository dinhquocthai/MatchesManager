package com.bosch.matchmanager.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Match implements Serializable{
	private static final long serialVersionUID = -7383459564049128351L;

	@Id
    @GeneratedValue
    @Column
    private int id;
	
	@ManyToOne
	@JoinColumn(name="team1Id", referencedColumnName="teamId")
	private Team team1Id;
	
	@ManyToOne()
	@JoinColumn(name="team2Id", referencedColumnName="teamId")
	private Team team2Id;

	@Column
	private String score;
	
	public Match(){
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Team getTeam1Id() {
		return team1Id;
	}

	public void setTeam1Id(Team team1Id) {
		this.team1Id = team1Id;
	}

	public Team getTeam2Id() {
		return team2Id;
	}

	public void setTeam2Id(Team team2Id) {
		this.team2Id = team2Id;
	}
}

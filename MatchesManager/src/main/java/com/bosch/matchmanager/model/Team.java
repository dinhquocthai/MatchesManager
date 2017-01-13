package com.bosch.matchmanager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Team implements Serializable{
	
	private static final long serialVersionUID = -385592351474892135L;
	
	@Id
    @GeneratedValue
    @Column
	private int teamId;
	
	@Column
	private String teamName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "team1Id", orphanRemoval=true)
	private List<Match> team1;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "team2Id",   orphanRemoval=true)
	private List<Match> team2;
	
	public Team(){
		super();
	}
	
	public Team(int teamId, String teamName){
		//super();
		this.setId(teamId);
		this.setTeamName(teamName);
	}
	
	public int getTeamId() {
		return teamId;
	}

	public void setId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
}

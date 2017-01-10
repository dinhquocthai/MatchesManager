package com.bosch.matchmanager.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.bosch.matchmanager.model.Team;

@Component
public class TeamDao {
	@PersistenceContext
	private EntityManager em;
	
	@PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
	
	public List<Team> getAllTeams(){
		TypedQuery<Team> query = em.createQuery("SELECT t FROM Team t", Team.class);
		return query.getResultList();
	}
	
	public String getTeamNameById(int id){
		Team team = em.getReference(Team.class, id);
		return team.getTeamName();
	}

	public int getTeamIdByName(String teamName){
		for(Team t : this.getAllTeams()){
			if(t.getTeamName().toLowerCase().equals(teamName.toLowerCase()))
				return t.getTeamId();
		}
		return 0;
	}
	
	public Team getTeamById(int id){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Team team = entityManager.find(Team.class, id);
		return team;
	}
	
	public Map<Integer, String> teamMap(){
		List<Team> teams = this.getAllTeams();
		Map<Integer, String> map;
		map = new HashMap();
		for(Team team : teams){
			map.put(team.getTeamId(), team.getTeamName());
		}
		return map;
	}
}

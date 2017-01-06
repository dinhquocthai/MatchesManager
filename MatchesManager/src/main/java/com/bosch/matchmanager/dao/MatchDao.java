package com.bosch.matchmanager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bosch.matchmanager.model.Match;
import com.bosch.matchmanager.model.Team;

@Component
public class MatchDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
	
	public List<Match> getAllMatches(){
		TypedQuery<Match> query = em.createQuery("SELECT m FROM Match m", Match.class);
		return query.getResultList();
	}
	
	public List<Match> getMatchesByTeam (int teamId){
		TypedQuery<Match> query = em.createQuery("SELECT m FROM Match m WHERE m.team1Id = " + teamId + "OR m.team2Id = " + teamId, Match.class);
		return query.getResultList();
	}
	
	public boolean matchExisted (int team1Id, int team2Id){
		TypedQuery<Match> query = em.createQuery(
				"SELECT m FROM Match m WHERE (m.team1Id = " + team1Id 
				+ "AND m.team2Id = " + team2Id + ") OR (m.team1Id = " 
				+ team2Id + "AND m.team2Id = " + team1Id + ")", Match.class);
		if(query.getResultList().isEmpty())
			return false;
		return true;
	}
	
	public void delete (int matchId){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Match m = entityManager.find(Match.class, matchId);
		entityManager.getTransaction().begin();
		entityManager.remove(m);
		entityManager.getTransaction().commit();
	}
	
	public void save(Match match){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(match);
		entityManager.flush();
		entityManager.getTransaction().commit();
	}
	
	public void update(int matchId, String score){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Match m = entityManager.find(Match.class, matchId);
		entityManager.getTransaction().begin();
		entityManager.createQuery("UPDATE Match set score = '" + score + "' WHERE id = " + matchId ).executeUpdate();
		entityManager.getTransaction().commit();
	}

}

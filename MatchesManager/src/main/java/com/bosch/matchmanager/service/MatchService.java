package com.bosch.matchmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosch.matchmanager.dao.MatchDao;
import com.bosch.matchmanager.model.Match;


@Service
public class MatchService {
	@Autowired
	private MatchDao matchDAO;
	
	public List<Match> getAllMatches(){
		return matchDAO.getAllMatches();
	}
	
	public void save(Match match){
		matchDAO.save(match);
	}
	
	
	public void delete(int matchId){
		matchDAO.delete(matchId);
	}
	
	public List<Match>getMatchesByTeam(int teamId){
		return matchDAO.getMatchesByTeam(teamId);
	}
	
	public boolean matchExisted(int team1Id, int team2Id){
		return matchDAO.matchExisted(team1Id, team2Id);
	}
}

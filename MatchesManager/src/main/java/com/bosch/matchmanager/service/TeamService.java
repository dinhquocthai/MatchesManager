package com.bosch.matchmanager.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bosch.matchmanager.dao.TeamDao;
import com.bosch.matchmanager.model.Team;
@Service
public class TeamService {
	@Autowired
	private TeamDao teamDAO;
	
	public List<Team> getAllTeams(){
		return teamDAO.getAllTeams();
	}
	
	public String getTeamNameById(int id){
		return teamDAO.getTeamNameById(id);
	}
	
	public Team getTeamById(int id){
		return teamDAO.getTeamById(id);
	}
	
	public Map<Integer, String> teamMap(){
		return teamDAO.teamMap();
	}
	
	public int getTeamIdByName(String teamName){
		return teamDAO.getTeamIdByName(teamName);
	}
}

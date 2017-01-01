package com.bosch.matchmanager.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bosch.matchmanager.model.Match;
import com.bosch.matchmanager.model.Team;
import com.bosch.matchmanager.service.MatchService;
import com.bosch.matchmanager.service.TeamService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MatchController {
	
	private static final Logger logger = LoggerFactory.getLogger(MatchController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model){
//		List<Match> matches = matchService.getAllMatches();
//		model.addAttribute("matches", matches);
//		return "home";
		
//		List<Team> teams = teamService.getAllTeams();
//		model.addAttribute("teams", teams);

		
		
		List<Match> matches = matchService.getAllMatches();
		Map<Integer, String> map = teamService.teamMap();
		
		//System.out.println(map.get(matches.get(1).getTeam1Id().getTeamId()));
		model.addAttribute("matches", matches);
		model.addAttribute("map", map);
		List<Team> teams = teamService.getAllTeams();
		
		for(Team t : teams){
			System.out.println(t.getTeamName());
		}
		return "home";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addMatch() {
		
		Team team1 = teamService.getTeamById(1);
		System.out.println(team1.getTeamName());
		
		Team team2 = teamService.getTeamById(2);
		
//		Team team1 = new Team();
//		team1.setTeamName("Vietnam");
//		Team team2 = new Team();
//		team1.setTeamName("Singapore");
		
		Match m = new Match();
		m.setTeam1Id(team1);
		m.setTeam2Id(team2);
		m.setScore("2-0");
		
		matchService.save(m);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete/{matchId}", method = RequestMethod.GET)
	public String removeUser(@PathVariable("matchId") int matchId) {
		
		matchService.delete(matchId);
		System.out.println(matchId);
		return "redirect:/";
	}
	
	
}

package com.bosch.matchmanager.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bosch.matchmanager.model.Account;
import com.bosch.matchmanager.model.Match;
import com.bosch.matchmanager.model.Team;
import com.bosch.matchmanager.service.AccountService;
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
	@Autowired
	private MatchService matchService;

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private AccountService accountService;
	
	private boolean login = false;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Match> matches = matchService.getAllMatches();
		Map<Integer, String> map = teamService.teamMap();

		// System.out.println(map.get(matches.get(1).getTeam1Id().getTeamId()));
		model.addAttribute("matches", matches);
		model.addAttribute("map", map);
		model.addAttribute("login", this.login);
		List<Team> teams = teamService.getAllTeams();

		for (Team t : teams) {
			System.out.println(t.getTeamName());
		}
		
		List<Account> accounts = accountService.getAllAccounts();
		for (Account a : accounts){
			System.out.println(a.getUsername());
		}
		return "home";
	}

	@RequestMapping(value = "/add_match_page", method = RequestMethod.POST)
	public String goToAddPage(Model model) {
		List<Team> teams = teamService.getAllTeams();
		model.addAttribute("teams", teams);
		return "create";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMatch(@RequestParam("team1Id") int team1Id, @RequestParam("team2Id") int team2Id, @RequestParam("score") String score, Model model) {

		Team team1 = teamService.getTeamById(team1Id);
		System.out.println(team1.getTeamName());

		Team team2 = teamService.getTeamById(team2Id);
		System.out.println(team2);
		
		if(team1Id == team2Id){
			model.addAttribute("alert", "You must choose 2 different team");
			model.addAttribute("teams", teamService.getAllTeams());
			return "create";
		}
		
		if(matchService.matchExisted(team1Id, team2Id)){
			model.addAttribute("alert", "This match is existed, please choose another team.");
			model.addAttribute("teams", teamService.getAllTeams());
			return "create";
		}
		
		Match m = new Match();
		m.setTeam1Id(team1);
		m.setTeam2Id(team2);
		m.setScore(score);

		matchService.save(m);

		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{matchId}", method = RequestMethod.GET)
	public String removeMatch(@PathVariable("matchId") int matchId) {

		matchService.delete(matchId);
		
		return "redirect:/";
	}

	@RequestMapping(value = "/update_match_page", method = RequestMethod.POST)
	public String updateMatch(@RequestParam("team1Id") int team1Id, @RequestParam("team2Id") int team2Id, @RequestParam("score") String score, @RequestParam("matchId") int matchId, Model model) {
		model.addAttribute("team1Name", teamService.getTeamById(team1Id).getTeamName());
		model.addAttribute("team2Name", teamService.getTeamById(team2Id).getTeamName());
		model.addAttribute("score", score);
		model.addAttribute("matchId", matchId);
		return "update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam("score") String score , @RequestParam("matchId") int matchId){
		matchService.update(matchId, score);
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/search_page", method = RequestMethod.POST)
	public String searchMatch(Model model){
		model.addAttribute("teams", teamService.getAllTeams());
		return "search";
	}

	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String search(@RequestParam("teamName") String teamName, Model model){
		if(teamName.trim().equals("") || teamName.equals("")){
			List<Match> matches = matchService.getAllMatches();
			Map<Integer, String> map = teamService.teamMap();
			model.addAttribute("matches", matches);
			model.addAttribute("map", map);
			model.addAttribute("action", "search");
			model.addAttribute("teams", teamService.getAllTeams());
			return "search";
		}
		
		if(teamService.getTeamIdByName(teamName) == 0){
			model.addAttribute("alert", "No matches found!");
			model.addAttribute("teams", teamService.getAllTeams());
			return "search";
		}
		List<Match> matches = matchService.getMatchesByTeam(teamService.getTeamIdByName(teamName));
		Map<Integer, String> map = teamService.teamMap();
		model.addAttribute("matches", matches);
		model.addAttribute("map", map);
		model.addAttribute("action", "search");
		model.addAttribute("teams", teamService.getAllTeams());
		return "search";
	}
	
	@RequestMapping(value="/login_page", method = RequestMethod.POST)
	public String loginPage(){
		return "login";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST) 
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model){
		if(!accountService.checkAccount(username, password)){
			model.addAttribute("alert", "Wrong username or password");
			return "login";
		}
		
		this.login=true;
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout(){
		this.login = false;
		return "redirect:/";
	}
}

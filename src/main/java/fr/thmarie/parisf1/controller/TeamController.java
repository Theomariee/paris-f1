package fr.thmarie.parisf1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.thmarie.parisf1.model.Team;
import fr.thmarie.parisf1.payload.TeamRequest;
import fr.thmarie.parisf1.payload.response.TeamResponse;
import fr.thmarie.parisf1.service.TeamService;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
	@Autowired
	private TeamService teamService;

	@GetMapping
	public ResponseEntity<List<TeamResponse>> getAllTeams() {
		List<TeamResponse> allTeams = teamService.getAllTeams();
		return new ResponseEntity<>(allTeams, HttpStatus.OK);
	}

	@GetMapping("/{name}")
	public ResponseEntity<Team> getTeam(@PathVariable(name = "name") String name) {
		Team retrievedTeam = teamService.getTeam(name);
		return new ResponseEntity<>(retrievedTeam, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Team> addTeam(@Valid @RequestBody TeamRequest teamRequest) {
		Team newTeam = teamService.addTeam(teamRequest);
		return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
	}
}

package fr.thmarie.parisf1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.thmarie.parisf1.model.Team;
import fr.thmarie.parisf1.payload.TeamRequest;
import fr.thmarie.parisf1.service.TeamService;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
	@Autowired
	private TeamService teamService;

	@PostMapping
	public ResponseEntity<Team> addTeam(@Valid @RequestBody TeamRequest teamRequest) {
		return teamService.addTeam(teamRequest);
	}
}

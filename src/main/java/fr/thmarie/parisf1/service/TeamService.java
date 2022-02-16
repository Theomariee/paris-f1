package fr.thmarie.parisf1.service;

import org.springframework.http.ResponseEntity;

import fr.thmarie.parisf1.model.Team;
import fr.thmarie.parisf1.payload.TeamRequest;

public interface TeamService {

	ResponseEntity<Team> addTeam(TeamRequest teamRequest);
}

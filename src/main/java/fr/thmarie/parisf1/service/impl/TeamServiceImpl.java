package fr.thmarie.parisf1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.thmarie.parisf1.model.Team;
import fr.thmarie.parisf1.payload.TeamRequest;
import fr.thmarie.parisf1.repository.TeamRepository;
import fr.thmarie.parisf1.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	TeamRepository teamRepository;

	@Override
	public ResponseEntity<Team> addTeam(TeamRequest teamRequest) {
		Team team = new Team();
		team.setName(teamRequest.getName());

		Team newTeam = teamRepository.save(team);
		return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
	}
}

package fr.thmarie.parisf1.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.thmarie.parisf1.exception.ResourceNotFoundException;
import fr.thmarie.parisf1.model.Team;
import fr.thmarie.parisf1.payload.TeamRequest;
import fr.thmarie.parisf1.payload.response.TeamResponse;
import fr.thmarie.parisf1.repository.TeamRepository;
import fr.thmarie.parisf1.service.TeamService;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	@Autowired
	TeamRepository teamRepository;

	@Override
	public List<TeamResponse> getAllTeams() {
		List<TeamResponse> allTeams = new ArrayList<>();

		for (Team returnedTeam : teamRepository.findAll()) {
			TeamResponse teamResponse = new TeamResponse();

			teamResponse.setName(returnedTeam.getName());
			teamResponse.setDrivers(returnedTeam.getDrivers());

			allTeams.add(teamResponse);
		}

		return allTeams;
	}

	@Override
	public Team getTeam(String name) {
		Team team = teamRepository.findById(name).orElseThrow(
				() -> new ResourceNotFoundException("Team", "name", name));

		return team;
	}

	@Override
	public Team addTeam(TeamRequest teamRequest) {
		Team team = new Team();
		team.setName(teamRequest.getName());

		Team newTeam = teamRepository.save(team);

		return newTeam;
	}
}

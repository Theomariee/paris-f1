package fr.thmarie.parisf1.service;

import java.util.List;

import fr.thmarie.parisf1.model.Team;
import fr.thmarie.parisf1.payload.TeamRequest;
import fr.thmarie.parisf1.payload.response.TeamResponse;

public interface TeamService {

	List<TeamResponse> getAllTeams();

	Team getTeam(String name);

	Team addTeam(TeamRequest teamRequest);
}

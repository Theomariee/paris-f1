package fr.thmarie.parisf1.service;

import java.util.List;

import fr.thmarie.parisf1.model.Player;
import fr.thmarie.parisf1.payload.PlayerRequest;
import fr.thmarie.parisf1.payload.response.PlayerResponse;

public interface PlayerService {

	List<PlayerResponse> getAllPlayers();

	Player getPlayer(Long id);

	Player addPlayer(PlayerRequest playerRequest);

}

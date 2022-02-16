package fr.thmarie.parisf1.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.thmarie.parisf1.exception.ResourceNotFoundException;
import fr.thmarie.parisf1.model.Player;
import fr.thmarie.parisf1.payload.PlayerRequest;
import fr.thmarie.parisf1.payload.response.PlayerResponse;
import fr.thmarie.parisf1.repository.PlayerRepository;
import fr.thmarie.parisf1.service.PlayerService;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	PlayerRepository playerRepository;

	@Override
	public List<PlayerResponse> getAllPlayers() {
		List<PlayerResponse> allPlayers = new ArrayList<>();

		for (Player returnedPlayer : playerRepository.findAll()) {
			PlayerResponse playerResponse = new PlayerResponse();

			playerResponse.setId(returnedPlayer.getId());
			playerResponse.setUsername(returnedPlayer.getUsername());
			playerResponse.setScore(returnedPlayer.getScore());

			allPlayers.add(playerResponse);
		}

		return allPlayers;
	}

	@Override
	public Player getPlayer(Long id) {
		Player player = playerRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Player", "id", id));

		return player;
	}

	@Override
	public Player addPlayer(PlayerRequest playerRequest) {
		Player player = new Player();
		player.setUsername(playerRequest.getUsername());
		player.setPassword(playerRequest.getPassword());

		Player newPlayer = playerRepository.save(player);

		return newPlayer;
	}
}

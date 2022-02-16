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

import fr.thmarie.parisf1.model.Player;
import fr.thmarie.parisf1.payload.PlayerRequest;
import fr.thmarie.parisf1.payload.response.PlayerResponse;
import fr.thmarie.parisf1.service.PlayerService;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	@GetMapping
	public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
		List<PlayerResponse> allPlayers = playerService.getAllPlayers();
		return new ResponseEntity<>(allPlayers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Player> getPlayer(@PathVariable(name = "id") Long id) {
		Player retrievedPlayer = playerService.getPlayer(id);
		return new ResponseEntity<>(retrievedPlayer, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Player> addPlayer(@Valid @RequestBody PlayerRequest playerRequest) {
		Player newPlayer = playerService.addPlayer(playerRequest);
		return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
	}
}

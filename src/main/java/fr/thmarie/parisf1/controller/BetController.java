package fr.thmarie.parisf1.controller;

import fr.thmarie.parisf1.model.Bet;
import fr.thmarie.parisf1.model.Driver;
import fr.thmarie.parisf1.payload.BetRequest;
import fr.thmarie.parisf1.payload.DriverRequest;
import fr.thmarie.parisf1.payload.response.DriverResponse;
import fr.thmarie.parisf1.service.BetService;
import fr.thmarie.parisf1.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bets")
public class BetController {
	@Autowired
	private BetService betService;

	@PostMapping
	public ResponseEntity<Bet> addBet(@Valid @RequestBody BetRequest betRequest) {
		Bet newBet = betService.addBet(betRequest);
		return new ResponseEntity<>(newBet, HttpStatus.CREATED);
	}
}

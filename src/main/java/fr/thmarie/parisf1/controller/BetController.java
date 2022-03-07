package fr.thmarie.parisf1.controller;

import fr.thmarie.parisf1.model.Bet;
import fr.thmarie.parisf1.payload.BetRequest;
import fr.thmarie.parisf1.payload.response.BetResponse;
import fr.thmarie.parisf1.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bets")
public class BetController {
    @Autowired
    private BetService betService;

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<BetResponse>> getAllBets(@RequestParam(name = "grandPrixEventId", required = false) Long fromDate) {
        List<BetResponse> allBets = betService.getAllBets();
        return new ResponseEntity<>(allBets, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Bet> addBet(@Valid @RequestBody BetRequest betRequest) {
        Bet newBet = betService.addBet(betRequest);
        return new ResponseEntity<>(newBet, HttpStatus.CREATED);
    }
}

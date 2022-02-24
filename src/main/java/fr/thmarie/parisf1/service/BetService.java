package fr.thmarie.parisf1.service;

import fr.thmarie.parisf1.model.Bet;
import fr.thmarie.parisf1.model.Driver;
import fr.thmarie.parisf1.payload.BetRequest;
import fr.thmarie.parisf1.payload.DriverRequest;
import fr.thmarie.parisf1.payload.response.DriverResponse;

import java.util.List;

public interface BetService {

	Bet addBet(BetRequest betRequest);

}

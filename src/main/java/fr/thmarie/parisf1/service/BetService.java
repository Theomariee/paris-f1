package fr.thmarie.parisf1.service;

import fr.thmarie.parisf1.model.Bet;
import fr.thmarie.parisf1.payload.BetRequest;
import fr.thmarie.parisf1.payload.response.BetResponse;

import java.util.List;

public interface BetService {

    List<BetResponse> getAllBets();

    List<BetResponse> getAllBetsForGrandPrixEvent(Long grandPrixEventId);

    List<BetResponse> getAllBetsForGrandPrixEventAndPlayer(Long grandPrixEventId, Long playerId);

    Bet addBet(BetRequest betRequest);

}

package fr.thmarie.parisf1.service.impl;

import fr.thmarie.parisf1.model.Bet;
import fr.thmarie.parisf1.payload.BetRequest;
import fr.thmarie.parisf1.payload.response.BetResponse;
import fr.thmarie.parisf1.repository.BetRepository;
import fr.thmarie.parisf1.repository.DriverRepository;
import fr.thmarie.parisf1.repository.GrandPrixEventRepository;
import fr.thmarie.parisf1.repository.PlayerRepository;
import fr.thmarie.parisf1.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BetServiceImpl implements BetService {
    @Autowired
    BetRepository betRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GrandPrixEventRepository grandPrixEventRepository;

    @Autowired
    DriverRepository driverRepository;

    @Override
    public List<BetResponse> getAllBets() {
        List<Bet> allBetsFromDb = betRepository.findAll();
        return getBetResponsesFromBetList(allBetsFromDb);
    }

    @Override
    public List<BetResponse> getAllBetsForGrandPrixEvent(Long grandPrixEventId) {
        List<Bet> allBetsFromDb = betRepository.findByGrandPrixEventId(grandPrixEventId);
        return getBetResponsesFromBetList(allBetsFromDb);
    }

    @Override
    public List<BetResponse> getAllBetsForGrandPrixEventAndPlayer(Long grandPrixEventId, Long playerId) {
        List<Bet> allBetsFromDb = betRepository.findByGrandPrixEventIdAndPlayerId(grandPrixEventId, playerId);
        return getBetResponsesFromBetList(allBetsFromDb);
    }

    @Override
    public Bet addBet(BetRequest betRequest) {
        Bet bet = new Bet();
        bet.setPlayer(playerRepository.findById(betRequest.getPlayerId()).get());
        bet.setGrandPrixEvent(grandPrixEventRepository.findById(betRequest.getGrandPrixEventId()).get());

        Bet newBet = betRepository.save(bet);

        return newBet;
    }

    private List<BetResponse> getBetResponsesFromBetList(List<Bet> allBetsFromDb) {
        List<BetResponse> allBets = new ArrayList<>();

        for (Bet returnedBet : allBetsFromDb) {
            BetResponse betResponse = new BetResponse();

            betResponse.setId(returnedBet.getId());
            betResponse.setPlayer(returnedBet.getPlayer());
            betResponse.setGrandPrixEvent(returnedBet.getGrandPrixEvent());
            betResponse.setBetRacePositions(returnedBet.getRacePositions());

            allBets.add(betResponse);
        }

        return allBets;
    }
}

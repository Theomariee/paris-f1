package fr.thmarie.parisf1.service.impl;

import fr.thmarie.parisf1.model.Bet;
import fr.thmarie.parisf1.model.Driver;
import fr.thmarie.parisf1.payload.BetRequest;
import fr.thmarie.parisf1.repository.BetRepository;
import fr.thmarie.parisf1.repository.DriverRepository;
import fr.thmarie.parisf1.repository.GrandPrixEventRepository;
import fr.thmarie.parisf1.repository.PlayerRepository;
import fr.thmarie.parisf1.service.BetService;
import fr.thmarie.parisf1.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    public Bet addBet(BetRequest betRequest) {
        Bet bet = new Bet();
        bet.setPlayer(playerRepository.getById(betRequest.getPlayerId()));
        bet.setGrandPrixEvent(grandPrixEventRepository.getById(betRequest.getGrandPrixEventId()));
        bet.setDriver(driverRepository.getById(betRequest.getDriverId()));
        bet.setRacePosition(betRequest.getRacePosition());

		Bet newBet = betRepository.save(bet);

        return newBet;
    }
}

package fr.thmarie.parisf1.payload.response;

import fr.thmarie.parisf1.model.Bet;
import fr.thmarie.parisf1.model.BetRacePosition;
import fr.thmarie.parisf1.model.Driver;
import fr.thmarie.parisf1.model.GrandPrixEvent;
import fr.thmarie.parisf1.model.Player;
import lombok.Data;

import java.util.List;

@Data
public class BetRacePositionResponse {

	private Bet bet;

	private Driver driver;

	private Long racePosition;

}
